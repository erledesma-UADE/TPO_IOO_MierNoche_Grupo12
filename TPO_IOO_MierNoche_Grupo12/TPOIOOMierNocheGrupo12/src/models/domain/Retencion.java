package models.domain;

public class Retencion extends ID {
    private Impuesto impuesto;
    private float monto;

    public Retencion() { }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public void setMonto(float montoTotal) {
        this.monto  = montoTotal * (impuesto.getPorcentaje() / 100);
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public float getMonto() {
        return monto;
    }

    /*public float calcularRetencion (float montoTotal) {
        return this.monto  = montoTotal * (impuesto.getPorcentaje() / 100);
    }*/

    public RetencionDTO toDTO () {
        RetencionDTO dto = new RetencionDTO();

        dto.idRetencion = super.getID();
        dto.impuesto = this.impuesto.toDTO();
        dto.monto = this.monto;

        return dto;
    }

    public static class RetencionDTO {
        public int idRetencion;
        public Impuesto.ImpuestoDTO impuesto;
        public float monto;
    }
}

