package controllers;

import models.domain.Proveedor;
import models.repositories.RepositorioProveedor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainController {
    private static MainController instancia;
    private RepositorioProveedor repoProveedor;

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

    public static MainController getInstancia(){
        if(MainController.instancia == null){
            instancia = new MainController();
        }
        return instancia;
    }

    private MainController(){
        this.repoProveedor = new RepositorioProveedor();
    }

    //public Proveedor.ProveedorDTO ver(Integer Id){
    //    return null;
    //}

    private void asignarParamA(Proveedor proveedor, Proveedor.ProveedorDTO dto){
        proveedor.setID(dto.id);
        proveedor.setCuit(dto.cuit);
        proveedor.setRazonSocial(dto.razonSocial);
        proveedor.setNombre(dto.nombre);
        proveedor.setDireccion(dto.direccion);
        proveedor.setTelefono(dto.telefono);
        proveedor.setEmail(dto.email);
        proveedor.setNumeroIngresosBrutos(dto.numeroIngresosBrutos);
        proveedor.setResponsabilidad(dto.responsabilidad);
        proveedor.setInicioActividades(dto.inicioActividades);
        proveedor.setTope(dto.tope);

        //--------------FALTA SETEAR RUBRO----------------

        dto.rubros.forEach(p -> proveedor.agregarRubro(p));

    }
    public void altaProveedor(Proveedor.ProveedorDTO dto){
        Proveedor prov = new Proveedor();
        this.asignarParamA(prov,dto);
        this.repoProveedor.agregar(prov);
    }

    public Proveedor.ProveedorDTO buscarProveedor(Integer id){
        Optional<Proveedor> prov = this.repoProveedor.getPorID(id);
        Proveedor proveedor = new Proveedor();
        if(!prov.isPresent()){
            //throw new Exception().
        }
        return prov.get().toTDO();
    }

    public List<Proveedor.ProveedorDTO> listarTodos() {
        return this.repoProveedor
                .buscarTodos()
                .stream()
                .map(Proveedor::toTDO)
                .collect(Collectors.toList());
    }
}
