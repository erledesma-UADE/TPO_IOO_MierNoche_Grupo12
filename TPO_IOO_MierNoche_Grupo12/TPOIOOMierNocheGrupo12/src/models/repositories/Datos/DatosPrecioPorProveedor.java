package models.repositories.Datos;

import models.domain.PrecioPorProveedor;
import models.domain.PreciosAcordados;
import models.domain.Producto;
import models.repositories.RepositorioProductos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosPrecioPorProveedor {

    public static List<PrecioPorProveedor> getPreciosPorProveedor(){

        //Agrego 2 PreciosPorProveedor para un mismo proveedor con distinta fecha y distinto precio

        RepositorioProductos repositorioProductos = new RepositorioProductos();
        List<PrecioPorProveedor> preciosPorProveedor = new ArrayList<>();

        PrecioPorProveedor precioPorProveedor1 = new PrecioPorProveedor();

        precioPorProveedor1.setID(1);
        precioPorProveedor1.setCuitProveedor(1234);
        Producto producto1 = repositorioProductos.getPorID(1).get();
        precioPorProveedor1.setProducto(producto1);
        precioPorProveedor1.setPreciosAcordados(cargarPreciosAcordados(40,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor1);
        producto1.agregarPrecioProveedor(precioPorProveedor1);

        precioPorProveedor1.setID(2);
        precioPorProveedor1.setCuitProveedor(123456);

        preciosPorProveedor.add(precioPorProveedor1);
        producto1.agregarPrecioProveedor(precioPorProveedor1);


        PrecioPorProveedor precioPorProveedor2 = new PrecioPorProveedor();
        precioPorProveedor2.setID(3);
        precioPorProveedor2.setCuitProveedor(1234);
        precioPorProveedor2.setProducto(repositorioProductos.getPorID(2).get());
        precioPorProveedor2.setPreciosAcordados(cargarPreciosAcordados(50,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor2);

        precioPorProveedor2.setID(4);
        precioPorProveedor2.setCuitProveedor(123456);

        preciosPorProveedor.add(precioPorProveedor2);


        PrecioPorProveedor precioPorProveedor3 = new PrecioPorProveedor();
        precioPorProveedor3.setID(5);
        precioPorProveedor3.setCuitProveedor(1234);
        precioPorProveedor3.setProducto(repositorioProductos.getPorID(3).get());
        precioPorProveedor3.setPreciosAcordados(cargarPreciosAcordados(100,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor3);

        precioPorProveedor3.setID(6);
        precioPorProveedor3.setCuitProveedor(123456);

        preciosPorProveedor.add(precioPorProveedor3);


        PrecioPorProveedor precioPorProveedor4 = new PrecioPorProveedor();
        precioPorProveedor4.setID(7);
        precioPorProveedor4.setCuitProveedor(1234);
        precioPorProveedor4.setProducto(repositorioProductos.getPorID(4).get());
        precioPorProveedor4.setPreciosAcordados(cargarPreciosAcordados(150,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor4);

        precioPorProveedor4.setID(8);
        precioPorProveedor4.setCuitProveedor(123456);

        preciosPorProveedor.add(precioPorProveedor4);

        return preciosPorProveedor;
    }

    public static List<PreciosAcordados> cargarPreciosAcordados(float monto, String fecha1, String fecha2){
        List<PreciosAcordados> preciosAcordados = new ArrayList<>();

        PreciosAcordados precioAcordado = new PreciosAcordados();
        precioAcordado.setFechaAcuerdo(LocalDate.parse(fecha1));
        precioAcordado.setMonto(monto);

        preciosAcordados.add(precioAcordado);

        precioAcordado.setFechaAcuerdo(LocalDate.parse(fecha2));
        precioAcordado.setMonto(monto+20);

        preciosAcordados.add(precioAcordado);

        return preciosAcordados;
    }

}
