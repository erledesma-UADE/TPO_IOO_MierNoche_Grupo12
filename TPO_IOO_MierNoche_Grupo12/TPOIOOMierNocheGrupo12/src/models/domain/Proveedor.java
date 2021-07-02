package models.domain;

import controllers.RubrosController;
import models.domain.documentos.Factura;
import models.domain.enums.Responsabilidad;

import java.time.LocalDate;
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
    private String inicioActividad; //agregado para json
    private List<Rubro> rubros;
    private float tope;
    private List<OrdenCompra> ordenDeCompra;
    private List<Factura> facturasEmitidas;
    private List<PrecioPorProveedor> catalogo;
    private Certificado certificado;
    private List<Impuesto> impuestos;
    private List<OrdenPago> ordenPago;
    private CuentaCorriente cuentaCorriente;

    public Proveedor() {
        this.rubros = new ArrayList<>();
        this.ordenDeCompra = new ArrayList<>();
        this.facturasEmitidas = new ArrayList<>();
        this.catalogo = new ArrayList<>();
        this.impuestos = new ArrayList<>();

    }

    public float sumarOrdenesPago(){//////////////////////////////////////////////
        float sumador = 0;

        for( int i=0; i<ordenPago.size();i++){
            sumador += ordenPago.get(i).calcularTotalRetenciones();
        }

        return sumador;
    }//Verificar si se usa en algun lado


    public void agregarRubro(Rubro... rubros){
        Collections.addAll(this.rubros,rubros);
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setRubros(List<Rubro.RubroDTO> rubrosDTO) {
        RubrosController rubroController = RubrosController.getInstancia();

        rubrosDTO.forEach(rubroDTO -> {
            if (rubroController.getRepositorioRubros().getPorID(rubroDTO.idRubro).isPresent()) {
                this.rubros.add(rubroController.getRepositorioRubros().getPorID(rubroDTO.idRubro).get());
            }
        });
    }

    public void setOrdenDeCompra(List<OrdenCompra> ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public void setFacturasEmitidas(List<Factura> facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public void setCatalogo(List<PrecioPorProveedor> catalogo) {
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

    public CuentaCorriente getCuentaCorriente() {
        return this.cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
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

    public List<PrecioPorProveedor> getCatalogo() {
        return catalogo;
    }

    public void emitirDocumento () {}

    public int cantidadFacturasEmitidas(){
        return getFacturasEmitidas().size();
    }

    public List<OrdenPago> getOrdenPago() {  // hay que acordarse de agregar orden de pago .
        return ordenPago;
    }

    public void setOrdenPago(List<OrdenPago> ordenPago) {
        this.ordenPago = ordenPago;
    }

    public void agregarCatalogo(PrecioPorProveedor precioProveedor){
        this.getCatalogo().add(precioProveedor);
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
        public int idProveedor;
        public int cuit;
        public Responsabilidad responsabilidad;
        public String razonSocial;
        public String nombre;
        public String direccion;
        public int telefono;
        public String email;
        public int numeroIngresosBrutos;
        public LocalDate inicioActividades;
        public List<Rubro.RubroDTO> rubros;
        public float tope;
        public List<OrdenCompra.OrdenCompraDTO> ordenDeCompra;
        public List<Factura.FacturaDTO> facturasEmitidas;
        public List<PrecioPorProveedor.PrecioPorProveedorDTO> catalogo;
        public Certificado certificado;
        public List<Impuesto.ImpuestoDTO> impuestos;
    }

    public ProveedorDTO toDTO() {
        Proveedor.ProveedorDTO dto    = new Proveedor.ProveedorDTO();
        dto.idProveedor = super.getID();
        dto.cuit = this.cuit;
        dto.responsabilidad = this.responsabilidad;
        dto.razonSocial = this.razonSocial;
        dto.nombre = this.nombre;
        dto.direccion = this.direccion;
        dto.telefono = this.telefono;
        dto.email = this.email;
        dto.numeroIngresosBrutos = this.numeroIngresosBrutos;
        dto.inicioActividades = this.inicioActividades;
        dto.tope = this.tope;
        dto.certificado = this.certificado;

        this.impuestos.forEach(impuesto -> {
            dto.impuestos.add(impuesto.toDTO());
        });

        this.ordenDeCompra.forEach(ordenCompra -> {
            dto.ordenDeCompra.add(ordenCompra.toDTO());
        });

        this.rubros.forEach(rubro -> {
            dto.rubros.add(rubro.toDTO());
        });

        this.catalogo.forEach(precioPorProveedor -> {
            dto.catalogo.add(precioPorProveedor.toDTO());
        });

        this.impuestos.forEach(impuesto -> {
            dto.impuestos.add(impuesto.toDTO());
        });

        return dto;
    }

}
