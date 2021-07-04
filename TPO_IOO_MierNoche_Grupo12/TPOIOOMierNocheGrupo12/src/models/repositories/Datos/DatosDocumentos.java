package models.repositories.Datos;

import models.domain.CantidadPorProducto;
import models.domain.Impuesto;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioProveedores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatosDocumentos {

    public static List<Documento> getDocumentos(){

        RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();

        List<Documento> listaDocumentos = new ArrayList<>();

        Factura factura1 = new Factura();
        factura1.setID(1);
        factura1.setFecha(LocalDate.parse("2020-12-06"));
        factura1.setPagado(false);
        Optional<Proveedor> proveedor1 = repositorioProveedores.buscarPorCuit(1234);
        factura1.setProveedor(proveedor1);
        factura1.setTipoDocumento(TipoDocumento.Factura);
        CantidadPorProducto cant1 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(1).getProducto(),5,1234);
        CantidadPorProducto cant2 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(2).getProducto(),10,1234);
        factura1.agregarArticulo(cant1);
        factura1.agregarArticulo(cant2);
        factura1.setImpuestos(proveedor1.get().getImpuestos());
        //factura1.setOrdenDeCompra();
        factura1.setMontoTotal();

        listaDocumentos.add(factura1);

        Factura factura2 = new Factura();
        factura2.setID(2);
        factura2.setFecha(LocalDate.parse("2020-12-06"));
        factura2.setPagado(true);
        factura2.setProveedor(proveedor1);
        factura2.setTipoDocumento(TipoDocumento.Factura);
        CantidadPorProducto cant3 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(0).getProducto(),2,1234);
        CantidadPorProducto cant4 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(3).getProducto(),10,1234);
        factura2.agregarArticulo(cant3);
        factura2.agregarArticulo(cant4);
        factura1.setImpuestos(proveedor1.get().getImpuestos());
        //factura1.setOrdenDeCompra();
        factura2.setMontoTotal();

        listaDocumentos.add(factura2);

        proveedor1.get().agregarDocumentoEmitido(factura1);
        proveedor1.get().agregarDocumentoEmitido(factura2);

        proveedor1.get().getCuentaCorriente().agregarDocumento(factura1);
        proveedor1.get().getCuentaCorriente().agregarDocumento(factura2);


        Factura factura3 = new Factura();
        factura3.setID(3);
        factura3.setFecha(LocalDate.parse("2020-08-06"));
        factura3.setPagado(false);
        Optional<Proveedor> proveedor2 = repositorioProveedores.buscarPorCuit(123456);
        factura3.setProveedor(proveedor2);
        factura3.setTipoDocumento(TipoDocumento.Factura);
        CantidadPorProducto cant5 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(1).getProducto(),2,123456);
        CantidadPorProducto cant6 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(2).getProducto(),10,123456);
        factura3.agregarArticulo(cant5);
        factura3.agregarArticulo(cant6);
        factura3.setImpuestos(proveedor2.get().getImpuestos());
        //factura1.setOrdenDeCompra();
        factura3.setMontoTotal();

        listaDocumentos.add(factura3);

        Factura factura4 = new Factura();
        factura4.setID(4);
        factura4.setFecha(LocalDate.parse("2020-05-20"));
        factura4.setPagado(true);
        factura4.setProveedor(proveedor2);
        factura4.setTipoDocumento(TipoDocumento.Factura);
        CantidadPorProducto cant7 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(0).getProducto(),1,123456);
        CantidadPorProducto cant8 = new CantidadPorProducto(proveedor1.get().getCatalogo().get(3).getProducto(),3,123456);
        factura4.agregarArticulo(cant7);
        factura4.agregarArticulo(cant8);
        factura4.setImpuestos(proveedor2.get().getImpuestos());
        //factura1.setOrdenDeCompra();
        factura4.setMontoTotal();

        listaDocumentos.add(factura4);

        proveedor2.get().agregarDocumentoEmitido(factura3);
        proveedor2.get().agregarDocumentoEmitido(factura4);

        proveedor2.get().getCuentaCorriente().agregarDocumento(factura3);
        proveedor2.get().getCuentaCorriente().agregarDocumento(factura4);

        return listaDocumentos;
    }


}
