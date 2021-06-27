package models.domain;

import java.time.LocalDate;

public class PrecioPorProducto extends ID {
    private LocalDate fechaAcuerdo;
    private float monto;
    private Producto producto;
    private Proveedor proveedor;

    public PrecioPorProducto(LocalDate fechaAcuerdo, float monto, Producto producto, Proveedor proveedor) {
        this.fechaAcuerdo = fechaAcuerdo;
        this.monto = monto;
        this.producto = producto;
        this.proveedor = proveedor;
    }

    public LocalDate getFechaAcuerdo() {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(LocalDate fechaAcuerdo) {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }




    public PrecioPorProductoDTO toDTO () {
        PrecioPorProductoDTO dto = new PrecioPorProductoDTO();
        dto.fechaAcuerdo = this.fechaAcuerdo;
        dto.monto = this.monto;
        dto.producto = this.producto.toDTO();
        //dto.proveedor;

        return dto;
    }

    public static class PrecioPorProductoDTO {
        public LocalDate fechaAcuerdo;
        public float monto;
        public Producto.ProductoDTO producto;
        //public ProveedorDTO proveedor;
    }
}
