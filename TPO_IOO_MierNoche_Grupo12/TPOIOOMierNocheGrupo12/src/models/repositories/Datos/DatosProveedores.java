package models.repositories.Datos;

import models.domain.Certificado;
import models.domain.Impuesto;
import models.domain.PrecioPorProveedor;
import models.domain.Proveedor;
import models.domain.enums.Responsabilidad;
import models.repositories.RepositorioPrecioPorProducto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosProveedores {

    public static List<Proveedor> getProveedores(){
        RepositorioPrecioPorProducto repositorioPreciosPorProveedor = new RepositorioPrecioPorProducto();
        List<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor();

        proveedor1.setID(1);
        proveedor1.setCuit(1234);
        proveedor1.setDireccion("Buenos Aires");
        proveedor1.setEmail("proveedor1@gmail.com");
        proveedor1.setNombre("IOO SA");
        proveedor1.setInicioActividades(LocalDate.parse("2020-05-10"));
        proveedor1.setNumeroIngresosBrutos(5);
        proveedor1.setResponsabilidad(Responsabilidad.INSCRIPTO);
        proveedor1.setTelefono(1122556677);
        proveedor1.setTope(500);
        proveedor1.setCertificado(new Certificado(1,LocalDate.parse("2020-10-05"),LocalDate.parse("2020-12-05"),new Impuesto("Ganancias",5)));
        proveedor1.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(1).get());
        proveedor1.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(3).get());
        proveedor1.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(5).get());
        proveedor1.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(7).get());

        //proveedor1.setCatalogo();
        //proveedor1.setFacturasEmitidas();
        //proveedor1.setImpuestos();
        //proveedor1.setOrdenDeCompra();
        //proveedor1.setOrdenPago();

        proveedores.add(proveedor1);

        Proveedor proveedor2 = new Proveedor();
        proveedor2.setID(2);
        proveedor2.setCuit(123456);
        proveedor2.setDireccion("Buenos Aires");
        proveedor2.setEmail("proveedor2@gmail.com");
        proveedor2.setNombre("IOO2 SA");
        proveedor2.setInicioActividades(LocalDate.parse("2020-05-20"));
        proveedor2.setNumeroIngresosBrutos(2);
        proveedor2.setResponsabilidad(Responsabilidad.MONOTRIBUTO);
        proveedor2.setTelefono(1122556677);
        proveedor2.setTope(1000);
        proveedor2.setCertificado(new Certificado(1,LocalDate.parse("2020-05-05"),LocalDate.parse("2020-07-05"),new Impuesto("Ganancias",1)));
        proveedor2.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(2).get());
        proveedor2.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(4).get());
        proveedor2.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(6).get());
        proveedor2.agregarCatalogo(repositorioPreciosPorProveedor.getPorID(8).get());
        //proveedor1.setCatalogo();
        //proveedor1.setFacturasEmitidas();
        //proveedor1.setImpuestos();
        //proveedor1.setOrdenDeCompra();
        //proveedor1.setOrdenPago();


        proveedores.add(proveedor2);

        return proveedores;
    }

}
