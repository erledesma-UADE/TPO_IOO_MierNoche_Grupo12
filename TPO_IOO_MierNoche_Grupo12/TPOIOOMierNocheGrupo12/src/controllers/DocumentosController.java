package controllers;



import models.domain.CantidadPorProducto;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.documentos.NotaCredito;
import models.domain.documentos.NotaDebito;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioDocumentos;
import models.repositories.RepositorioProductos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DocumentosController {

    private static DocumentosController instancia;
    private RepositorioDocumentos repositorioDocumentos;
    private RepositorioProductos  repositorioProductos;

    public static DocumentosController getInstancia(){
        if(DocumentosController.instancia == null)
            instancia = new DocumentosController();
        return instancia;
    }

    public DocumentosController(){
        this.repositorioDocumentos = new RepositorioDocumentos();
        this.repositorioProductos = new RepositorioProductos();
    };

    public RepositorioProductos getRepositorioProductos() {
        return this.repositorioProductos;
    }

    public RepositorioDocumentos getRepositorioDocumentos() {
        return repositorioDocumentos;
    }

    public void setRepositorioDocumentos(RepositorioDocumentos repositorioDocumentos) {
        this.repositorioDocumentos = repositorioDocumentos;
    }

    public void setRepositorioProductos(RepositorioProductos repositorioProductos) {
        this.repositorioProductos = repositorioProductos;
    }

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
        //validarExistenciaProveedor
    }

    private void asignarParametrosDocumento(Documento documento, Documento.DocumentoDTO documentoDto,Optional<Proveedor> proveedor) {
        documento.setTipoDocumento(documentoDto.tipoDocumento);
        documento.setFecha(documentoDto.fecha);
        documento.setProveedor(documentoDto.cuitProveedor);
        documento.setProveedor(proveedor);

        String[][] articulosVista = documentoDto.articulosVista;
        this.setArticulos(articulosVista,documento,documentoDto);

    }

    public void setArticulos(String[][] articulosVista,Documento documento,Documento.DocumentoDTO documentoDto){
        for (int i = 0; i < articulosVista.length; i++) {
            Optional<Producto> producto = null;
            float cantidad = 0;
            double precioFinal = 0.0;
            for (int j = 0; j < 2.; j++) {
                if (j == 0) {
                    String productoActual = articulosVista[i][j];
                    producto = this.repositorioProductos.buscarProductoPorNombre(productoActual);
                } else {
                    cantidad = Float.parseFloat(articulosVista[i][j]);

                }
            }
            CantidadPorProducto productoAux = new CantidadPorProducto(producto, cantidad, documentoDto.cuitProveedor);
            documento.agregarArticulo(productoAux);
        }
        documento.setMontoTotal();
    }



    public int facturasEmitidasElDia(LocalDate unDia){
        return this.repositorioDocumentos.facturasEmitdasElDia(unDia).size();
    }



    /*public int totalFacturasRecibidas () {
        List<Documento> todosLosDocumentos = this.repositorioDocumentos.buscarTodos();
        final int[] contador = {0};
        todosLosDocumentos.forEach(documento -> {
            if(documento.getTipoDocumento() == "Factura"){
                contador[0] += 1;
            }
        });
        return contador[0];
    }

    public int getFacturasPorDia (LocalDateTime fecha) {
            List<Documento> todosLosDocumentos = this.repositorioDocumentos.buscarTodos();
            final int[] contador = {0};
            todosLosDocumentos.forEach(documento -> {
                if(documento.getTipoDocumento() == "Factura" && documento.getFecha() == fecha){
                    contador[0] += 1;
                }
            });
            return contador[0];
    }


    public void libroIVACompras () {}

    public void getLibroIVACompras () {}

*/


}
