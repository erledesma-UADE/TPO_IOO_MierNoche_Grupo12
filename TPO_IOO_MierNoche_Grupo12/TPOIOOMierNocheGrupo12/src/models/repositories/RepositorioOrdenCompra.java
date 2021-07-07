package models.repositories;

import models.domain.OrdenCompra;
import models.domain.documentos.Documento;
import models.repositories.Datos.DatosDocumentos;
import models.repositories.Datos.DatosOrdenCompra;

public class RepositorioOrdenCompra extends Repositorio<OrdenCompra> {
    private static RepositorioOrdenCompra instancia;

    public static RepositorioOrdenCompra getInstancia() {
        if (RepositorioOrdenCompra.instancia == null)
            instancia = new RepositorioOrdenCompra();
        return instancia;
    }

    private RepositorioOrdenCompra(){
        super();
        super.elementos = DatosOrdenCompra.getOrdenesCompra();
        System.out.println("Repo Documentos " + super.elementos);
    }
}