package models.repositories.Datos;

import models.domain.Producto;
import models.domain.enums.Iva;

import java.util.ArrayList;
import java.util.List;

public class DatosProductos {

    public static List<Producto> getProductos(){

        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto();
        producto1.setID(1);
        producto1.setNombre("Lapicera");
        producto1.setTipoUnidad("Unidad");
        producto1.setImpuesto(Iva.tipo4);

        Producto producto2 = new Producto();
        producto2.setID(2);
        producto2.setNombre("Goma");
        producto2.setTipoUnidad("Unidad");
        producto2.setImpuesto(Iva.tipo4);

        Producto producto3 = new Producto();
        producto2.setID(3);
        producto2.setNombre("Reparacion");
        producto2.setTipoUnidad("Horas");
        producto2.setImpuesto(Iva.tipo3);

        Producto producto4 = new Producto();
        producto2.setID(4);
        producto2.setNombre("Galletitas");
        producto2.setTipoUnidad("Unidad");
        producto2.setImpuesto(Iva.tipo2);

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);

        return productos;
    }

}
