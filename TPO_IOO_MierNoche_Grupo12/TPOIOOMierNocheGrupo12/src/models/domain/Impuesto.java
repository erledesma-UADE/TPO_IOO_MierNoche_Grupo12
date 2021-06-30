package models.domain;

public class Impuesto {
    //----------------PARA PROBAR ALTA FACTURA ---------------
    private float porcentaje;
    private String tipoImpuesto;

    public Impuesto(){

    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public float impResposabilidad(String resp){
        if(resp.equals("INSCRIPTO")){
            return 21;
        }else{
            return 11;
        }
    }

    public float impGanancias(int monto){
        if (monto >= 10000 && monto<25000){
            return 1200;
        }else if(monto>=25000 && monto<100000) {
            return 1800;
        }else if(monto >= 100000){
            return 2500;
        }else{
            return 0;
        }
    }

    public float impIngBrutos(){
        return 6;
    }

}
