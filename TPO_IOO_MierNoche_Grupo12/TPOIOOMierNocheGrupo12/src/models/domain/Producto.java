package models.domain;

import models.domain.enums.Iva;

import java.util.List;

public class Producto extends ID {
    private String nombre;
    private String tipoUnidad;
    private Iva impuesto;
    private List<PrecioPorProveedor> precioPorProveedor;

    public Producto () {}

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

    public List<PrecioPorProveedor> getPrecioPorProveedor() {
        return precioPorProveedor;
    }

    public void setPrecioPorProveedor(List<PrecioPorProveedor> precioPorProveedor) {
        this.precioPorProveedor = precioPorProveedor;
    }

    public float buscarPrecioProveedor(Integer cuitProveedor){
        final float[] monto = {0};
        this.getPrecioPorProveedor().stream().forEach(precioProveedor ->{
            if(precioProveedor.getCuitProveedor()== cuitProveedor){
                monto[0] = precioProveedor.getUltimoPrecio().getMonto();
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
        for (PrecioPorProveedor pPproveedor : this.precioPorProveedor) {
            PrecioPorProveedor.PrecioPorProveedorDTO pPproveedorDTO = pPproveedor.toDTO();
            dto.precioPorProveedor.add(pPproveedorDTO);
        }

        return dto;
    }

    public static class ProductoDTO {
        public int idProducto;
        public String nombre;
        public String tipoUnidad;
        public Iva impuesto;
        public List<PrecioPorProveedor.PrecioPorProveedorDTO> precioPorProveedor;
    }
}
