package models.domain;

import java.util.List;

public class Rubro extends ID {
    private int idRubro;
    private String nombre;
    private List<Producto> productos;
    private List<Proveedor> proveedor;

    public Rubro(int idRubro, String nombre, List<Producto> productos, List<Proveedor> proveedor) {
        this.idRubro = idRubro;
        this.nombre = nombre;
        this.productos = productos;
        this.proveedor = proveedor;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
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

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor.add(proveedor);
    }

    public RubroDTO toDTO (int idRubro) {
        RubroDTO dto = new RubroDTO();
        dto.idRubro = this.idRubro;
        dto.nombre = this.nombre;
        //dto.proveedores -> falta definir ProveedorDTO;

        //dto.productos -> recorro la lista de productos de la clase y las convierte a DTO
        //luego agerga a la lista del RubroDTO
        for (Producto p : this.productos) {
                Producto.ProductoDTO pDTO= p.toDTO();
                dto.productos.add(pDTO);
            }

        return dto;
    }

    public static class RubroDTO {
        public int idRubro;
        public String nombre;
        public List<Producto.ProductoDTO> productos;
        //public List<ProveedorDTO> proveedores;
    }
}
