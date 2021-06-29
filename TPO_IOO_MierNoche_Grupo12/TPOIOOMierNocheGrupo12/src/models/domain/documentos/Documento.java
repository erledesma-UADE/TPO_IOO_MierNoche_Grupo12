package models.domain.documentos;

import controllers.MainController;
import models.domain.CantidadPorProducto;
import models.domain.ID;
import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Documento extends ID {
    private int idDocumento;
    private Optional<Proveedor> proveedor;
    private LocalDate fecha;
    private String fechaString;
    private double montoTotal;
    private TipoDocumento tipoDocumento;
    private boolean pagado;
    private List<CantidadPorProducto> articulos;
    private Integer cuitProveedor;

    public Documento() {
        //this.fecha = LocalDate.now();
        this.articulos = new ArrayList<>();
        this.pagado = false;
    }

    public Optional<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Optional<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setCuitProveedor(Integer cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(){
        double sumaTotal = 0.0;
        List<CantidadPorProducto> articulosAux = this.getArticulos();
        for (int i = 0; i<articulosAux.size(); i++){
            sumaTotal += articulosAux.get(i).getPrecioFinal();
        }
        this.montoTotal = sumaTotal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<CantidadPorProducto> getArticulos() {
        return articulos;
    }

    public Integer getCuitProveedor() {
        return cuitProveedor;
    }

    public void setProveedor(Integer cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void agregarArticulo(CantidadPorProducto producto){
        this.getArticulos().add(producto);
    }

    public void setArticulos(List<CantidadPorProducto> articulos) {
        this.articulos = articulos;
    }

    public static class DocumentoDTO{
        public Integer cuitProveedor;
        public int idDocumento;
        public LocalDate fecha;
        public String fechaString;
        public double montoTotal;
        public boolean pagado;
        public List<CantidadPorProducto> articulos;
        public String[][] articulosVista;
        public TipoDocumento tipoDocumento;

        public void agregarArticulo(CantidadPorProducto articulo){
            this.articulos.add(articulo);
        }

    }

    public DocumentoDTO toDTO() {
        DocumentoDTO dto    = new DocumentoDTO();
        dto.cuitProveedor   = this.cuitProveedor;
        dto.idDocumento     = this.idDocumento;
        dto.fecha           = this.fecha;
        dto.montoTotal      = this.montoTotal;
        dto.pagado          = pagado;
        dto.articulos       = articulos;
        dto.tipoDocumento   = tipoDocumento;
        dto.fechaString     = this.fechaString;
        return dto;
    }

}
