package controllers;

import models.domain.Proveedor;

import java.time.LocalDate;

public class MainController {

    public float totalFacturasRecibidas(int idProveedor) {
        return 0;
    }

    public float totalFacturasRecibidasProveedorDia(int idProveedor, LocalDate fecha) {
        return 0;
    }

    public void detalleCuentaCorriente(int idProveedor) {
    }

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
