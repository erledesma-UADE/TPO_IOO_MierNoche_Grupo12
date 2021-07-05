package models.repositories.Datos;

import models.domain.Impuesto;
import models.domain.OrdenPago;
import models.domain.Proveedor;
import models.domain.Retencion;
import models.domain.enums.TipoPago;
import models.repositories.RepositorioDocumentos;
import models.repositories.RepositorioProveedores;
import models.repositories.RepositorioRetenciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosOrdenPago {

    public static List<OrdenPago> getOrdenesPago(){

        RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();
        RepositorioDocumentos repositorioDocumentos = RepositorioDocumentos.getInstancia();
        List<OrdenPago> ordenesPago = new ArrayList<>();

        OrdenPago ordenPago1 = new OrdenPago();
        ordenPago1.setID(1);
        ordenPago1.setFecha(LocalDate.parse("2020-10-10"));
        ordenPago1.setTipoPago(TipoPago.EFECTIVO);
        ordenPago1.setPagado(false);
        Proveedor proveedor = repositorioProveedores.buscarPorCuit(1234).get();
        ordenPago1.setProveedor(proveedor);
        ordenPago1.agregarDocumento(repositorioDocumentos.getPorID(1).get());
        ordenPago1.agregarDocumento(repositorioDocumentos.getPorID(2).get());
        ordenPago1.calcularSubtotal();
        ordenPago1.agregarRetenciones();
        ordenPago1.calcularTotalRetenciones();
        ordenPago1.calcularMontoTotal();
        ordenPago1.cambiarEstado();
        ordenesPago.add(ordenPago1);

        return ordenesPago;
    }

}
