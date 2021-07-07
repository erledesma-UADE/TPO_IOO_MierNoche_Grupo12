package main;

import Views.MenuPrincipal;
import com.sun.tools.javac.Main;
import controllers.DocumentosController;
import controllers.MainController;
import controllers.RubrosController;
import models.domain.*;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;
import models.repositories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class App {

    public static void main(String[] args) {

        DocumentosController documentosController = DocumentosController.getInstancia();
        RepositorioProductos repositorioProductos = RepositorioProductos.getInstancia();
        RepositorioDocumentos repositorioDocumentos = RepositorioDocumentos.getInstancia();
        RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();
        RepositorioOrdenesDePago repositorioOrdenesDePago = RepositorioOrdenesDePago.getInstancia();
        RepositorioRetenciones repositorioRetenciones = RepositorioRetenciones.getInstancia();
        RepositorioRubros repositorioRubros = RepositorioRubros.getInstancia();
        RubrosController rubrosController = RubrosController.getInstancia();
        MainController mainController = MainController.getInstancia();


        MenuPrincipal menu = new MenuPrincipal();
        menu.framePpal.setVisible(true);

    }
}

        /******************* CÓDIGO PARA VERIFICAR DATOS CARGADOS ***************************/

        //List<CuentaCorriente.VistaCuentasProveedoresDTO> cuentaCorriente = mainController.mostrarCuentaCorrienteProveedores();

        /*List<MainController.LibroIVADTO> libroIva = mainController.libroIVA();
        libroIva.forEach(x -> {
            System.out.println("\nProveedor: " + x.nombreProveedor);
            System.out.println("\tCuit: " + x.cuitProveedor);
            System.out.println("\tFecha: " + x.fecha);
            System.out.println("\tIVA: " + x.iva.getPorcentaje());
            System.out.println("\tTotal: " + x.total);
        });*/

        /*for(CuentaCorriente.VistaCuentasProveedoresDTO ctaCorriente : cuentaCorriente){
            System.out.println("cantidad Docs: " + ctaCorriente.documentos.size());
            System.out.println("\nProveedor : " + ctaCorriente.idProveedor + " monto deuda: " + ctaCorriente.montoDeuda );
            List<Documento.DocumentoDTO> facturasPagas = ctaCorriente.documentosPagos;
            System.out.print("\nFacturas pagas: ");
            for(Documento.DocumentoDTO docPago : facturasPagas){
                System.out.println(docPago.idDocumento + " monto: " + docPago.montoTotal);
            }
            List<Documento.DocumentoDTO> facturasimPagas = ctaCorriente.documentosImpagos;
            System.out.print("\nFacturas impagos: ");
            for(Documento.DocumentoDTO docimPago : facturasimPagas){
                System.out.println(docimPago.idDocumento + " monto: " + docimPago.montoTotal);
            }
        }*/

        /*for (Producto producto : repositorioProductos.getElementos()) {
            System.out.println("\nProducto id: " + producto.getID() + " Nombre: " + producto.getNombre());
            List<PrecioPorProveedor> precioPorProducto = producto.getPrecioPorProveedor();
            for(PrecioPorProveedor precioPorProveedor : precioPorProducto){
                System.out.println("\nCuit proveedor: " + precioPorProveedor.getCuitProveedor() + " - Producto: " + precioPorProveedor.getProducto().getNombre());
                List<PrecioAcordado> preciosAcordados = precioPorProveedor.getPreciosAcordados();
                for(PrecioAcordado precioAcordado : preciosAcordados){
                    System.out.println("Fecha acuerdo " + precioAcordado.getFechaAcuerdo() + " - Monto: " + precioAcordado.getMonto());
                }
            }
        }*/

        /*for(Documento documento : repositorioDocumentos.getElementos()) {
                Factura factura = (Factura) documento;

                System.out.println("\nFactura: " + documento.getID() + " - Proveedor: " + documento.getProveedor().get().getCuit() + " - Tipo: " + documento.getTipoDocumento().name() +
                        " - fecha " + documento.getFecha());
                System.out.println("Articulos ");
                List<CantidadPorProducto> cantPorProd = documento.getArticulos();
                for (CantidadPorProducto cant : cantPorProd) {
                    System.out.print(" Articulo: " + cant.getProducto().getNombre() + " cantidad: " + cant.getCantidad() + " IVA: " + cant.getTipoImpuesto().getPorcentaje() + " precio total: " + cant.getPrecioFinal() + "\n");
                }
                List<Impuesto> listaImpuestos = factura.getImpuestos();

                for(Impuesto impuesto : listaImpuestos){
                    System.out.println("Impuesto: " + impuesto.getTipo() + " porcentaje: " + impuesto.getPorcentaje() );
                }

                System.out.print("Monto total " + documento.getMontoTotal() + "\n");
           // }
        }
    }
*/

