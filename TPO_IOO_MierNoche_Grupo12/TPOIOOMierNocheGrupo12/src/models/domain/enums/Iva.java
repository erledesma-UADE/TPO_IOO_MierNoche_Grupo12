package models.domain.enums;

public enum Iva {

    tipo1(2.5),
    tipo2(5),
    tipo3(10.5),
    tipo4(21),
    tipo5(27);

    private double porcentaje;

    Iva(double porcentaje){
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }


    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
