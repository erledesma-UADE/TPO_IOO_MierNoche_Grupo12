package models.domain;

public class Retencion {
    private int idRetencion;
    private Impuesto impuesto;
    private float monto;

    public Retencion(int idRetencion, Impuesto impuesto, float monto) {
        this.idRetencion = idRetencion;
        this.impuesto = impuesto;
        this.monto = monto;
    }

    public void setIdRetencion(int idRetencion) {
        this.idRetencion = idRetencion;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }


    public int getIdRetencion() {
        return idRetencion;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public float getMonto() {
        return monto;
    }

    public float calcularRetencion(){
        return 0 ;

    }
}
