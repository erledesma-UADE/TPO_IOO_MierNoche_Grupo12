package models.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompra extends ID {
    private LocalDate fecha;
    private List<Producto> producto;
    private Proveedor proveedor;

    public OrdenCompra(LocalDate fecha, Proveedor proveedor) {
        this.fecha = fecha;
        this.producto = new ArrayList<>();
        this.proveedor = proveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = this.producto;
    }

    public void agregarProducto (Producto producto) {
        this.producto.add(producto);
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public boolean verificarTope(Proveedor proveedor){
        return false;
    }
}
