package controllers;

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

    public void mostrarCompulsa (int idRubro, int idProducto) {};

    public Optional getRubroPorID (int idRubro) {////////REVISAR
        return repositorioRubros.buscarID(idRubro);
    }
}
