package models.domain;

import java.time.LocalDate;

public class PreciosAcordados {
    private LocalDate fechaAcuerdo;
    private float monto;
    private String fechaAcuerdoString;

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
}
