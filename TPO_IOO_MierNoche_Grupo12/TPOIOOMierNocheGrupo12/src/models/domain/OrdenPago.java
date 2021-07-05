package models.domain;

import models.domain.documentos.Documento;
import models.domain.enums.TipoPago;
import models.repositories.RepositorioRetenciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenPago extends ID {
    private List<Documento> documentos;
    private TipoPago tipoPago;
    private Proveedor proveedor;
    private float totalRetenciones;
    private List<Retencion> retenciones;
    private LocalDate fecha;
    private float subTotal;
    private float montoTotal;
    private TipoPago formaPago;
    private boolean pagado;

    public OrdenPago() {
        this.retenciones = new ArrayList<>();
        this.documentos =new ArrayList<>();
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public void setTipoPago(TipoPago tipoPago) {
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

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setSubTotal(float monto){
        this.subTotal = monto;
    }

    public void calcularSubtotal(){
        float montoAux = 0;
        for(Documento documento : this.getDocumentos()){
            montoAux += documento.getMontoTotal();
        }
        this.setSubTotal(montoAux);
    }

    public float getSubTotal() {
        return subTotal;
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

    public void cambiarEstado(){
        for(Documento documento : this.documentos){
            documento.cambiarEstado();
        }
        this.pagado = true;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public float getTotalRetenciones() {
        return this.totalRetenciones;
    }

    public List<Retencion> getRetenciones() {
        return this.retenciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void calcularMontoTotal() {
        System.out.println("subtotal " + this.getSubTotal() + "retenciones " + this.getTotalRetenciones());
        this.setMontoTotal(this.getSubTotal() - this.getTotalRetenciones());
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

    public void agregarRetencion(Retencion retencion){
        this.getRetenciones().add(retencion);
    }

    public void agregarDocumento(Documento documento){
        this.getDocumentos().add(documento);
    }


    public void calcularTotalRetenciones () {
        float totalRetenciones = 0;

        for (Retencion retencion : this.retenciones) {
            totalRetenciones += retencion.getMonto();
        };

        this.totalRetenciones = totalRetenciones;
    }


    public void agregarRetenciones(){
        RepositorioRetenciones repositorioRetenciones = RepositorioRetenciones.getInstancia();
        List<Retencion> retenciones = new ArrayList<>();
        for(Impuesto impuesto : this.getProveedor().getImpuestos()){
            Retencion retencion = new Retencion();
            retencion.setImpuesto(impuesto);
            retencion.setMonto(subTotal);
            retenciones.add(retencion);
            repositorioRetenciones.agregar(retencion);
        }
        this.setRetenciones(retenciones);
    }



    public static class OrdenPagoDTO {
        public List<Documento.DocumentoDTO> documentos;
        public List<Integer> idsDocumentos;
        public Proveedor.ProveedorDTO proveedor;
        public Integer cuitProveedor;
        public float totalRetenciones;
        public List<Retencion.RetencionDTO> retenciones;
        public LocalDate fecha;
        public float montoTotal;
        public TipoPago tipoPago;
        public boolean pagado;
    }

    public OrdenPagoDTO toDTO() {
        OrdenPagoDTO dto = new OrdenPagoDTO();
        dto.fecha = this.fecha;
        dto.montoTotal = this.montoTotal;
        dto.pagado = this.pagado;
        dto.proveedor = this.proveedor.toDTO();
        dto.tipoPago = this.tipoPago;
        dto.totalRetenciones = this.totalRetenciones;

        /*this.documentos.forEach(documento -> {
            dto.documentos.add(documento.toDTO());
        });

        this.retenciones.forEach(retencion -> {
            dto.retenciones.add(retencion.toDTO());
        });*/

        return dto;
    }

    /*public float getTotalRetencionesPorProveedor(){  //reconoce que habla de proveedor por eso no lo paso como parametros
        int mainController = 0; //reemplazar por getProveedorPorid(proveedorid);
        if (proveedor.getIdProveedor()==mainController){
            return getTotalRetenciones();

        }
        else{
            return 0;
        }

    }*/

    /*public void getDetallesOrdenDePago(){
        String cadena= "";
        cadena= "id orden de pago " + super.getID() +
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
    }*/

    /*public void getDetallesDocumentos(){
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

                cadena+="\nProducto:" + documentos.get(i).getArticulos().get(j).getProducto() +
                        "\nCantidad: " +documentos.get(i).getArticulos().get(j).getCantidad() +
                        "\nImpuesto total: " +  documentos.get(i).getArticulos().get(j).getImpuestoTotal();

            }
            cadena+= "\ntipo de documento: " + documentos.get(i).getTipoDocumento() +
                    "\n proovedor: " + documentos.get(i).getProveedor().getIdProveedor();


        }

        System.out.println(cadena);

    }*/





}
