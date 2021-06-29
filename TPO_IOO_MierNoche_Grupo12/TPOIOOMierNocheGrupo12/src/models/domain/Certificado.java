package models.domain;

import java.time.LocalDate;

public class Certificado extends ID {
    private int idProveedor;
    private LocalDate fechaInicio;
    private String fechaInicios;
    private LocalDate fechaVencimiento;
    private String fechaVencimientos;
    private Impuesto tipoImpuesto;

    public Certificado(int idProveedor, LocalDate fechaInicio, LocalDate fechaVencimiento, Impuesto tipoImpuesto) {
        this.idProveedor = idProveedor;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoImpuesto = tipoImpuesto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Impuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(Impuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }
}
