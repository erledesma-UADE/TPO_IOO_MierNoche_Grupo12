package models.repositories;

import models.domain.OrdenPago;
import models.repositories.Datos.DatosOrdenPago;

import java.util.Optional;

public class RepositorioOrdenesDePago extends Repositorio<OrdenPago> {

    private static RepositorioOrdenesDePago instancia;

    public static RepositorioOrdenesDePago getInstancia(){
        if(RepositorioOrdenesDePago.instancia == null)
            instancia = new RepositorioOrdenesDePago();
        return instancia;
    }

    private RepositorioOrdenesDePago(){
        super();
        super.elementos = DatosOrdenPago.getOrdenesPago();
    }

    public Optional<OrdenPago> buscarOrdenProveedor(Integer idProveedor) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().equals(idProveedor))
                .findFirst();
    }
}
