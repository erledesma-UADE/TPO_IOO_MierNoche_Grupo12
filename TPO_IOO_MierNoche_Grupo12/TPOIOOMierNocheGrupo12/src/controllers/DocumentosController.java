package controllers;


import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.repositories.RepositorioDocumentos;
import models.domain.repositories.RepositorioOrdenesDePago;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DocumentosController {

    private static DocumentosController instancia;
    private RepositorioDocumentos repositorioDocumentos;

    public static DocumentosController getInstancia(){
        if(DocumentosController.instancia == null)
            instancia = new DocumentosController();
        return instancia;
    }

    private DocumentosController(){
        this.repositorioDocumentos = new RepositorioDocumentos();
    };

    public int totalFacturasRecibidas () {
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




}
