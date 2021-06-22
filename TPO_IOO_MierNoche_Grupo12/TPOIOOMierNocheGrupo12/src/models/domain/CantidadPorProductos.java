package models.domain;

public class CantidadPorProductos {
    private Producto producto;
    private float cantidad;
    private float impuestoTotal;


    public CantidadPorProductos(Producto producto, float cantidad, float impuestoTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.impuestoTotal = impuestoTotal;
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


}
