package models.domain.documentos;

import controllers.MainController;
import models.domain.CantidadPorProducto;
import models.domain.ID;
import models.domain.Impuesto;
import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Documento extends ID {
    private Optional<Proveedor> proveedor;
    private LocalDate fecha;
    private double montoTotal;
    private List<CantidadPorProducto> articulos;
    private TipoDocumento tipoDocumento;
    private boolean pagado;
    private Integer cuitProveedor;

    public Documento() {
        this.articulos = new ArrayList<>();
    }

    public Documento(String fechaString, Integer cuitProveedor, boolean pagado, TipoDocumento tipoDocumento) {
        this.articulos = new ArrayList<>();
        this.pagado = pagado;
        this.tipoDocumento = tipoDocumento;
    }

    public Optional<Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Optional<Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    public void setCuitProveedor(Integer cuitProveedor){
        this.cuitProveedor = cuitProveedor;
    }

    public LocalDate getFecha() {
        return this.fecha;
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

        double sumatotalAux = 0;

        for(Impuesto impuesto : proveedor.get().getImpuestos()){
            sumatotalAux += sumaTotal * (impuesto.getPorcentaje()/100);
        }

        this.montoTotal = sumaTotal + sumatotalAux;
    }

    public boolean isPagado() {
        return this.pagado;
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

    public void agregarArticulo(CantidadPorProducto producto){
        this.getArticulos().add(producto);
    }

    public void setArticulos(List<CantidadPorProducto> articulos) {
        this.articulos = articulos;
    }

    public void cambiarEstado () {
        this.setPagado(true);
        double montoActualizar = 0;

        if (this.getTipoDocumento().equals(TipoDocumento.Factura) ||
                this.getTipoDocumento().equals(TipoDocumento.NotaCredito)) {
            montoActualizar = this.getMontoTotal() * -1;
        } else {
            montoActualizar = this.getMontoTotal();
        }

        this.proveedor.get().getCuentaCorriente().actualizarMontoDeuda(montoActualizar);
    }

    public static class DocumentoDTO {
        public int idDocumento;
        public LocalDate fecha;
        public double montoTotal;
        public boolean pagado;
        public List<CantidadPorProducto> articulos;
        public TipoDocumento tipoDocumento;
        public Integer cuitProveedor;


        public void agregarArticulo(CantidadPorProducto articulo){
            this.articulos.add(articulo);
        }

    }

    public DocumentoDTO toDTO() {
        DocumentoDTO dto    = new DocumentoDTO();
        dto.idDocumento     = this.getID();
        dto.fecha           = this.fecha;
        dto.montoTotal      = this.montoTotal;
        dto.pagado          = pagado;
        dto.articulos       = articulos;
        dto.tipoDocumento   = tipoDocumento;
        dto.cuitProveedor   = cuitProveedor;


        return dto;
    }

}
