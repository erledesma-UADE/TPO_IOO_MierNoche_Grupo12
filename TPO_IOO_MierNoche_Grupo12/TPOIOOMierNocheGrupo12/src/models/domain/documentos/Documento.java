package models.domain.documentos;

import models.domain.CantidadPorProducto;
import models.domain.ID;
import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Documento extends ID {
    private int idDocumento;
    private LocalDateTime fecha;
    private float montoTotal;
    private String tipoDocumento;
    private boolean pagado;
    private List<CantidadPorProducto> articulos;
    private Proveedor proveedor;

    public Documento(String tipoDocumento, Proveedor proveedor, LocalDateTime fecha) {
        this.tipoDocumento = tipoDocumento;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.pagado = false;
        this.montoTotal = 0;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<CantidadPorProducto> getArticulos() {
        return articulos;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public static class DocumentoDTO{
        public Proveedor proveedor;
        public int idDocumento;
        public LocalDateTime fecha;
        public float montoTotal;
        public boolean pagado;
        public List<CantidadPorProducto> articulos;
        public String tipoDocumento;
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

}
