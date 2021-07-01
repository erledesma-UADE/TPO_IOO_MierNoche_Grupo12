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


        PrecioPorProveedor precioPorProveedor2 = new PrecioPorProveedor();

        precioPorProveedor2.setID(2);
        precioPorProveedor2.setCuitProveedor(123456);
        precioPorProveedor2.setProducto(producto1);
        precioPorProveedor2.setPreciosAcordados(cargarPreciosAcordados(40,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor2);
        producto1.agregarPrecioProveedor(precioPorProveedor2);


        PrecioPorProveedor precioPorProveedor3 = new PrecioPorProveedor();

        precioPorProveedor3.setID(3);
        precioPorProveedor3.setCuitProveedor(1234);
        Producto producto2 = repositorioProductos.getPorID(2).get();
        precioPorProveedor3.setProducto(producto2);
        precioPorProveedor3.setPreciosAcordados(cargarPreciosAcordados(50,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor3);
        producto2.agregarPrecioProveedor(precioPorProveedor3);


        PrecioPorProveedor precioPorProveedor4 = new PrecioPorProveedor();
        precioPorProveedor4.setID(4);
        precioPorProveedor4.setCuitProveedor(123456);
        precioPorProveedor4.setProducto(producto2);
        precioPorProveedor4.setPreciosAcordados(cargarPreciosAcordados(50,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor4);
        producto2.agregarPrecioProveedor(precioPorProveedor4);


        PrecioPorProveedor precioPorProveedor5 = new PrecioPorProveedor();

        precioPorProveedor5.setID(5);
        precioPorProveedor5.setCuitProveedor(1234);
        Producto producto3 = repositorioProductos.getPorID(3).get();
        precioPorProveedor5.setProducto(producto3);
        precioPorProveedor5.setPreciosAcordados(cargarPreciosAcordados(100,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor5);
        producto3.agregarPrecioProveedor(precioPorProveedor5);


        PrecioPorProveedor precioPorProveedor6 = new PrecioPorProveedor();
        precioPorProveedor6.setID(6);
        precioPorProveedor6.setCuitProveedor(123456);
        precioPorProveedor6.setProducto(producto3);
        precioPorProveedor6.setPreciosAcordados(cargarPreciosAcordados(100,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor6);
        producto3.agregarPrecioProveedor(precioPorProveedor6);


        PrecioPorProveedor precioPorProveedor7 = new PrecioPorProveedor();
        precioPorProveedor7.setID(7);
        precioPorProveedor7.setCuitProveedor(1234);
        Producto producto4 = repositorioProductos.getPorID(4).get();
        precioPorProveedor7.setProducto(producto4);
        precioPorProveedor7.setPreciosAcordados(cargarPreciosAcordados(150,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor7);
        producto4.agregarPrecioProveedor(precioPorProveedor7);


        PrecioPorProveedor precioPorProveedor8 = new PrecioPorProveedor();
        precioPorProveedor8.setID(8);
        precioPorProveedor8.setCuitProveedor(123456);
        precioPorProveedor8.setProducto(producto4);
        precioPorProveedor8.setPreciosAcordados(cargarPreciosAcordados(150,"2020-05-10","2020-10-19"));

        preciosPorProveedor.add(precioPorProveedor8);
        producto4.agregarPrecioProveedor(precioPorProveedor8);


        for (Producto producto : repositorioProductos.getElementos()) {
            System.out.println("\nProducto id: " + producto.getID() + " Nombre: " + producto.getNombre());
            List<PrecioPorProveedor> precioPorProducto = producto.getPrecioPorProveedor();
            for(PrecioPorProveedor precioPorProveedor : precioPorProducto){
                System.out.println("\nCuit proveedor: " + precioPorProveedor.getCuitProveedor() + " - Producto: " + precioPorProveedor.getProducto().getNombre());
                List<PreciosAcordados> preciosAcordados = precioPorProveedor.getPreciosAcordados();
                for(PreciosAcordados precioAcordado : preciosAcordados){
                    System.out.println("Fecha acuerdo " + precioAcordado.getFechaAcuerdo() + " - Monto: " + precioAcordado.getMonto());
                }
            }
        }


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
