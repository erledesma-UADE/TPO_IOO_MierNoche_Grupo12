package models.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrecioPorProveedor extends ID {
    private List<PrecioAcordado> preciosAcordados;
    private Producto producto;
    private Proveedor proveedor;
    private String fecha;
    private String productoString;
    private int cuitProveedor;

    public PrecioPorProveedor() {}

    public PrecioPorProveedor(String fecha, String monto, String productoString, String cuitProveedor) {
        this.preciosAcordados = new ArrayList<>();
        this.productoString = productoString;
        this.cuitProveedor = Integer.parseInt(cuitProveedor);
    }

    public List<PrecioAcordado> getPreciosAcordados() {
        return preciosAcordados;
    }

    public void setPreciosAcordados(List<PrecioAcordado> preciosAcordados) {
        this.preciosAcordados = preciosAcordados;
    }

    private LocalDate stringToLocalDate(String fecha){
        String[] fechas = fecha.split("-");
        LocalDate dia = LocalDate.of(Integer.parseInt(fechas[0]), Integer.parseInt(fechas[1]), Integer.parseInt(fechas[2]));
        return dia;
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

    public PrecioAcordado getUltimoPrecio () {

        return this.preciosAcordados.get(this.preciosAcordados.size()-1);
    }

    public PrecioPorProveedorDTO toDTO () {
        PrecioPorProveedorDTO dto = new PrecioPorProveedorDTO();
        dto.proveedor = this.getCuitProveedor();

        return dto;
    }

    public UltimoPrecioDTO toUltimoPrecioDTO () {
        UltimoPrecioDTO dto = new UltimoPrecioDTO();

        dto.cuit = this.cuitProveedor;
        dto.fechaAcuerdo = getUltimoPrecio().getFechaAcuerdo();
        dto.monto = getUltimoPrecio().getMonto();

        return dto;
    }

    public static class UltimoPrecioDTO {
        public LocalDate fechaAcuerdo;
        public float monto;
        public String nombreProveedor;
        public int cuit;
    }

    public static class PrecioPorProveedorDTO {
        public Producto.ProductoDTO producto;
        public Integer proveedor;
    }
}
