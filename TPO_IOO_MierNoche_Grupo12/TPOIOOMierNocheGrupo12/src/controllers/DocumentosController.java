package controllers;



import controllers.exceptions.ProveedorInexistenteException;
import models.domain.CantidadPorProducto;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.documentos.NotaCredito;
import models.domain.documentos.NotaDebito;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioDocumentos;
import models.repositories.RepositorioPrecioPorProveedor;
import models.repositories.RepositorioProductos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DocumentosController {

    private static DocumentosController instancia;
    private RepositorioDocumentos repositorioDocumentos;
    private RepositorioProductos  repositorioProductos;

    private RepositorioPrecioPorProveedor repositorioPrecioPorProveedor;

    private MainController mainController = MainController.getInstancia();


    public static DocumentosController getInstancia(){
        if(DocumentosController.instancia == null)
            instancia = new DocumentosController();
        return instancia;
    }

    private DocumentosController(){
        this.repositorioPrecioPorProveedor = RepositorioPrecioPorProveedor.getInstancia();
        this.repositorioProductos = RepositorioProductos.getInstancia();
        this.repositorioDocumentos = RepositorioDocumentos.getInstancia();

    };


    //=================================================================================================================
    //INICIO DOCUMENTOS
    //=================================================================================================================

    public void altaDocumento(Documento.DocumentoDTO documentoDTO, Optional<Proveedor> proveedor){
        this.validarDatosDocumento(documentoDTO);
        TipoDocumento tipoDocumento = documentoDTO.tipoDocumento;

        if(tipoDocumento == TipoDocumento.Factura){
            Documento documento = new Factura();
            asignarParametrosDocumento(documento,documentoDTO,proveedor);
            this.repositorioDocumentos.agregar(documento);
        }else if (tipoDocumento == TipoDocumento.NotaDebito){
            Documento documento = new NotaDebito();
            asignarParametrosDocumento(documento,documentoDTO,proveedor);
            this.repositorioDocumentos.agregar(documento);
        }else {
            Documento documento = new NotaCredito();
            asignarParametrosDocumento(documento,documentoDTO,proveedor);
            this.repositorioDocumentos.agregar(documento);
        }
    }

    private void validarDatosDocumento(Documento.DocumentoDTO documentoDto){
        if (!mainController.validarCuit(documentoDto.cuitProveedor)) {
            throw new ProveedorInexistenteException ("No se encontro el Proveedor");
        }
    }

    private void asignarParametrosDocumento(Documento documento, Documento.DocumentoDTO documentoDto,Optional<Proveedor> proveedor) {
        documento.setTipoDocumento(documentoDto.tipoDocumento);
        documento.setFecha(documentoDto.fecha);
        documento.setCuitProveedor(documentoDto.cuitProveedor);
        documento.setProveedor(proveedor);

    }

    public List<Documento.DocumentoDTO> documentosPorProveedor (Integer cuit) {
        List<Documento.DocumentoDTO> documentosDTO = new ArrayList<>();
        this.repositorioDocumentos.buscarPorCuitProveedor(cuit).forEach(documento -> {
            documentosDTO.add(documento.toDTO());
        });

        return  documentosDTO;
    }

    //=================================================================================================================
    //FIN DOCUMENTOS
    //=================================================================================================================


    //=================================================================================================================
    //INICIO CONSULTAS GENERALES
    //=================================================================================================================
    public int facturasEmitidasElDia(LocalDate unDia){
        List<Documento> facturas = new ArrayList<>();

        this.repositorioDocumentos.facturasEmitdasElDia(unDia).forEach(documento -> {
            if (documento.getTipoDocumento().equals(TipoDocumento.Factura)) {
                facturas.add(documento);
            }});

        return facturas.size();
    }



}
