package controllers;



import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.documentos.NotaCredito;
import models.domain.documentos.NotaDebito;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioDocumentos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DocumentosController {

    private static DocumentosController instancia;
    private RepositorioDocumentos repositorioDocumentos;

    public static DocumentosController getInstancia(){
        if(DocumentosController.instancia == null)
            instancia = new DocumentosController();
        return instancia;
    }

    public DocumentosController(){
        this.repositorioDocumentos = new RepositorioDocumentos();
    };

    public void altaDocumento(Documento.DocumentoDTO documentoDTO){
        this.validarDatosDocumento(documentoDTO);
        TipoDocumento tipoDocumento = documentoDTO.tipoDocumento;

        if(tipoDocumento == TipoDocumento.Factura){
            Documento documento = new Factura();
            asignarParametrosDocumento(documento,documentoDTO);
            this.repositorioDocumentos.agregar(documento);
        }else if (tipoDocumento == TipoDocumento.NotaDebito){
            Documento documento = new NotaDebito();
            asignarParametrosDocumento(documento,documentoDTO);
            this.repositorioDocumentos.agregar(documento);
        }else {
            Documento documento = new NotaCredito();
            asignarParametrosDocumento(documento,documentoDTO);
            this.repositorioDocumentos.agregar(documento);
        }
    }

    private void validarDatosDocumento(Documento.DocumentoDTO documentoDto){
        //validarExistenciaProveedor
    }

    private void asignarParametrosDocumento(Documento documento, Documento.DocumentoDTO documentoDto){
        documento.setTipoDocumento(documentoDto.tipoDocumento);
        documento.setFecha(documentoDto.fecha);
        documento.setProveedor(documentoDto.cuitProveedor);
        documento.setArticulos(documentoDto.articulos);
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
