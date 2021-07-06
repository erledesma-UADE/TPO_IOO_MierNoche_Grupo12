package models.repositories;

import models.domain.Proveedor;
import models.repositories.Datos.DatosProveedores;

import java.util.Optional;

public class RepositorioProveedores extends Repositorio<Proveedor> {
    private static RepositorioProveedores instancia;

    public static RepositorioProveedores getInstancia(){
        if(RepositorioProveedores.instancia == null)
            instancia = new RepositorioProveedores();
        return instancia;
    }

    private RepositorioProveedores(){
        super();
        super.elementos = DatosProveedores.getProveedores();
    }

    public Optional<Proveedor> buscarPorCuit(Integer cuit) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getCuit().equals(cuit))
                .findFirst();
    }
}
