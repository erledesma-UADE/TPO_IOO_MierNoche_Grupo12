package models.domain;

import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.Responsabilidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Proveedor extends ID {
    private Integer cuit;
    private Responsabilidad responsabilidad;
    private String razonSocial;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;
    private int numeroIngresosBrutos;
    private LocalDate inicioActividades;
    private List<Rubro> rubros;
    private float tope;
    private List<OrdenCompra> ordenDeCompra;
    private List<Factura> facturasEmitidas;
    private List<PrecioPorProducto> catalogo;
    private Certificado certificado;
    private List<Impuesto> impuestos;

    public Proveedor() {
        this.rubros = new ArrayList<>();
        this.ordenDeCompra = new ArrayList<>();
        this.facturasEmitidas = new ArrayList<>();
        this.catalogo = new ArrayList<>();
        this.impuestos = new ArrayList<>();

    }

    public void agregarRubro(Rubro... rubros){
        Collections.addAll(this.rubros,rubros);
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setRubros(List<Rubro> rubros) {
        this.rubros = rubros;
    }

    public void setOrdenDeCompra(List<OrdenCompra> ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public void setFacturasEmitidas(List<Factura> facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public void setCatalogo(List<PrecioPorProducto> catalogo) {
        this.catalogo = catalogo;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public Responsabilidad getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(Responsabilidad responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroIngresosBrutos() {
        return numeroIngresosBrutos;
    }

    public void setNumeroIngresosBrutos(int numeroIngresosBrutos) {
        this.numeroIngresosBrutos = numeroIngresosBrutos;
    }

    public LocalDate getInicioActividades() {
        return inicioActividades;
    }

    public void setInicioActividades(LocalDate inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

    public float getTope() {
        return tope;
    }

    public void setTope(float tope) {
        this.tope = tope;
    }

    public List<Rubro> getRubros() {
        return rubros;
    }

    public List<OrdenCompra> getOrdenDeCompra() { // no estoy seguro si el size de orde de compra lo tengo que pedir aca
        //y luego abajo armar otro metodo o que.
        return ordenDeCompra;
    }

    public int cantidadOrdenCompraEmitidas(){ // no estoy seguro si el metodo va aca?
        return getOrdenDeCompra().size();
    }

    public List<Factura> getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public List<PrecioPorProducto> getCatalogo() {
        return catalogo;
    }

    public void emitirDocumento () {}

    public int cantidadFacturasEmitidas(){
        return getFacturasEmitidas().size();
    }

    public int cantidadFacturasEmitasElDia(LocalDate unDia){
        List<Factura> facturasEmitidasElDia = new ArrayList<>();
        getFacturasEmitidas().forEach(factura ->{
            if(factura.getFecha().equals(unDia)){
                facturasEmitidasElDia.add(factura);
            }
        });
        return facturasEmitidasElDia.size();
    }

    public static class ProveedorDTO{
        public int cuit;
        public Responsabilidad responsabilidad;
        public String razonSocial;
        public String nombre;
        public String direccion;
        public int telefono;
        public String email;
        public int numeroIngresosBrutos;
        public LocalDate inicioActividades;
        public List<Rubro> rubros;
        public float tope;
        public List<OrdenCompra> ordenDeCompra;
        public List<Factura> facturasEmitidas;
        public List<PrecioPorProducto> catalogo;
        public Certificado certificado;
        public List<Impuesto> impuestos;
    }

    public ProveedorDTO toDTO() {
        Proveedor.ProveedorDTO dto    = new Proveedor.ProveedorDTO();
        dto.cuit = this.cuit;
        dto.responsabilidad = this.responsabilidad;
        dto.razonSocial = this.razonSocial;
        dto.nombre = this.nombre;
        dto.direccion = this.direccion;
        dto.telefono = this.telefono;
        dto.email = this.email;
        dto.numeroIngresosBrutos = this.numeroIngresosBrutos;
        dto.inicioActividades = this.inicioActividades;
        dto.rubros = this.rubros;
        dto.tope = this.tope;
        dto.ordenDeCompra = this.ordenDeCompra;
        dto.facturasEmitidas = this.facturasEmitidas;
        dto.catalogo = this.catalogo;
        dto.certificado = this.certificado;
        dto.impuestos = this.impuestos;

        return dto;
    }

}
