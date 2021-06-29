package models.domain;

import models.domain.enums.Iva;

import java.util.ArrayList;
import java.util.List;

public class Producto extends ID {
    private String nombre;
    private String tipoUnidad;
    private Iva impuesto;
    private List<PrecioPorProducto> precioPorProveedor;

    public Producto() {
        this.precioPorProveedor = new ArrayList<>();
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

    /*public void asignarParametros (ProductoDTO productoDTO) {
        this.setNombre(productoDTO.nombre);
        this.setTipoUnidad(productoDTO.tipoUnidad);
        this.setImpuesto(productoDTO.impuesto);
        agregarPrecioPorProveedor(productoDTO.precioPorProveedor);
    }*/

    public void agregarPrecioPorProveedor (List<PrecioPorProducto.PrecioPorProductoDTO> precioPorProductoDTO) {
        PrecioPorProducto precioPorProducto = new PrecioPorProducto();

        for (PrecioPorProducto.PrecioPorProductoDTO pPProveedor : precioPorProductoDTO) {
            precioPorProducto.asinarParametros(pPProveedor);
            this.precioPorProveedor.add(precioPorProducto);
        }
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

        public ProductoDTO () {
            this.precioPorProveedor = new ArrayList<>();
        }
    }
}
