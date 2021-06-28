package models.repositories;

import models.domain.PrecioPorProducto;
import models.domain.Proveedor;

import java.util.Optional;

public class RepositorioPrecioPorProducto extends Repositorio<PrecioPorProducto> {

    public Optional<PrecioPorProducto> buscarPrecioProveedor(Integer idProveedor) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().equals(idProveedor))
                .findFirst();
    }

}
