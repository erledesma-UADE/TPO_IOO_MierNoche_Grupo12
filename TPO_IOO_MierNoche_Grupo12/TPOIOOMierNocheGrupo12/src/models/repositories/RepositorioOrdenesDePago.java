package models.repositories;

import models.domain.OrdenPago;
import models.domain.PrecioPorProducto;

import java.util.Optional;

public class RepositorioOrdenesDePago extends Repositorio<OrdenPago> {

    public Optional<OrdenPago> buscarOrdenProveedor(Integer idProveedor) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().equals(idProveedor))
                .findFirst();
    }
}
