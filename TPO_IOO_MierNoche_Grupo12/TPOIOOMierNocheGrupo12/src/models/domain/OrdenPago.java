package models.domain;

import models.domain.documentos.Documento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenPago extends ID {
    private int idOrdenPago;
    private List<Documento> documentos;
    private String tipoPago;
    private Proveedor proveedor;
    private float totalRetenciones;
    private List<Retencion> retenciones;
    private int idDocumento;
    private LocalDateTime fecha;
    private float montoTotal;
    private enum TipoPago{
        EFECTIVO,
        CREDITO,
        DEBITO
    }
    private TipoPago formaPago;

    private boolean pagado;



    public OrdenPago(int idOrdenPago, List<Documento> documentos, String tipoPago, Proveedor proveedor,
                     float totalRetenciones, List<Retencion> retenciones,
                     int idDocumento, LocalDateTime fecha, float montoTotal, TipoPago formaPago,boolean pagado) {
        this.idOrdenPago = idOrdenPago;
        this.documentos = documentos;
        this.tipoPago = tipoPago;
        this.proveedor = proveedor;
        this.totalRetenciones = totalRetenciones;
        this.retenciones = retenciones;
        this.idDocumento = idDocumento;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.formaPago = formaPago;
        this.pagado = pagado;
    }

    public void setIdOrdenPago(int idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setTotalRetenciones(float totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }

    public void setRetenciones(List<Retencion> retenciones) {
        this.retenciones = retenciones;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFormaPago(TipoPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getIdOrdenPago() {
        return idOrdenPago;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public float getTotalRetenciones() {
        return totalRetenciones;
    }

    public List<Retencion> getRetenciones() {
        return retenciones;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public float calcularMontoTotal() {  // operacion del diagrama
        return montoTotal;
    }

    public boolean isPagado() {
        return pagado;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public TipoPago getFormaPago() {
        return formaPago;
    }

    public float getTotalRetencionesPorProveedor(){  //reconoce que habla de proveedor por eso no lo paso como parametros
        int mainController = 0; //reemplazar por getProveedorPorid(proveedorid);
        if (proveedor.getIdProveedor()==mainController){
            return getTotalRetenciones();

        }
        else{
            return 0;
        }

    }

    public void getDetallesOrdenDePago(){
        String cadena= "";
        cadena= "id orden de pago " + this.getIdOrdenPago() +
                "\nlista Documentos: ";
        for(int i = 0; i<documentos.size();i++){
            cadena += "\nidDocumento " + documentos.get(i).getIdDocumento() + "\n tipo de documento " + documentos.get(i).getTipoDocumento();


        }
        cadena+= "\nforma de pago" + this.getFormaPago() +
                "\nproveedor: " + getProveedor().getRazonSocial() +
                "\ntotal retenciones: " + getTotalRetenciones() +
                "\nretenciones: ";
        for(int i=0;i<retenciones.size();i++){
            cadena+= "\nid retencion: "+ retenciones.get(i).getIdRetencion();
        }
        cadena+="\nFecha: " + getFecha() +
                "\nMonto total:" + getMontoTotal() +
                "\n pagado: " + isPagado();
        System.out.println(cadena);

    }

    public void getDetallesDocumentos(){
        String cadena= "";
        for(int i = 0; i<documentos.size();i++){
            cadena+="\nid documento: "+documentos.get(i).getTipoDocumento()+
                    "\nfecha: " + documentos.get(i).getFecha() +
                    "\nmonto total: " + documentos.get(i).getMontoTotal() +
                    "\npagado: " +  documentos.get(i).isPagado() ;
            for(int j = 0;j<documentos.get(i).getArticulos().size();j++){
                /*
                Esto lo que hace  es que cuando documento llegue a la parte de articulos recorre toda la lista de articulos
                y la concatena a la cadena.
                 */
                cadena+="\nProducto:" + documentos.get(i).getArticulos().get(j).getProducto() +
                        "\nCantidad: " +documentos.get(i).getArticulos().get(j).getCantidad() +
                        "\nImpuesto total: " +  documentos.get(i).getArticulos().get(j).getImpuestoTotal();

            }
            cadena+= "\ntipo de documento: " + documentos.get(i).getTipoDocumento() +
                    "\nproveedor: " + documentos.get(i).getProveedor().getIdProveedor();


        }

        System.out.println(cadena);

    }


    public OrdenPagoDTO toDTO(){
        OrdenPagoDTO dto= new OrdenPagoDTO();
        dto.idOrdenpago = super.getID();
        dto.documentos = this.documentos;
        dto.TipoPago = this.tipoPago;
        dto.proveedor = this.proveedor;
        dto.totalRetenciones = this.totalRetenciones;
        dto.idDocumento = super.getID();
        dto.fecha = this.fecha;
        dto.montoTotal = this.montoTotal;
        dto.formaPago = this.formaPago;
        dto.pagado = this.pagado;
        return dto;


    }

    public class OrdenPagoDTO{
        public int idOrdenpago;
        public List<Documento> documentos;
        public String TipoPago;
        public Proveedor proveedor;
        public float totalRetenciones;
        public List<Retencion> retenciones;
        public int idDocumento;
        public LocalDateTime fecha;
        public float montoTotal;
        
        public TipoPago formaPago;
        public boolean pagado;

    }


}
