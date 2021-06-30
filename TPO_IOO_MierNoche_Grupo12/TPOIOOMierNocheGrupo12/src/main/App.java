package main;

import controllers.DocumentosController;
import controllers.MainController;
import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.enums.TipoDocumento;

import java.util.List;
import java.util.Optional;


public class App {

    public static void main(String[] args) {

        MainController mainController = new MainController();
        DocumentosController documentosController = new DocumentosController();

        CargaJsons cargaJsons = new CargaJsons();

        cargaJsons.cargaArchivos(documentosController.getRepositorioProductos());


        /************* PRUEBA ALTA DOCUMENTO **************/

        Proveedor.ProveedorDTO proveedorDTO = new Proveedor.ProveedorDTO();
        Documento.DocumentoDTO documentoDTO = new Documento.DocumentoDTO();

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
        documentosController.altaDocumento(documentoDTO,proveedor);

        List<Documento> listaProductos = documentosController.getRepositorioDocumentos().getElementos();
        for (Documento documento : listaProductos) {
            System.out.println(documento.getMontoTotal());
        }


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

    }

}*/
    }}
