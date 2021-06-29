package models.domain;

import java.time.LocalDate;

public class PrecioPorProducto extends ID {
    private LocalDate fechaAcuerdo;
    private float monto;
    //private Producto producto;
    private Proveedor proveedor;

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

    //public Producto getProducto() { return producto; }

    //public void setProducto(Producto producto) { this.producto = producto; }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void asinarParametros (PrecioPorProducto.PrecioPorProductoDTO precioPorProductoDTO) {
        this.fechaAcuerdo = precioPorProductoDTO.fechaAcuerdo;
        //this.producto.asignarParametros(precioPorProductoDTO.producto);
        this.monto = precioPorProductoDTO.monto;
        //Falta Proveedor
    }

    public PrecioPorProductoDTO toDTO () {
        PrecioPorProductoDTO dto = new PrecioPorProductoDTO();
        dto.fechaAcuerdo = this.fechaAcuerdo;
        dto.monto = this.monto;
        //dto.producto = this.producto.toDTO();
        dto.proveedor = this.proveedor.toDTO();

        return dto;
    }

    public static class PrecioPorProductoDTO {
        public LocalDate fechaAcuerdo;
        public float monto;
        public Producto.ProductoDTO producto;
        public Proveedor.ProveedorDTO proveedor;
    }
}
