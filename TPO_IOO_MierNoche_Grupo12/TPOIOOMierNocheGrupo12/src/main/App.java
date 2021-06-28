package main;

import com.google.gson.Gson;
import com.sun.jdi.ArrayType;
import controllers.DocumentosController;
import controllers.MainController;
import models.domain.ID;
import models.domain.PrecioPorProducto;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.Iva;
import models.domain.enums.TipoDocumento;
import models.repositories.Repositorio;
import models.repositories.RepositorioProductos;

import javax.print.attribute.standard.PrinterURI;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class App {

    public static void main(String[] args) {

        RepositorioProductos repositorioProductos = new RepositorioProductos();
        CargaJsons cargaJsons = new CargaJsons();

        cargaJsons.cargaArchivos(repositorioProductos);


        List<Producto> listaProductos = repositorioProductos.getElementos();
        for (Producto producto : listaProductos) {
            System.out.println(producto.getNombre());
        }

        String[][] nombre = new String[1][2];



        //Producto p = gson.fromJson(jsonProductos,Producto.class);

        //System.out.println(p);


        /*Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
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


        documentosController.altaDocumento(factura1);*/


    }

}
