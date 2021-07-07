package models.repositories.Datos;

import models.domain.Producto;
import models.domain.enums.Iva;
import models.repositories.RepositorioProductos;
import models.repositories.RepositorioRubros;

import java.util.ArrayList;
import java.util.List;

public class DatosProductos {

    public static List<Producto> getProductos(){
        List<Producto> productos = new ArrayList<>();
        RepositorioRubros repositorioRubros = RepositorioRubros.getInstancia();

        Producto producto1 = new Producto();
        producto1.setID(1);
        producto1.setNombre("Lapicera");
        producto1.setTipoUnidad("Unidad");
        producto1.setImpuesto(Iva.tipo4);
        repositorioRubros.getPorID(1).get().agregarProducto(producto1);

        Producto producto2 = new Producto();
        producto2.setID(2);
        producto2.setNombre("Goma");
        producto2.setTipoUnidad("Unidad");
        producto2.setImpuesto(Iva.tipo4);
        repositorioRubros.getPorID(1).get().agregarProducto(producto2);

        Producto producto3 = new Producto();
        producto3.setID(3);
        producto3.setNombre("Reparacion");
        producto3.setTipoUnidad("Horas");
        producto3.setImpuesto(Iva.tipo3);
        repositorioRubros.getPorID(2).get().agregarProducto(producto3);

        Producto producto4 = new Producto();
        producto4.setID(4);
        producto4.setNombre("Galletitas");
        producto4.setTipoUnidad("Unidad");
        producto4.setImpuesto(Iva.tipo2);
        repositorioRubros.getPorID(1).get().agregarProducto(producto4);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);

        return productos;
    }

}
