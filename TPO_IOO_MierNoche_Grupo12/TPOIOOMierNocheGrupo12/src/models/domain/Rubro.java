package models.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Rubro extends ID {
    private String nombre;
    private List<Producto> productos;
    private List<Proveedor> proveedores;

    public Rubro() {
        this.proveedores = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void setProducto(Optional<Producto> producto) {
        this.productos.add(producto.get());
    }

    public void agregarProveedores(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    public void setProveedores(Optional<Proveedor> proveedor) {
        this.proveedores.add(proveedor.get());
    }

    public RubroDTO toDTO () {
        RubroDTO dto = new RubroDTO();

        dto.idRubro = super.getID();
        dto.nombre = this.nombre;

        if (this.proveedores != null) {
            for (Proveedor proveedor : this.proveedores) {
                Proveedor.ProveedorDTO proveedorDTO = proveedor.toDTO();
                dto.proveedores.add(proveedorDTO);
            }
        }

        if (this.productos != null) {
            for (Producto p : this.productos) {
                Producto.ProductoDTO pDTO = p.toDTO();
                dto.productos.add(pDTO);
            }
        }

        return dto;
    }

    public static class RubroDTO {
        public Integer idRubro;
        public String nombre;
        public List<Integer> idsProductos;
        public List<Integer> idsProveedores;
        public List<Producto.ProductoDTO> productos;
        public List<Proveedor.ProveedorDTO> proveedores;

        public RubroDTO () {
            this.proveedores = new ArrayList<>();
            this.productos = new ArrayList<>();
        }
    }
}
