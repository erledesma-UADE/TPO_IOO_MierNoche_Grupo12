package controllers;

import controllers.exceptions.ProductoNoPertenceAlRubroException;
import controllers.exceptions.RubroNoExisteException;
import models.domain.PrecioPorProducto;
import models.domain.Producto;
import models.domain.Rubro;
import models.repositories.RepositorioProductos;
import models.repositories.RepositorioRubros;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RubrosController {
    private static RubrosController instancia;
    private RepositorioRubros repositorioRubros;
    private RepositorioProductos repositorioProductos;

    public static RubrosController getInstancia() {
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


    public void agregarRubro(Rubro.RubroDTO dto){
        Rubro rubro = new Rubro();
        this.asignarParamA(rubro, dto);
        this.repositorioRubros.agregar(rubro);

    }

    private void asignarParamA(Rubro rubro, Rubro.RubroDTO dto){
        rubro.setID(dto.id);
        rubro.setNombre(dto.nombre);
        //List<Producto> productos = new ArrayList<>();
        //List<Proveedor> proveedores = new ArrayList<>();
    }

    public List<Rubro.RubroDTO> listarTodos() {
        return this.repositorioRubros
                .buscarTodos()
                .stream()
                .map(Rubro::toDTO)
                .collect(Collectors.toList());
    }

}
