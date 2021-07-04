package models.repositories;

import models.domain.Retencion;

public class RepositorioRetenciones extends Repositorio<Retencion> {

    private static RepositorioRetenciones instancia;

    public static RepositorioRetenciones getInstancia(){
        if(RepositorioRetenciones.instancia == null)
            instancia = new RepositorioRetenciones();
        return instancia;
    }

    private RepositorioRetenciones() {
        super();
    }
}
