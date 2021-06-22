package models.domain;

import java.util.List;

public class Producto extends ID {
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

    public ProductoDTO toDTO () {
        ProductoDTO dto = new ProductoDTO();
        dto.idProducto = this.idProducto;
        dto.impuesto = this.impuesto;
        dto.nombre = this.nombre;
        dto.tipoUnidad = this.tipoUnidad;

        //dto.precioPorProveedor = this.precioPorProveedor;
        for (PrecioPorProducto pPproveedor : this.precioPorProveedor) {
            PrecioPorProducto.PrecioPorProductoDTO pPproveedorDTO = pPproveedor.toDTO();
            dto.precioPorProveedor.add(pPproveedorDTO);
        }

        return dto;
    }

    public static class ProductoDTO {
        public int idProducto;
        public String nombre;
        public String tipoUnidad;
        public float impuesto;
        public List<PrecioPorProducto.PrecioPorProductoDTO> precioPorProveedor;
    }
}
