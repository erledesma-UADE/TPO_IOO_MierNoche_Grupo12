package main;

import controllers.MainController;
import models.domain.Proveedor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
        Proveedor.ProveedorDTO proveedorDTO2 = new Proveedor.ProveedorDTO();
        proveedorDTO.cuit = 1234569;
        proveedorDTO2.cuit = 1234;

        MainController mainController = new MainController();
        mainController.altaProveedor(proveedorDTO);
        mainController.altaProveedor(proveedorDTO2);

        List<Proveedor.ProveedorDTO> listaProveedores = new ArrayList<>();
        listaProveedores = mainController.listarProveedores();

        listaProveedores.forEach(x -> {
            System.out.println(x.cuit);
        });


    }

}
