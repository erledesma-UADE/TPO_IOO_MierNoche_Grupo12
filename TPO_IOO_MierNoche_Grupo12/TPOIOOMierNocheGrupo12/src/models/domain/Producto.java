package models.domain;

import models.domain.enums.Iva;

import java.util.List;

public class Producto extends ID {
    private String nombre;
    private String tipoUnidad;
    private Iva impuesto;
    private List<PrecioPorProducto> precioPorProveedor;

    public Producto(String nombre, String tipoUnidad,Iva impuesto) {
        this.nombre = nombre;
        this.tipoUnidad = tipoUnidad;
        this.impuesto = impuesto;
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

    public Iva getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Iva impuesto) { this.impuesto = impuesto; }

    //HACER -> devuelve el monto del impuesto para este producto
    public float montoImpuesto () {
        return 0;
    }

    public ProductoDTO toDTO () {
        ProductoDTO dto = new ProductoDTO();
        dto.impuesto = this.impuesto;
        dto.nombre = this.nombre;
        dto.tipoUnidad = this.tipoUnidad;
        dto.idProducto = super.getID();
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
        public Iva impuesto;
        public List<PrecioPorProducto.PrecioPorProductoDTO> precioPorProveedor;
    }
}
