package models.repositories.Datos;

import models.domain.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class DatosProveedores {

    public static List<Proveedor> getProveedores(){
        List<Proveedor> proveedores = new ArrayList<>();
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setCuit(1234); //setearle todos los atributos
        proveedores.add(proveedor1);

        return proveedores;
    }

}
