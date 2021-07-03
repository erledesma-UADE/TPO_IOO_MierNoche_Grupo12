package models.repositories.Datos;

import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioProveedores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosDocumentos {

    public static List<Documento> getDocumentos(){

        RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();

        List<Documento> listaDocumentos = new ArrayList<>();
        Factura factura1 = new Factura();
        factura1.setID(1);
        factura1.setFecha(LocalDate.parse("2020-10-05"));
        factura1.setPagado(false);
        //factura1.setImpuestos();
        //factura1.setOrdenDeCompra();
        //factura1.setArticulos();
        factura1.setProveedor(repositorioProveedores.buscarPorCuit(1234));
        factura1.setTipoDocumento(TipoDocumento.Factura);

        factura1.setMontoTotal();





        return listaDocumentos;
    }


}
