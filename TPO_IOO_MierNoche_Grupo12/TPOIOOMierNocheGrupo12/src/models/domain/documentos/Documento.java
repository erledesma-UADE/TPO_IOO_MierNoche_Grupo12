package models.domain.documentos;

import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDateTime;

public abstract class Documento {
    private int idDocumento;
    private LocalDateTime fecha;
    private float montoTotal;
    private boolean pagado;
    private List<CantidadPorProducto> articulos;
    private TipoDocumento tipoDocumento;
    private Proveedor proveedor;

    public Documento(TipoDocumento tipoDocumento,Proveedor proveedor,LocalDateTime fecha){
        this.pagado = false;
        this.tipoDocumento = tipoDocumento;
        this.proveedor = proveedor;
        this.fecha = fecha;
        //IDs cómo lo manejamos?
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public List<CantidadPorProducto> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<CantidadPorProducto> articulos) {
        this.articulos = articulos;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public DocumentoDTO toDTO() {
        DocumentoDTO dto    = new DocumentoDTO();
        dto.proveedor       = this.proveedor;
        dto.idDocumento     = this.idDocumento;
        dto.fecha           = this.fecha;
        dto.montoTotal      = this.montoTotal;
        dto.pagado          = pagado;
        dto.articulos       = articulos;
        dto.tipoDocumento   = tipoDocumento;
        return dto;
    }


    public static class DocumentoDTO{
        public Proveedor proveedor;
        public int idDocumento;
        public LocalDateTime fecha;
        public float montoTotal;
        public boolean pagado;
        public List<CantidadPorProducto> articulos;
        public TipoDocumento tipoDocumento;
    }
}
