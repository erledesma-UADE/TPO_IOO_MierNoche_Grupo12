package models.domain;

import java.time.LocalDate;

public class PreciosAcordados {
    private LocalDate fechaAcuerdo;
    private float monto;
    private int cuitProveedor;

    public LocalDate getFechaAcuerdo() {
        return fechaAcuerdo;
    }

    public void setFechaAcuerdo(LocalDate fechaAcuerdo) {
        this.fechaAcuerdo = fechaAcuerdo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setCuitProveedor (int cuitProveedor) { this.cuitProveedor = cuitProveedor; }

    public PrecioAcordadoDTO toDTO () {
        PrecioAcordadoDTO dto = new PrecioAcordadoDTO();

        dto.cuitProveedor = this.cuitProveedor;
        dto.fechaAcuerdo = this.fechaAcuerdo;
        dto.monto = this.monto;

        return dto;
    }

    public static class PrecioAcordadoDTO {
        public LocalDate fechaAcuerdo;
        public float  monto;
        public int cuitProveedor;
    }
}
