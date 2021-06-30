package models.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /*public void agregarProductos(List<Producto.ProductoDTO> productos) {
        for (Producto.ProductoDTO productoDTO : productos) {
            Producto producto = new Producto();

            this.productos.add(producto);
        }
    }

    public void agregarProveedores(List<Proveedor.ProveedorDTO> proveedores) {
        for (Proveedor.ProveedorDTO provDTO : proveedores) {
            Proveedor proveedor = new Proveedor();

            this.proveedores.add(proveedor);
        }
    }*/

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
        public List<Producto.ProductoDTO> productos;
        public List<Proveedor.ProveedorDTO> proveedores;

        public RubroDTO () {
            this.proveedores = new ArrayList<>();
            this.productos = new ArrayList<>();
        }
    }
}
