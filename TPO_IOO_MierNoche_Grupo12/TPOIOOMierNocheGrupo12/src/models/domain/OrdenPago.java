package models.domain;

import controllers.DocumentosController;
import controllers.exceptions.DocumentoInexistenteException;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;
import models.domain.enums.TipoPago;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenPago extends ID {
    private List<Documento> documentos;
    private String tipoPago;
    private Proveedor proveedor;
    private float totalRetenciones;
    private List<Retencion> retenciones;
    private LocalDateTime fecha;
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

    public void agregarRetencion(Retencion retencion){
        this.retenciones.add(retencion);
    }

    public float calcularTotalRetenciones () {
        float totalRetenciones = 0;

        for (Retencion retencion : this.retenciones) {
            totalRetenciones += retencion.getMonto();
        };

        return totalRetenciones;
    }

    public void asignarFactura (Factura.FacturaDTO facturaDTO) {
        DocumentosController documentosController = DocumentosController.getInstancia();

        if (documentosController.getRepositorioDocumentos().getPorID(facturaDTO.idFactura).isPresent()) {
            this.documentos.add(documentosController.getRepositorioDocumentos().getPorID(facturaDTO.idFactura).get());
        } else {
            throw new DocumentoInexistenteException("No se encontro el documento");
        }
    }

    public static class OrdenPagoDTO {
        public List<Documento.DocumentoDTO> documentos;
        public String tipoPago;
        public Proveedor.ProveedorDTO proveedor;
        public float totalRetenciones;
        public List<Retencion.RetencionDTO> retenciones;
        public LocalDateTime fecha;
        public float montoTotal;
        public TipoPago formaPago;
        public boolean pagado;
    }

    public OrdenPagoDTO toDTO() {
        OrdenPagoDTO dto = new OrdenPagoDTO();
        dto.fecha = this.fecha;
        dto.montoTotal = this.montoTotal;
        dto.pagado = this.pagado;
        dto.proveedor = this.proveedor.toDTO();
        dto.formaPago = this.formaPago;
        dto.tipoPago = this.tipoPago;
        dto.totalRetenciones = this.totalRetenciones;

        this.documentos.forEach(documento -> {
            dto.documentos.add(documento.toDTO());
        });

        this.retenciones.forEach(retencion -> {
            dto.retenciones.add(retencion.toDTO());
        });

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
