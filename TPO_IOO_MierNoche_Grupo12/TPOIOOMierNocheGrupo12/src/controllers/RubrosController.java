package controllers;

import models.domain.PrecioPorProveedor;
import models.domain.Producto;
import models.domain.Rubro;
import controllers.exceptions.ProductoNoPertenceAlRubroException;
import controllers.exceptions.RubroNoExisteException;
import models.repositories.RepositorioPrecioPorProveedor;
import models.repositories.RepositorioProductos;
import models.repositories.RepositorioRubros;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RubrosController {
    private static RubrosController instancia;
    private RepositorioRubros repositorioRubros;
    private RepositorioProductos repositorioProductos;
    private RepositorioPrecioPorProveedor repositorioPrecioPorProducto;

    private MainController mainController = MainController.getInstancia();

    public static RubrosController getInstancia () {
        if(RubrosController.instancia == null)
            instancia = new RubrosController();
        return instancia;
    }

    private RubrosController () {
        this.repositorioRubros = new RepositorioRubros();
        this.repositorioProductos = new RepositorioProductos();
        this.repositorioPrecioPorProducto = new RepositorioPrecioPorProveedor();
    }

    public RepositorioRubros getRepositorioRubros() {
        return repositorioRubros;
    }

    public RepositorioProductos getRepositorioProductos() {
        return repositorioProductos;
    }

    public RepositorioPrecioPorProveedor getRepositorioPrecioPorProducto() {
        return repositorioPrecioPorProducto;
    }

    public void altaRubro (Rubro.RubroDTO rubroDTO) {
        Rubro rubro = new Rubro();
        rubro.setNombre(rubroDTO.nombre);

        this.repositorioRubros.agregar(rubro);
    }

    /*public void altaProducto (Producto.ProductoDTO productoDTO) {
        Producto producto = new Producto();
        asignarParametrosProducto(producto, productoDTO);

        this.repositorioProductos.agregar(producto);
    }*/

    public void asignarParametroRubro (Rubro rubro, Rubro.RubroDTO rubroDTO) {
        rubro.setNombre(rubroDTO.nombre);
        rubroDTO.productos.forEach(productoDTO -> {
            agregarProducto(productoDTO.idProducto);
        });
    }

    public void agregarProducto(Integer id) {
        this.repositorioRubros.getPorID(id).get().getProductos().add(this.repositorioProductos.getPorID(id).get());
    }

    public void asignarParametrosProducto (Producto producto, Producto.ProductoDTO productoDTO) {
        producto.setNombre(productoDTO.nombre);
        producto.setTipoUnidad(productoDTO.tipoUnidad);
        producto.setImpuesto(productoDTO.impuesto);
        //agregarPrecioPorProveedor(productoDTO.precioPorProveedor);
    }

    public void asignarParametrosPrecioPorProducto (PrecioPorProveedor precioPorProveedor,
                                                    PrecioPorProveedor.PrecioPorProveedorDTO precioPorProductoDTO) {

    }

    public void agregarProveedores(Integer id) {
    }

    public Rubro.RubroDTO verRubro (Integer id) {
        Optional<Rubro> rubro = this.repositorioRubros.getPorID(id);

        if(!rubro.isPresent()) {
            throw new RubroNoExisteException("El rubro solicitado es inexistente");
        }

        return rubro.get().toDTO();
    }

    public List<Rubro.RubroDTO> listarRubros () {
        List<Rubro.RubroDTO> rubrosDTO = new ArrayList<>();

        for (Rubro rubro : this.repositorioRubros.buscarTodos()) {
            rubrosDTO.add(rubro.toDTO());
        }

        return rubrosDTO;
    }

    public Producto.ProductoDTO verProducto (Integer id) {
        Optional<Producto> producto = this.repositorioProductos.getPorID(id);

        if(!producto.isPresent()) {
            throw new RubroNoExisteException("El producto solicitado es inexistente");
        }

        return producto.get().toDTO();
    }

    public void  altaPrecioPorProducto (PrecioPorProveedor.PrecioPorProveedorDTO precioPorProductoDTO) {
        PrecioPorProveedor precioPorProveedor = new PrecioPorProveedor();
        //precioPorProveedor.asignarParametros(precioPorProductoDTO);

        this.repositorioPrecioPorProducto.agregar(precioPorProveedor);
    }

    public List<PrecioPorProveedor> getPreciosPorProveedor (int idRubro, int idProducto) {
            Optional<Rubro> rubro = this.repositorioRubros.getPorID(idRubro);
            if (rubro.isPresent()) {
                if (rubro.get().getProductos().contains(this.repositorioProductos.getPorID(idProducto).get())) {
                    List<PrecioPorProveedor> precioPorProveedor = this.repositorioPrecioPorProducto.buscarPorProducto(idProducto);

                    return precioPorProveedor;
                } else {
                    throw new ProductoNoPertenceAlRubroException("El Producto " + idProducto + " no pertenece a ese rubro");
                }
            } else {
                throw new RubroNoExisteException("El Rubro " + idRubro + "no existe");
            }
    }

    public List<PrecioPorProveedor.UltimoPrecioDTO> verUltimosPrecios (List<PrecioPorProveedor> precioPorProveedor) {
        List<PrecioPorProveedor.UltimoPrecioDTO> precioPorProveedorDTO = new ArrayList<>();

        for (PrecioPorProveedor ultimoPrecio : precioPorProveedor) {
            precioPorProveedorDTO.add(ultimoPrecio.toUltimoPrecioDTO());
        }

        return precioPorProveedorDTO;
    }
}
