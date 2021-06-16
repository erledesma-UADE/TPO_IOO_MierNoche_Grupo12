package models.domain;

import models.domain.documentos.Documento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenPago {
    private int idOrdenPago;
    private List<Documento> documentos;
    private String tipoPago;
    private Proveedor proveedor;
    private float totalRetenciones;
    private List<Retencion> retenciones;
    private int idDocumento;
    private LocalDateTime fecha;
    private float montoTotal;


    public OrdenPago(int idOrdenPago, List<Documento> documentos, String tipoPago, Proveedor proveedor,
                     float totalRetenciones, List<Retencion> retenciones,
                     int idDocumento, LocalDateTime fecha, float montoTotal) {
        this.idOrdenPago = idOrdenPago;
        this.documentos = documentos;
        this.tipoPago = tipoPago;
        this.proveedor = proveedor;
        this.totalRetenciones = totalRetenciones;
        this.retenciones = retenciones;
        this.idDocumento = idDocumento;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public void setIdOrdenPago(int idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setTotalRetenciones(float totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }

    public void setRetenciones(List<Retencion> retenciones) {
        this.retenciones = retenciones;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getIdOrdenPago() {
        return idOrdenPago;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public float getTotalRetenciones() {
        return totalRetenciones;
    }

    public List<Retencion> getRetenciones() {
        return retenciones;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public float calcularMontoTotal() {  // operacion del diagrama
        return montoTotal;
    }
}
