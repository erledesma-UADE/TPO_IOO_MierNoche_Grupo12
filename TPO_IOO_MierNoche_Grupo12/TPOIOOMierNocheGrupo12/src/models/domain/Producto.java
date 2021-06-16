package models.domain;

import java.util.List;

public class Producto {
    private int idProducto;
    private String nombre;
    private String tipoUnidad;
    private float impuesto;
    private List<PrecioPorProducto> precioPorProveedor;

    public Producto(int idProducto, String nombre, String tipoUnidad, float impuesto) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipoUnidad = tipoUnidad;
        this.impuesto = impuesto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public float getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(float impuesto) {
        this.impuesto = impuesto;
    }
}
