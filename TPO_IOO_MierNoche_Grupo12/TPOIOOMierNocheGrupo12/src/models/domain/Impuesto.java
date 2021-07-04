package models.domain;

public class Impuesto {
    private String tipo;
    private float porcentaje;

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

    public ImpuestoDTO toDTO () {
        ImpuestoDTO dto = new ImpuestoDTO();

        dto.porcentaje = this.porcentaje;
        dto.tipo = this.tipo;

        return dto;
    }

    public static class ImpuestoDTO {
        public String tipo;
        public float porcentaje;
    }
}
