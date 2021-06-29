package controllers;

import controllers.exceptions.CuitRepetidoException;
import models.domain.Proveedor;
import models.repositories.RepositorioProveedores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainController {

    private static MainController instancia;
    private RepositorioProveedores repositorioProveedores;

    public static MainController getInstancia () {
        if(MainController.instancia == null)
            instancia = new MainController();
        return instancia;
    }

    public MainController(){
        this.repositorioProveedores = new RepositorioProveedores();
    }

    public void altaProveedor(Proveedor.ProveedorDTO proveedorDTO){
        this.validarDatosProveedor(proveedorDTO);
        Proveedor proveedor = new Proveedor();
        asignarParametrosProveedor(proveedor,proveedorDTO);
        this.repositorioProveedores.agregar(proveedor);
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
        proveedor.setCatalogo(proveedorDto.catalogo);
        proveedor.setRubros(proveedorDto.rubros);
        proveedor.setImpuestos(proveedorDto.impuestos);
    }

    public List<Proveedor.ProveedorDTO> listarProveedores(){
        List<Proveedor.ProveedorDTO> listaProveedoresDto = new ArrayList<>();
        for (Proveedor proveedorOriginal : this.repositorioProveedores.getElementos()) {
            Proveedor.ProveedorDTO proveedorDto = proveedorOriginal.toDTO();
            listaProveedoresDto.add(proveedorDto);
        }
        return listaProveedoresDto;
    }

    public float totalFacturasRecibidas(int idProveedor) {
        return 0;
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

    public void mostrarCuentaCorrienteProveedores () {}

    public void getCuentasProveedores () {} //Seria una Lista de CuentaCorrienteDTO ?

    public float getTotalRetencionesPorProveedor (int idProveedor) { return 0; }

    public void /*ProveedorDTO*/getProveedorPorId (int idProveedor) {}
}
