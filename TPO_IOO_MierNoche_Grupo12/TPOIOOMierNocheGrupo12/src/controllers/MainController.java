package controllers;

import controllers.exceptions.CuitRepetidoException;
import models.domain.CuentaCorriente;
import models.domain.OrdenPago;
import models.domain.PreciosAcordados;
import models.domain.Proveedor;
import models.repositories.RepositorioCuentasCorrientes;
import models.repositories.RepositorioOrdenesDePago;
import models.repositories.RepositorioProveedores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainController {

    private static MainController instancia;
    private RepositorioProveedores repositorioProveedores;
    private RepositorioOrdenesDePago repositorioOrdenesDePago;
    private RepositorioCuentasCorrientes repositorioCuentasCorrientes;

    public static MainController getInstancia () {
        if(MainController.instancia == null)
            instancia = new MainController();
        return instancia;
    }

    private MainController(){

        this.repositorioProveedores = new RepositorioProveedores();
        this.repositorioOrdenesDePago  = new RepositorioOrdenesDePago();
    }

    public void altaProveedor(Proveedor.ProveedorDTO proveedorDTO){
        this.validarDatosProveedor(proveedorDTO);
        Proveedor proveedor = new Proveedor();
        asignarParametrosProveedor(proveedor,proveedorDTO);
        this.repositorioProveedores.agregar(proveedor);
    }

    public void altaOrdenPago (OrdenPago.OrdenPagoDTO ordenPagoDTO) {
        validarDatosProveedor(ordenPagoDTO.proveedor);
        OrdenPago ordenPago = new OrdenPago();
        //asignarParametrosOrdenPago()
    }

    private void validarDatosProveedor(Proveedor.ProveedorDTO proveedorDTO){
        if(this.validarCuit(proveedorDTO.cuit)){
            throw new CuitRepetidoException("El proveedor ya existe");
        }
    }

    private boolean validarCuit(int cuit){
        Optional<Proveedor> proveedor = this.repositorioProveedores.buscarPorCuit(cuit);
        return proveedor.isPresent();
    }

    public void agregarPrecioAcordado (PreciosAcordados.PrecioAcordadoDTO precioAcordadoDTO) {
        PreciosAcordados precioAcordado = new PreciosAcordados();
    }

    private void asignarParametrosProveedor(Proveedor proveedor, Proveedor.ProveedorDTO proveedorDto){
        proveedor.setCuit(proveedorDto.cuit);
        proveedor.setDireccion(proveedorDto.direccion);
        proveedor.setEmail(proveedorDto.email);
        proveedor.setNombre(proveedorDto.nombre);
        proveedor.setInicioActividades(proveedorDto.inicioActividades);
        proveedor.setRazonSocial(proveedorDto.razonSocial);
        proveedor.setResponsabilidad(proveedorDto.responsabilidad);
        proveedor.setNumeroIngresosBrutos(proveedorDto.numeroIngresosBrutos);
        proveedor.setTope(proveedorDto.tope);
        proveedor.setCertificado(proveedorDto.certificado);
        //proveedor.setCatalogo(proveedorDto.catalogo);
        proveedor.setRubros(proveedorDto.rubros);
        //proveedor.setImpuestos(proveedorDto.impuestos);
    }

    public List<Proveedor.ProveedorDTO> listarProveedores(){
        List<Proveedor.ProveedorDTO> listaProveedoresDto = new ArrayList<>();
        for (Proveedor proveedorOriginal : this.repositorioProveedores.getElementos()) {
            Proveedor.ProveedorDTO proveedorDto = proveedorOriginal.toDTO();
            listaProveedoresDto.add(proveedorDto);
        }
        return listaProveedoresDto;
    }

    public int totalFacturasRecibidas(int idProveedor) {
        Optional<Proveedor> proveedorActual = Optional.of(new Proveedor());
         proveedorActual= this.repositorioProveedores.getPorID(idProveedor);
        return proveedorActual.get().cantidadFacturasEmitidas();
    }

    public int totalFacturasRecibidasEldia(int idProveedor, LocalDate unDia){
        Optional<Proveedor> proveedorActual = Optional.of(new Proveedor());
        proveedorActual= this.repositorioProveedores.getPorID(idProveedor);
        return proveedorActual.get().cantidadFacturasEmitasElDia(unDia);
    }

    public RepositorioProveedores getRepositorioProveedores() {
        return repositorioProveedores;
    }

    public void setRepositorioProveedores(RepositorioProveedores repositorioProveedores) {
        this.repositorioProveedores = repositorioProveedores;
    }

    public RepositorioOrdenesDePago getRepositorioOrdenesDePago() {
        return repositorioOrdenesDePago;
    }

    public void setRepositorioOrdenesDePago(RepositorioOrdenesDePago repositorioOrdenesDePago) {
        this.repositorioOrdenesDePago = repositorioOrdenesDePago;
    }

    public float totalFacturasRecibidasProveedorDia(int idProveedor, LocalDate fecha) {
        return 0;
    }

    public void detalleCuentaCorriente(int idProveedor) {}

    public float totalDeudaProveedor(int idProveedor) {
        return 0;
    }

    public void mostrarLibroIVACompras () {}

    public void ordenesPagoEmitidas () {}

    public void getOrdenesDePago () {}

    public void /*Proveedor*/ getProveedor (int idProveedor) {} //devuelve un ProveedorDTO

    public List<CuentaCorriente.VistaCuentasProveedoresDTO> mostrarCuentaCorrienteProveedores () {
        List<CuentaCorriente.VistaCuentasProveedoresDTO>  cuentasDTO = new ArrayList<>();

        this.repositorioCuentasCorrientes.getElementos().forEach(documento -> {
            cuentasDTO.add(documento.toVistaCuentasProveedoresDTO());
        });
        /*cuentasDTO.forEach(cuenta -> {
            cuenta.montoDeuda;
            cuenta.documentos.forEach(doc -> {
                doc.cuitProveedor;
                doc.idDocumento;
            });
        });*/
        return cuentasDTO;
    }

    public List<OrdenPago.OrdenPagoDTO> verOrdenesPago () {
        List<OrdenPago.OrdenPagoDTO> ordenes = new ArrayList<>();

        this.repositorioOrdenesDePago.getElementos().forEach(orden -> {
            ordenes.add(orden.toDTO());
        });

        return ordenes;
    }

    public float deudaPorProveedor (int cuit) {
        return this.repositorioCuentasCorrientes.buscarPorCuitProveedor(cuit).get().getMontoDeuda();
    }

    public float totalImpuestosRetenidos () {
        float totalImpuestosRetenidos = 0;

        for (OrdenPago orden : this.repositorioOrdenesDePago.getElementos()) {
            totalImpuestosRetenidos += orden.calcularTotalRetenciones();
        }

        return totalImpuestosRetenidos;
    }

    public void getCuentasProveedores () {} //Seria una Lista de CuentaCorrienteDTO ?

    public float getTotalRetencionesPorProveedor (int idProveedor) { return 0; }

    public void /*ProveedorDTO*/getProveedorPorId (int idProveedor) {}
}
