package models.domain;

import java.util.List;

public class Rubro {
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
}
