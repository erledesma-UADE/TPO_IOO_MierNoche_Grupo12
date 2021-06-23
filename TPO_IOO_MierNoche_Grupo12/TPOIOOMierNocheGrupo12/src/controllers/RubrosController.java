package controllers;

import models.domain.PrecioPorProducto;
import models.domain.Producto;
import models.domain.Rubro;
import models.domain.exceptions.ProductoNoPertenceAlRubroException;
import models.domain.exceptions.RubroNoExisteException;
import models.domain.repositories.RepositorioProductos;
import models.domain.repositories.RepositorioRubros;

import java.util.List;
import java.util.Optional;

public class RubrosController {
    private static RubrosController instancia;
    private RepositorioRubros repositorioRubros;
    private RepositorioProductos repositorioProductos;

    public static RubrosController getInstancia () {
        if(RubrosController.instancia == null)
            instancia = new RubrosController();
        return instancia;
    }

    public RubrosController () {
        this.repositorioRubros = new RepositorioRubros();
    }

    public List<PrecioPorProducto.PrecioPorProductoDTO> mostrarCompulsa (int idRubro, int idProducto) {
            Optional<Rubro> rubro = this.repositorioRubros.getPorID(idRubro);
            if (rubro.isPresent()) {
                if (rubro.get().getProductos().contains(this.repositorioProductos.getPorID(idProducto))) {
                    Optional<Producto> producto = this.repositorioProductos.getPorID(idProducto);
                    return producto.get().toDTO().precioPorProveedor;
                } else {
                    throw new ProductoNoPertenceAlRubroException("El Producto " + idProducto + "no pertenece a ese rubro");
                }
            } else {
                throw new RubroNoExisteException("El Rubro " + idRubro + "no existe");
            }

    };

    //Creo que este no hace falta, usaria el del repositorio directamente
    public Optional getRubroPorID (int idRubro) {
        return repositorioRubros.getPorID(idRubro);
    }
}
