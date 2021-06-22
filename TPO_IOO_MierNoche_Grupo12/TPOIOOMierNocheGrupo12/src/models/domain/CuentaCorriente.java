package models.domain;

import models.domain.documentos.Documento;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente extends ID {
    private int IDCuentaCorriente;
    private Proveedor proveedor;
    private float debito;
    private float credito;
    private List<Documento> documentos;
    private float montoDeuda;


    public CuentaCorriente(int IDCuentaCorriente, Proveedor proveedor, float debito, float credito,
                           List<Documento> documentos, float montoDeuda) {
        this.IDCuentaCorriente = IDCuentaCorriente;
        this.proveedor = proveedor;
        this.debito = debito;
        this.credito = credito;
        this.documentos = documentos;
        this.montoDeuda = montoDeuda;
    }

    public void setIDCuentaCorriente(int IDCuentaCorriente) {
        this.IDCuentaCorriente = IDCuentaCorriente;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void setMontoDeuda(float montoDeuda) {
        this.montoDeuda = montoDeuda;

    }

    public void actualizarMontoDeuda(Documento documento){ // metodo diagrama
        this.montoDeuda = documento.getMontoTotal();
    }



    public int getIDCuentaCorriente() {
        return IDCuentaCorriente;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public float getDebito() {
        return debito;
    }

    public float getCredito() {
        return credito;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public float getMontoDeuda() { // metodo devuelve monto deuda
        return montoDeuda;
    }

    public void MostrarDetalle(){
        String cadena;
        cadena= "id cuenta corriente: " + this.getIDCuentaCorriente() +
                "\nproveedor: " + this.getProveedor() +
                "\ndebito: " + this.getDebito() +
                "\ncredito: " + this.getCredito() +
                "\ndocumentos: "+ this.getDocumentos() +
                "\nmonto deuda: "+ this.getMontoDeuda();
        System.out.print(cadena);
    }
}
