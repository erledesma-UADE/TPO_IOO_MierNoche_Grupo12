package models.domain;

import models.domain.documentos.Factura;
import models.domain.enums.Responsabilidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Proveedor {
    private int idProveedor;
    private int cuit;
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

    public Proveedor(int idProveedor, int cuit, Responsabilidad responsabilidad, String razonSocial, String nombre, String direccion,
                     int telefono, String email, int numeroIngresosBrutos, LocalDate inicioActividades, float tope){
        this.idProveedor = idProveedor;
        this.cuit = cuit;
        this.responsabilidad = responsabilidad;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.numeroIngresosBrutos = numeroIngresosBrutos;
        this.inicioActividades = inicioActividades;
        this.tope = tope;
        this.rubros = new ArrayList<>();

    }

    public void agregarRubro(Rubro... rubros){

        Collections.addAll(this.rubros,rubros);
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getCuit() {
        return cuit;
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

    public List<OrdenCompra> getOrdenDeCompra() {

        return ordenDeCompra;
    }

    public List<Factura> getFacturasEmitidas() {

        return facturasEmitidas;
    }

    public List<PrecioPorProducto> getCatalogo() {

        return catalogo;
    }

    public static class ProveedorDTO{
        public int idProveedor;
        public int cuit;
        public String razonSocial;
        public String nombre;
        public String direccion;
        public int telefono;
        public String email;
        public int numeroIngresosBrutos;
        public List<Rubro> rubros;
        public float tope;

    }
    public ProveedorDTO toTDO(){
        ProveedorDTO dto = new ProveedorDTO();
        dto.idProveedor = this.getIdProveedor();
        dto.cuit = this.getCuit();
        dto.razonSocial = this.getRazonSocial();
        dto.nombre = this.getNombre();
        dto.direccion = this.getDireccion();
        dto.telefono = this.getTelefono();
        dto.email = this.getEmail();
        dto.numeroIngresosBrutos = this.getNumeroIngresosBrutos();
        dto.rubros = this.getRubros();
        dto.tope = this.getTope();
        return dto;
    }
}
