package models.domain.documentos;

import models.domain.CantidadPorProducto;
import models.domain.Impuesto;
import models.domain.OrdenCompra;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDateTime;
import java.util.List;

public class Factura extends Documento {
    private OrdenCompra ordenDeCompra;
    private List<Impuesto> impuestos;

    public Factura(String tipoDocumento, Proveedor proveedor, LocalDateTime fecha, List<CantidadPorProducto> articulos) {
        super(tipoDocumento, proveedor, fecha, articulos);
    }

    public OrdenCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }


    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }
}
