package models.domain;

import models.domain.enums.Iva;

import java.util.Optional;

public class CantidadPorProducto {
    private Producto producto;
    private String productoString;
    private float cantidad;
    private double precioFinal;


    public CantidadPorProducto(Producto producto, float cantidad, Integer cuitProveedor) {
        this.producto = producto;
        this.cantidad = cantidad;
        calcularPrecioFinal(cuitProveedor);
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


    public void calcularPrecioFinal (Integer cuitProveedor) {
        float precioProveedor = this.producto.buscarPrecioProveedor(cuitProveedor);
        Iva impuestoProducto = this.producto.getImpuesto();

        this.precioFinal = precioProveedor * this.cantidad * (1+(impuestoProducto.getPorcentaje()/100));

        setPrecioFinal(precioFinal);
    }


    public Iva getTipoImpuesto () {
        return this.producto.getImpuesto();
    }
}
