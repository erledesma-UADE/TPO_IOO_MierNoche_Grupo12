package models.domain;

import models.domain.enums.Iva;

public class CantidadPorProducto {
    private Producto producto;
    private float cantidad;
    private double precioFinal;


    public CantidadPorProducto(Producto producto, float cantidad,Integer idProveedor) {
        this.producto = producto;
        this.cantidad = cantidad;
        calcularPrecioFinal(idProveedor);
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }


    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }


    public Producto getProducto() {
        return this.producto;
    }


    public float getCantidad() {
        return this.cantidad;
    }


    public double getPrecioFinal() {
        return this.precioFinal;
    }


    public void calcularPrecioFinal (Integer idProveedor) {
        float precioProveedor = this.producto.buscarPrecioProveedor(idProveedor);
        Iva impuestoProducto = this.producto.getImpuesto();
        this.precioFinal = precioProveedor * this.cantidad * (1+impuestoProducto.getPorcentaje());
        setPrecioFinal(precioFinal);
    }


    public Iva getTipoImpuesto () {
        return this.producto.getImpuesto();
    }
}
