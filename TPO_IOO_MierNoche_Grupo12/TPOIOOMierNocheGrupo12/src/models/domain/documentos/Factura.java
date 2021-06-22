package models.domain.documentos;

import models.domain.Impuesto;
import models.domain.OrdenCompra;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDateTime;
import java.util.List;

public class Factura extends Documento {
    private OrdenCompra ordenDeCompra;
    private Proveedor proveedor;
    private List<Producto> articulos;
    private List<Impuesto> impuestos;

    public Factura(TipoDocumento tipoDocumento, Proveedor proveedor, LocalDateTime fecha) {
        super(tipoDocumento, proveedor, fecha);
    }

    public OrdenCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Producto> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Producto> articulos) {
        this.articulos = articulos;
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }
}
