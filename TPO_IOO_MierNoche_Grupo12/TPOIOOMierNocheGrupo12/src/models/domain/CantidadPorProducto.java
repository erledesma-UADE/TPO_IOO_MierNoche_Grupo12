package models.domain;

import models.domain.enums.Iva;

import java.util.Optional;

public class CantidadPorProducto {
    private Optional<Producto> producto;
    private float cantidad;
    private double precioFinal;


    public CantidadPorProducto(Optional<Producto> producto, float cantidad, Integer cuitProveedor) {
        this.producto = producto;
        this.cantidad = cantidad;
        calcularPrecioFinal(cuitProveedor);
    }


    public void setProducto(Optional<Producto> producto) {
        this.producto = producto;
    }


    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }


    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }


    public Optional<Producto> getProducto() {
        return this.producto;
    }


    public float getCantidad() {
        return this.cantidad;
    }


    public double getPrecioFinal() {
        return this.precioFinal;
    }


    public void calcularPrecioFinal (Integer cuitProveedor) {
        float precioProveedor = this.producto.get().buscarPrecioProveedor(cuitProveedor);
        Iva impuestoProducto = this.producto.get().getImpuesto();

        System.out.println("PrecioProveedor es " + precioProveedor);
        System.out.println("Cantidad es " + this.cantidad);
        System.out.println("Impuesto es " + impuestoProducto.getPorcentaje()/100);

        this.precioFinal = precioProveedor * this.cantidad * (1+(impuestoProducto.getPorcentaje()/100));
        System.out.println("Precio Final es " + precioFinal);
        setPrecioFinal(precioFinal);
    }


    public Iva getTipoImpuesto () {
        return this.producto.get().getImpuesto();
    }
}
