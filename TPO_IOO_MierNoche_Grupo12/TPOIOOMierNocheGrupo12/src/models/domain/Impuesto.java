package models.domain;

public class Impuesto{
    private String tipo;
    private float porcentaje;

    public Impuesto(String tipo, float porcentaje){
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }
}

