package models.domain;

import java.time.LocalDate;

public class PrecioAcordado {
    private LocalDate fechaAcuerdo;
    private float monto;

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


    public PrecioAcordadoDTO toDTO () {
        PrecioAcordadoDTO dto = new PrecioAcordadoDTO();

        dto.fechaAcuerdo = this.fechaAcuerdo;
        dto.monto = this.monto;

        return dto;
    }

    public static class PrecioAcordadoDTO {
        public LocalDate fechaAcuerdo;
        public float  monto;
    }
}
