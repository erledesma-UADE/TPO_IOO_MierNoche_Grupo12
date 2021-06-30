package models.repositories;

import models.domain.PrecioPorProveedor;

import java.util.Optional;

public class RepositorioPrecioPorProducto extends Repositorio<PrecioPorProveedor> {

    public Optional<PrecioPorProveedor> buscarPrecioProveedor(Integer idProveedor) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().equals(idProveedor))
                .findFirst();
    }

}
