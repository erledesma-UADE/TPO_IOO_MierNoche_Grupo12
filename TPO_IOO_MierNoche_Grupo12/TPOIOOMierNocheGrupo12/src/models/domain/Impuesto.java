package models.domain;

public class Impuesto {
    String tipo;
    float porcentaje;

    public Impuesto(String tipo, float porcentaje) {
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
