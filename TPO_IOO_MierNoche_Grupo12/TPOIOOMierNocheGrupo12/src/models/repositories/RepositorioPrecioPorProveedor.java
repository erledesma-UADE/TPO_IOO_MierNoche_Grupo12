package models.repositories;

import models.domain.PrecioPorProveedor;
import models.repositories.Datos.DatosPrecioPorProveedor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioPrecioPorProveedor extends Repositorio<PrecioPorProveedor> {

    private static RepositorioPrecioPorProveedor instancia;

    public static RepositorioPrecioPorProveedor getInstancia(){
        if(RepositorioPrecioPorProveedor.instancia == null)
            instancia = new RepositorioPrecioPorProveedor();
        return instancia;
    }

    public RepositorioPrecioPorProveedor(){
        super();
        super.elementos = DatosPrecioPorProveedor.getPreciosPorProveedor();
    }

    public Optional<PrecioPorProveedor> buscarPrecioProveedor(Integer idProveedor) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().equals(idProveedor))
                .findFirst();
    }

    public List<PrecioPorProveedor> buscarPorProducto(Integer idProducto) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProducto().getID().equals(idProducto)).collect(Collectors.toList());
    }
}

