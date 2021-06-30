package models.domain;

import java.time.LocalDate;

public class PrecioPorProveedor extends ID {
    private LocalDate fechaAcuerdo;
    private float monto;
    private Producto producto;
    private Proveedor proveedor;
    private String fecha;
    private String productoString;
    private int cuitProveedor;

    public PrecioPorProveedor(String fecha, String monto, String productoString, String cuitProveedor) {
        //this.fechaAcuerdo = this.stringToLocalDate(fechaAcuerdo);
        this.fecha = fecha;
        this.monto = Float.parseFloat(monto);
        this.productoString = productoString;
        this.cuitProveedor = Integer.parseInt(cuitProveedor);
    }

    private LocalDate stringToLocalDate(String fecha){
        String[] fechas = fecha.split("-");
        LocalDate dia = LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
        return dia;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProductoString() {
        return productoString;
    }

    public void setProductoString(String productoString) {
        this.productoString = productoString;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
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
