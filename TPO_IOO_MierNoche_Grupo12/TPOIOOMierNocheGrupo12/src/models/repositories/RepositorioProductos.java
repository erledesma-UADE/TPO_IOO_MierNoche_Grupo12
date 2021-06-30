package models.repositories;

import models.domain.Producto;
import models.repositories.Datos.DatosProductos;

import java.util.Optional;

public class RepositorioProductos extends Repositorio<Producto> {

    private static RepositorioProductos instancia;

    public static RepositorioProductos getInstancia(){
        if(RepositorioProductos.instancia == null)
            instancia = new RepositorioProductos();
        return instancia;
    }

    public RepositorioProductos(){
        super();
        super.elementos = DatosProductos.getProductos();
    }

    public Optional<Producto> buscarProductoPorNombre(String producto) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getNombre().equals(producto))
                .findFirst();
    }
}
