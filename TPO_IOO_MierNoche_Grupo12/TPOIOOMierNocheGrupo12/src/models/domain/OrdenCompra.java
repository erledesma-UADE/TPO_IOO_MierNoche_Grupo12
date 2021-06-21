package models.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompra{
    private int idDocumentos;
    private LocalDate fecha;
    private List<Producto> producto;
    private Proveedor proveedor;

    public OrdenCompra(int idDocumentos, LocalDate fecha, Proveedor proveedor) {
        this.idDocumentos = idDocumentos;
        this.fecha = fecha;
        this.producto = new ArrayList<>();
        this.proveedor = proveedor;
    }

    public int getIdDocumentos() {
        return idDocumentos;
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

    public boolean verificarTope(Proveedor proveedor){
        return false;
    }
}
