package models.repositories;

import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RepositorioDocumentos extends Repositorio<Documento>{

    private static RepositorioDocumentos instancia;

    public static RepositorioDocumentos getInstancia(){
        if(RepositorioDocumentos.instancia == null)
            instancia = new RepositorioDocumentos();
        return instancia;
    }

    public RepositorioDocumentos(){
        super();
        //super.elementos = DatosProveedores.getProveedores();
    }

    public List<Factura> facturasEmitdasElDia(LocalDate unDia) {
        return (List<Factura>) this.getElementos()
                .stream()
                .filter(e -> e.getFecha().equals(unDia));
    }




}
