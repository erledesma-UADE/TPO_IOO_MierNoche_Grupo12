package models.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompra extends ID {
    private LocalDate fecha;
    private List<Producto> productos;
    private Proveedor proveedor;

    public OrdenCompra() {
        this.productos = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Producto> getProducto() {
        return productos;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setProducto(List<Producto> producto) {
        this.productos = this.productos;
    }

    public void agregarProducto (Producto producto) {
        this.productos.add(producto);
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public boolean verificarTope(Proveedor proveedor){
        return false;
    }

    public OrdenCompraDTO toDTO () {
        OrdenCompraDTO dto = new OrdenCompraDTO();

        dto.fecha = this.fecha;
        this.productos.forEach(producto -> {
            dto.productos.add(producto.toDTO());
        });
        dto.proveedor = this.proveedor.toDTO();

        return dto;
    }

    public static class OrdenCompraDTO {
        public LocalDate fecha;
        public List<Producto.ProductoDTO> productos;
        public Proveedor.ProveedorDTO proveedor;
    }
}
