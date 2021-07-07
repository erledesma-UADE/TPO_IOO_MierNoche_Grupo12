package controllers;

import controllers.exceptions.CuitRepetidoException;
import controllers.exceptions.ProveedorInexistenteException;
import models.domain.*;
import models.domain.documentos.Documento;
import models.domain.enums.Iva;
import models.domain.enums.TipoDocumento;
import models.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainController {

    private static MainController instancia;
    private RepositorioProveedores repositorioProveedores;
    private RepositorioOrdenesDePago repositorioOrdenesDePago;
    private RepositorioCuentasCorrientes repositorioCuentasCorrientes;
    private RepositorioRetenciones repositorioRetenciones;
    private RepositorioDocumentos repositorioDocumentos;
    private RepositorioRubros repositorioRubros;

    public static MainController getInstancia () {
        if(MainController.instancia == null)
            instancia = new MainController();
        return instancia;
    }

    private MainController(){
        this.repositorioRubros = RepositorioRubros.getInstancia();
        this.repositorioProveedores = RepositorioProveedores.getInstancia();
        this.repositorioOrdenesDePago  = RepositorioOrdenesDePago.getInstancia();
        this.repositorioCuentasCorrientes = RepositorioCuentasCorrientes.getInstancia();
        this.repositorioRetenciones = RepositorioRetenciones.getInstancia();
        this.repositorioDocumentos = RepositorioDocumentos.getInstancia();
    }

    //=================================================================================================================
    //INICIO GETTERS / SETTERS
    //=================================================================================================================

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

    public RepositorioCuentasCorrientes getRepositorioCuentasCorrientes() {
        return repositorioCuentasCorrientes;
    }

    public void setRepositorioCuentasCorrientes(RepositorioCuentasCorrientes repositorioCuentasCorrientes) {
        this.repositorioCuentasCorrientes = repositorioCuentasCorrientes;
    }

    public RepositorioRetenciones getRepositorioRetenciones() {
        return repositorioRetenciones;
    }

    public void setRepositorioRetenciones(RepositorioRetenciones repositorioRetenciones) {
        this.repositorioRetenciones = repositorioRetenciones;
    }
    //=================================================================================================================
    //FIN GETTERS / SETTERS
    //=================================================================================================================

    //=================================================================================================================
    //INICIO ORDEN DE PAGO
    //=================================================================================================================

    public void altaOrdenPago (OrdenPago.OrdenPagoDTO ordenPagoDTO) {
        validarDatosOrdenPago(ordenPagoDTO.cuitProveedor);
        OrdenPago ordenPago = new OrdenPago();
        asignarParametrosOrdenPago(ordenPago, ordenPagoDTO);
        this.repositorioOrdenesDePago.agregar(ordenPago);
    }

    public void validarDatosOrdenPago (Integer ordenPagoDTO) {
        if (!this.validarCuit(ordenPagoDTO)) {
            throw new ProveedorInexistenteException ("No se encontro el Proveedor");
        }
    }

    public void asignarParametrosOrdenPago (OrdenPago ordenPago, OrdenPago.OrdenPagoDTO ordenPagoDTO) {
        if (validarCuit(ordenPagoDTO.cuitProveedor)) {
            ordenPago.setProveedor(this.repositorioProveedores.buscarPorCuit(ordenPagoDTO.cuitProveedor).get());
        } else {
            throw new ProveedorInexistenteException("No se encontro el Proveedor");
        }

        ordenPago.setFormaPago(ordenPagoDTO.tipoPago);
        ordenPago.setFecha(ordenPagoDTO.fecha);
        ordenPago.setPagado(false);
        ordenPago.setMontoTotal(ordenPagoDTO.montoTotal);
        Proveedor proveedor = repositorioProveedores.buscarPorCuit(ordenPagoDTO.cuitProveedor).get();
        ordenPago.setProveedor(proveedor);
        List<Integer> idsDocumentos = ordenPagoDTO.idsDocumentos;
        for(Integer id : idsDocumentos){
            ordenPago.agregarDocumento(this.repositorioDocumentos.getPorID(id).get());
        }
        ordenPago.calcularSubtotal();
        ordenPago.agregarRetenciones();
        ordenPago.calcularTotalRetenciones();
        ordenPago.calcularMontoTotal();

    }
    //=================================================================================================================
    //FIN ORDEN DE PAGO
    //=================================================================================================================

    //=================================================================================================================
    //INICIO PROVEEDORES
    //=================================================================================================================

    public void altaProveedor(Proveedor.ProveedorDTO proveedorDTO){
        this.validarDatosProveedor(proveedorDTO.cuit);
        Proveedor proveedor = new Proveedor();
        asignarParametrosProveedor(proveedor,proveedorDTO);
        this.repositorioProveedores.agregar(proveedor);
    }

    public boolean validarCuit(int cuit){
        Optional<Proveedor> proveedor = this.repositorioProveedores.buscarPorCuit(cuit);
        return proveedor.isPresent();
    }

    private void validarDatosProveedor(Integer proveedorDTO){
        if (this.validarCuit(proveedorDTO)) {
            throw new CuitRepetidoException("El proveedor ya existe");
        }
    }

    private void asignarParametrosProveedor(Proveedor proveedor, Proveedor.ProveedorDTO proveedorDTO){
        proveedor.setCuit(proveedorDTO.cuit);
        proveedor.setDireccion(proveedorDTO.direccion);
        proveedor.setEmail(proveedorDTO.email);
        proveedor.setNombre(proveedorDTO.nombre);
        proveedor.setInicioActividades(proveedorDTO.inicioActividades);
        proveedor.setRazonSocial(proveedorDTO.razonSocial);
        proveedor.setResponsabilidad(proveedorDTO.responsabilidad);
        proveedor.setNumeroIngresosBrutos(proveedorDTO.numeroIngresosBrutos);
        proveedor.setTope(proveedorDTO.tope);
        proveedor.setCertificado(proveedorDTO.certificado);
        List<Rubro> rubros = new ArrayList<>();
        proveedorDTO.idsRubros.forEach(idRubro -> {
            if (this.repositorioRubros.getPorID(idRubro).isPresent()) {
                rubros.add(this.repositorioRubros.getPorID(idRubro).get());
            }
        });
        proveedor.setRubros(rubros);
        //proveedor.setCatalogo(proveedorDto.catalogo);
        //proveedor.setImpuestos(proveedorDto.impuestos);
    }

    public Proveedor.ProveedorDTO verProveedorPorCuit (int cuitProveedor) {
        return this.repositorioProveedores.buscarPorCuit(cuitProveedor).get().toDTO();
    }

    public List<Proveedor.ProveedorDTO> listarProveedores(){
        List<Proveedor.ProveedorDTO> listaProveedoresDto = new ArrayList<>();
        for (Proveedor proveedorOriginal : this.repositorioProveedores.getElementos()) {
            Proveedor.ProveedorDTO proveedorDto = proveedorOriginal.toDTO();
            listaProveedoresDto.add(proveedorDto);
        }
        return listaProveedoresDto;
    }
    //=================================================================================================================
    //FIN PROVEEDORES
    //=================================================================================================================

    //=================================================================================================================
    //INICIO CONSULTAS GENERALES
    //=================================================================================================================
    //-Total Facturas Recibidas / Cuenta Corriente Proveedores / Ordenes de Pago Emitidas /
    //-Total Deuda Por Proveedor / Total De Impuestos Retenidos
    //=================================================================================================================

    public int totalFacturasRecibidas(int cuitProveedor) {
        Optional<Proveedor> proveedorActual = this.repositorioProveedores.buscarPorCuit(cuitProveedor);
        return proveedorActual.get().cantidadFacturasEmitidas();
    }

    public int totalFacturasRecibidasEldia(int cuitProveedor, LocalDate unDia){
        Optional<Proveedor> proveedorActual = this.repositorioProveedores.buscarPorCuit(cuitProveedor);
        return proveedorActual.get().cantidadFacturasEmitasElDia(unDia);
    }

    public List<CuentaCorriente.VistaCuentasProveedoresDTO> mostrarCuentaCorrienteProveedores () {
        List<CuentaCorriente.VistaCuentasProveedoresDTO>  cuentasDTO = new ArrayList<>();

        this.repositorioCuentasCorrientes.getElementos().forEach(cuentaCorriente -> {
            cuentasDTO.add(cuentaCorriente.toVistaCuentasProveedoresDTO());
        });

        return cuentasDTO;
    }

    public List<OrdenPago.OrdenPagoDTO> ordenesPagoEmitidas () {
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

        for (Retencion retencion : this.repositorioRetenciones.getElementos()) {
            totalImpuestosRetenidos += retencion.getMonto();
        }

        return totalImpuestosRetenidos;
    }

    public List<LibroIVADTO> libroIVA () {
        List<LibroIVADTO> librosIVADTO = new ArrayList<>();

        for (Documento documento :this.repositorioDocumentos.getElementos()) {
            List<CantidadPorProducto> cantidades = documento.getArticulos();
            cantidades.forEach(producto -> {
                LibroIVADTO libroIVADTO = new LibroIVADTO();
                libroIVADTO.cuitProveedor = documento.getProveedor().get().getCuit();
                libroIVADTO.nombreProveedor = documento.getProveedor().get().getNombre();
                libroIVADTO.tipoDocumento = documento.getTipoDocumento();
                libroIVADTO.fecha = documento.getFecha();
                libroIVADTO.iva = producto.getTipoImpuesto();
                libroIVADTO.total = producto.getMontoImpuesto();
                librosIVADTO.add(libroIVADTO);
            });
        }

        return librosIVADTO;
    }

    public static class LibroIVADTO {
        public Integer cuitProveedor;
        public String nombreProveedor;
        public LocalDate fecha;
        public TipoDocumento tipoDocumento;
        public Iva iva;
        public double total;
    }
    //=================================================================================================================
    //FIN CONSULTAS GENERALES
    //=================================================================================================================
}
