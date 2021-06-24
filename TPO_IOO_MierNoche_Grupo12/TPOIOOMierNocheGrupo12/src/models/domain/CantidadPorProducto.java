package models.domain;

import models.domain.enums.Iva;

public class CantidadPorProducto {
    private Producto producto;
    private float cantidad;
    private float impuestoTotal;

    public CantidadPorProducto(Producto producto, float cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        calcularImpuestoTotal();
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setImpuestoTotal(float impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public float getImpuestoTotal() {
        return impuestoTotal;
    }

    public void calcularImpuestoTotal () {
        this.impuestoTotal = this.producto.montoImpuesto() * this.cantidad;
        setImpuestoTotal(this.impuestoTotal);
    }

    public Iva getTipoImpuesto () {
        return this.producto.getImpuesto();
    }
}
