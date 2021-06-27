package main;

import controllers.DocumentosController;
import controllers.MainController;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
        Proveedor.ProveedorDTO proveedorDTO2 = new Proveedor.ProveedorDTO();
        Proveedor.ProveedorDTO proveedorDTO3 = new Proveedor.ProveedorDTO();
        proveedorDTO.cuit = 1234569;
        proveedorDTO3.cuit = 1234569;
        proveedorDTO2.cuit = 1234;

        MainController mainController = new MainController();
        DocumentosController documentosController = new DocumentosController();

        mainController.altaProveedor(proveedorDTO);
        mainController.altaProveedor(proveedorDTO2);
        mainController.altaProveedor(proveedorDTO3);

        List<Proveedor.ProveedorDTO> listaProveedores = new ArrayList<>();
        listaProveedores = mainController.listarProveedores();

        listaProveedores.forEach(x -> {
            System.out.println(x.cuit);
        });

        LocalDate now = LocalDate.now();


        Documento.DocumentoDTO factura1 = new Documento.DocumentoDTO();

        factura1.fecha = now;
        factura1.tipoDocumento = TipoDocumento.Factura;
        factura1.cuitProveedor = 2345;


        documentosController.altaDocumento(factura1);


    }

}
