package controllers;

import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.repositories.RepositorioDocumentos;

import java.time.LocalDate;
import java.util.List;

public class DocumentosController {

    private static DocumentosController instancia;
    private RepositorioDocumentos repositorio;

    public static DocumentosController getInstancia(){
        if(DocumentosController.instancia == null)
            instancia = new DocumentosController();
        return instancia;
    }

    private DocumentosController(){ this.repositorio = new RepositorioDocumentos();};

    public float totalFacturasRecibidas (LocalDate fecha, Factura factura) {
        List<Documento> todosLosDocumentos = this.repositorio.buscarTodos();
        int contador = 0;

    }

    public void mostrarOrdenesPago () {}

    public void getFacturasPorDia (LocalDate fecha, Factura factura) {}

    public void libroIVACompras () {}

    public void getLibroIVACompras () {}
}
