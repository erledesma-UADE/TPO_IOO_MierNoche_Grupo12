package models.repositories;

import models.domain.PrecioPorProveedor;
import models.repositories.Datos.DatosPrecioPorProveedor;
import models.repositories.Datos.DatosProveedores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RepositorioPrecioPorProducto extends Repositorio<PrecioPorProveedor> {

    private static RepositorioPrecioPorProducto instancia;

    public static RepositorioPrecioPorProducto getInstancia(){
        if(RepositorioPrecioPorProducto.instancia == null)
            instancia = new RepositorioPrecioPorProducto();
        return instancia;
    }

    public RepositorioPrecioPorProducto(){
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

