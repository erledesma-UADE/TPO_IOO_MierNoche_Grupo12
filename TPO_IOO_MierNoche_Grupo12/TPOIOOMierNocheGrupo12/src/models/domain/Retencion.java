package models.domain;

public class Retencion extends ID {
    private Impuesto impuesto;
    private float monto;

    public Retencion(Impuesto impuesto, float monto) {
            this.impuesto = impuesto;
            this.monto = monto;
        }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public float getMonto() {
        return monto;
    }

    public float calcularRetencion(){
            return 0;
        }
    }

