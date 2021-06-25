package models.repositories;

import models.domain.Proveedor;

import java.util.Optional;

public class RepositorioProveedores extends Repositorio<Proveedor> {

    public Optional<Proveedor> buscarPorCuit(Integer cuit) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getCuit().equals(cuit))
                .findFirst();
    }


}
