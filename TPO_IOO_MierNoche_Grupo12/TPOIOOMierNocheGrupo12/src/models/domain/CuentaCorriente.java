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
                           List<Documento> documentos) {
        this.IDCuentaCorriente = IDCuentaCorriente;
        this.proveedor = proveedor;
        this.debito = debito;
        this.credito = credito;
        this.documentos = new ArrayList<>();
        documentos.forEach(documento -> {
            agregarDocumento(documento);
        });
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

    public void agregarDocumento (Documento documento) {
        this.documentos.add(documento);
        actualizarMontoDeuda(documento.getMontoTotal());
    }

    public void actualizarMontoDeuda(double monto) {
        this.montoDeuda += monto;
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

    public float getMontoDeuda() {
        return montoDeuda;
    }

    /*public void MostrarDetalle(){
        String cadena;
        cadena= "id cuenta corriente: " + this.getIDCuentaCorriente() +
                "\nproveedor: " + this.getProveedor() +
                "\ndebito: " + this.getDebito() +
                "\ncredito: " + this.getCredito() +
                "\ndocumentos: "+ this.getDocumentos() +
                "\nmonto deuda: "+ this.getMontoDeuda();
        System.out.print(cadena);
    }*/

    public void pagoImpago (List<Documento.DocumentoDTO> documentosPagos,
                            List<Documento.DocumentoDTO> documentosImpagos) {
        for (Documento documento: this.documentos) {
            if (documento.isPagado()) {
                documentosPagos.add(documento.toDTO());
            } else {
                documentosImpagos.add(documento.toDTO());
            }
        }
    }

    public VistaCuentasProveedoresDTO toVistaCuentasProveedoresDTO () {
        VistaCuentasProveedoresDTO dto = new VistaCuentasProveedoresDTO();

        this.documentos.forEach(documento -> {
            dto.documentos.add(documento.toDTO());
        });
        dto.montoDeuda = this.montoDeuda;
        pagoImpago(dto.documentosPagos, dto.documentosImpagos);

        return dto;
    }

    public CuentaCorrienteDTO toDTO(){
        CuentaCorrienteDTO dto = new CuentaCorrienteDTO();

        dto.IDCuentaCorriente = super.getID();
        dto.proveedor = this.proveedor;
        dto.debito = this.debito;
        dto.credito = this.credito;
        dto.documentos = this.documentos;
        dto.montoDeuda = this.montoDeuda;

        return dto;
    }

    public class CuentaCorrienteDTO{
        public Integer IDCuentaCorriente;
        public Proveedor proveedor;
        public float debito;
        public float credito;
        public List<Documento> documentos;
        public float montoDeuda;

        public CuentaCorrienteDTO(){this.documentos = new ArrayList<>();}

    }

    public static class VistaCuentasProveedoresDTO {
        public float montoDeuda;
        public List<Documento.DocumentoDTO> documentos;
        public List<Documento.DocumentoDTO> documentosImpagos;
        public List<Documento.DocumentoDTO> documentosPagos;
    }
}
