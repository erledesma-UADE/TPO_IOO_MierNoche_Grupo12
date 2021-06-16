package models.domain;

import java.time.LocalDateTime;

public class ProductoPrecio {
    private LocalDateTime fechaAcuerdo;
    private Proveedor proveedor;
    private float precio;

    public ProductoPrecio(LocalDateTime fechaAcuerdo, Proveedor proveedor, float precio) {
        this.fechaAcuerdo = fechaAcuerdo;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public LocalDateTime getFechaAcuerdo() {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(LocalDateTime fechaAcuerdo) {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
