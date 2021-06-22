package models.domain.documentos;

import models.domain.Producto;

public class CantidadPorProducto {
    private Producto producto;
    private float cantidad;
    private float impuestoTotal;

    public CantidadPorProducto(Producto producto, float cantidad, float impuestoTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.impuestoTotal = impuestoTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getImpuestoTotal() {
        return impuestoTotal;
    }

    public void setImpuestoTotal(float impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public float getImpuesto () { return this.producto.getImpuesto(); }

    private void calcularImpuestoTotla () {
        this.impuestoTotal = getImpuesto() * this.cantidad;
    }
}
