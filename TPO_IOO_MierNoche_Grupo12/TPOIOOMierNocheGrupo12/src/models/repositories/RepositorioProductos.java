package models.repositories;

import models.domain.Producto;

import java.util.Optional;

public class RepositorioProductos extends Repositorio<Producto> {

    public Optional<Producto> buscarProductoPorNombre(String producto) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getNombre().equals(producto))
                .findFirst();
    }
}
