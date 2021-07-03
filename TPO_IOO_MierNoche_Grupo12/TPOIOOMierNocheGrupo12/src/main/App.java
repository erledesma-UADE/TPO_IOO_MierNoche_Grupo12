package main;

import com.sun.tools.javac.Main;
import controllers.DocumentosController;
import controllers.MainController;
import models.domain.*;
import models.domain.documentos.Documento;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioDocumentos;
import models.repositories.RepositorioProductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class App {

    public static void main(String[] args) {

        DocumentosController documentosController = DocumentosController.getInstancia();
        RepositorioProductos repositorioProductos = RepositorioProductos.getInstancia();
        RepositorioDocumentos repositorioDocumentos = RepositorioDocumentos.getInstancia();

        for (Producto producto : repositorioProductos.getElementos()) {
            System.out.println("\nProducto id: " + producto.getID() + " Nombre: " + producto.getNombre());
            List<PrecioPorProveedor> precioPorProducto = producto.getPrecioPorProveedor();
            for(PrecioPorProveedor precioPorProveedor : precioPorProducto){
                System.out.println("\nCuit proveedor: " + precioPorProveedor.getCuitProveedor() + " - Producto: " + precioPorProveedor.getProducto().getNombre());
                List<PrecioAcordado> preciosAcordados = precioPorProveedor.getPreciosAcordados();
                for(PrecioAcordado precioAcordado : preciosAcordados){
                    System.out.println("Fecha acuerdo " + precioAcordado.getFechaAcuerdo() + " - Monto: " + precioAcordado.getMonto());
                }
            }
        }


        for(Documento documento : repositorioDocumentos.getElementos()){
            System.out.println("\nFactura: " + documento.getID() + " - Proveedor: " + documento.getProveedor().get().getCuit() + " - Tipo: " + documento.getTipoDocumento().name()+
                    " - fecha " + documento.getFecha());
            System.out.println("Articulos ");
            List<CantidadPorProducto> cantPorProd = documento.getArticulos();
            for (CantidadPorProducto cant : cantPorProd){
                System.out.print(" Articulo: " + cant.getProducto().getNombre() + " cantidad: " + cant.getCantidad() + " IVA: " + cant.getTipoImpuesto().getPorcentaje() + " precio total: " + cant.getPrecioFinal()+"\n");
            }

           System.out.print("Monto total " + documento.getMontoTotal() + "\n");
        }



        //MainController mainController = MainController.getInstancia();

    }
}



        /*
        ************ PRUEBA ALTA DOCUMENTO **************

        Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
        Documento.DocumentoDTO documentoDTO = new Documento.DocumentoDTO();

        /*CantidadPorProducto[] arrayArticulosObj = new ArrayList<Object>().toArray();
        CantidadPorProducto objetoPrueba = {"nombre" : "Lapicera", ""}*


        String[][] pruebaArticulos = new String[1][2];
        pruebaArticulos[0][0] = "Lapicera";
        pruebaArticulos[0][1] = "3";


        //Buscar cómo hacer una matriz dinámica.

        proveedorDTO.cuit = 1234;

        documentoDTO.tipoDocumento = TipoDocumento.Factura;
        documentoDTO.cuitProveedor = 1234;
        documentoDTO.fechaString = "2020-05-03";
        documentoDTO.pagado = false;
        documentoDTO.articulosVista = pruebaArticulos;

        mainController.altaProveedor(proveedorDTO);

        Optional<Proveedor> proveedor = mainController.getRepositorioProveedores().buscarPorCuit(documentoDTO.cuitProveedor);

        documentosController.altaDocumento(documentoDTO, proveedor);

        List<Documento> listaProductos = documentosController.getRepositorioDocumentos().getElementos();

        for (Documento documento : listaProductos) {
            List<CantidadPorProducto> listaProductosPrueba = documento.getArticulos();
            System.out.print("proveedor " + documento.getCuitProveedor() + "\n");
            for (CantidadPorProducto cantidad : listaProductosPrueba) {
                System.out.println("productos " + cantidad.getProducto().get().getNombre());
            }
        }
    }
}


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

    }

}*/
/*import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
        public class lista {
            static class DateItem {
                String datetime;
                DateItem(String date) {
                    this.datetime = date;
                }
            }
            static class SortByDate implements Comparator<DateItem> {
                @Override
                public int compare(DateItem a, DateItem b) {
                    return a.datetime.compareTo(b.datetime);
                }
            }
            public static void main(String args[]) {
                List<DateItem> dateList = new ArrayList<>();
                dateList.add(new DateItem("2020-03-25"));
                dateList.add(new DateItem("2019-01-27"));
                dateList.add(new DateItem("2020-03-26"));
                dateList.add(new DateItem("2020-02-26"));
                dateList.sort(new SortByDate());
                dateList.forEach(date -> {
                    System.out.println(date.datetime);
                });
            }
        }
    }}
*/