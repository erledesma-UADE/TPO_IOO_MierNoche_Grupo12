package main;

import controllers.RubrosController;
import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.Rubro;

public class App {


    public static void main(String[] args) {

        Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
        Proveedor.ProveedorDTO proveedorDTO2 = new Proveedor.ProveedorDTO();
        proveedorDTO.cuit = 1234569;
        proveedorDTO.nombre = "Un Proveedor";
        proveedorDTO2.cuit = 1234;
        proveedorDTO2.nombre = "Segundo Proveedor";

        Producto.ProductoDTO productoDTO1 = new Producto.ProductoDTO();
        Producto.ProductoDTO productoDTO2 = new Producto.ProductoDTO();
        productoDTO1.nombre = "Primer Producto";
        productoDTO2.nombre = "Segundo Producto";


        //====================================================================
        //Prueba ALTA PROVEEDOR - LISTAR PROVEEDORES
        //====================================================================
        /*MainController mainController = new MainController();
        mainController.altaProveedor(proveedorDTO);
        mainController.altaProveedor(proveedorDTO2);

        List<Proveedor.ProveedorDTO> listaProveedores = new ArrayList<>();
        listaProveedores = mainController.listarProveedores();

        listaProveedores.forEach(x -> {
            System.out.println("CUIT Proveedor: " + x.cuit);
        });*/
        //====================================================================
        //FIN - Prueba ALTA PROVEEDOR - LISTAR PROVEEDORES
        //====================================================================

        //====================================================================
        //Prueba ALTA RUBRO - VER RUBRO - ALTA PRODUCTO - AGREGAR PRODUCTO
        //====================================================================
        RubrosController rubroController = new RubrosController();
        Rubro.RubroDTO rubroDTO = new Rubro.RubroDTO();
        rubroDTO.nombre = "Primer Rubro";
        rubroDTO.productos.add(productoDTO1);
        rubroDTO.productos.add(productoDTO2);

        rubroController.altaRubro(rubroDTO);
        rubroController.altaProducto(productoDTO1);
        rubroController.altaProducto(productoDTO2);
        rubroController.agregarProducto(1);
        Rubro.RubroDTO mostrarRubro0 = rubroController.verRubro(1);
        System.out.println("ID: " + mostrarRubro0.idRubro +
                            "\nNombre Primer Producto: " + mostrarRubro0.productos.get(0).nombre);
        //====================================================================
        //FIN - Prueba ALTA RUBRO - VER RUBRO
        //====================================================================


    }
}
