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

    public float calcularRetencion(){
        return 0 ;

    }
}
