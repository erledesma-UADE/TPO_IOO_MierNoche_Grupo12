package controllers;

import models.domain.Producto;
import models.domain.Rubro;
import models.domain.repositories.RepositorioRubros;

import java.util.Optional;

public class RubrosController {
    private static RubrosController instancia;
    private RepositorioRubros repositorioRubros;

    public static RubrosController getInstancia () {
        if(RubrosController.instancia == null)
            instancia = new RubrosController();
        return instancia;
    }

    public RubrosController () {
        this.repositorioRubros = new RepositorioRubros();
    }

    public void mostrarCompulsa (int idRubro, int idProducto) {
        try {
            Optional<Rubro> rubro = this.repositorioRubros.getPorID(idRubro);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se encontro el Rubro solicitado");
        }

    };

    public Optional getRubroPorID (int idRubro) {////////REVISAR
        return repositorioRubros.getPorID(idRubro);
    }//Creo que este no hace falta, usaria el del repositorio directamente
}
