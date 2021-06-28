package models.domain;

import models.domain.enums.Iva;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class Producto extends ID {
    private String nombre;
    private String tipoUnidad;
    private Iva impuesto;
    private List<PrecioPorProducto> precioPorProveedor;

    public Producto(String nombre, String tipoUnidad, String impuestoAux) {
        this.nombre = nombre;
        this.tipoUnidad = tipoUnidad;
        this.impuesto = Iva.valueOf(impuestoAux);
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


    public float buscarPrecioProveedor(Integer idProveedor){
        final float[] monto = {0};
        this.precioPorProveedor.stream().forEach(precioProveedor ->{
            if(precioProveedor.getProveedor().getID().equals(idProveedor)){
                monto[0] = precioProveedor.getMonto();
            }
        });
            return monto[0];
        }


    public ProductoDTO toDTO () {
        ProductoDTO dto = new ProductoDTO();
        dto.impuesto = this.impuesto;
        dto.nombre = this.nombre;
        dto.tipoUnidad = this.tipoUnidad;
        dto.idProducto = super.getID();
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
