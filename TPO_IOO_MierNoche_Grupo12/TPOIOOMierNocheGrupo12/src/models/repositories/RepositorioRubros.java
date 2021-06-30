package models.repositories;

import models.domain.Producto;
import models.domain.Proveedor;
import models.domain.Rubro;

import java.util.List;

public class RepositorioRubros extends Repositorio<Rubro> {

    private static RepositorioRubros instancia;

    public static RepositorioRubros getInstancia(){
        if(RepositorioRubros.instancia == null)
            instancia = new RepositorioRubros();
        return instancia;
    }

    public RepositorioRubros(){
        super();
        //super.elementos = DatosProveedores.getProveedores();
    }

}
