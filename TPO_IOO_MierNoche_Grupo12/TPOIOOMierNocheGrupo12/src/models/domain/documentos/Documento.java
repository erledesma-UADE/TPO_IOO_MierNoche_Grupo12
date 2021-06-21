package models.domain.documentos;

import models.domain.CantidadPorProductos;
import models.domain.Proveedor;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Documento {
    private int idDocumento;
    private LocalDateTime fecha;
    private float montoTotal;
    private String tipoDocumento;
    private boolean pagado;
    private List<CantidadPorProductos> articulos;
    private Proveedor proveedor;




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

    public List<CantidadPorProductos> getArticulos() {
        return articulos;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
}
