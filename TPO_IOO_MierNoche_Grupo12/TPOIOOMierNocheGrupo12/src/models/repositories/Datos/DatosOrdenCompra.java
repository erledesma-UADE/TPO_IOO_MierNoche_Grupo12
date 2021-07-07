package models.repositories.Datos;

import models.domain.OrdenCompra;
import models.domain.Producto;
import models.domain.Proveedor;
import models.repositories.Repositorio;
import models.repositories.RepositorioProductos;
import models.repositories.RepositorioProveedores;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosOrdenCompra {
    public static List<OrdenCompra> getOrdenesCompra () {
        RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();
        RepositorioProductos repositorioProductos = RepositorioProductos.getInstancia();
        List<OrdenCompra> ordenes = new ArrayList<>();
        OrdenCompra orden = new OrdenCompra();

        orden.setFecha(LocalDate.of(2020, 2, 15));
        Proveedor proveedor = repositorioProveedores.getPorID(1).get();
        orden.setProveedor(proveedor);
        Producto producto = new Producto();
        producto = repositorioProductos.getPorID(1).get();
        orden.agregarProducto(producto);

        return ordenes;
    }
}
