package controllers;

import models.domain.PrecioPorProveedor;
import models.domain.Producto;
import models.domain.Rubro;
import controllers.exceptions.ProductoNoPertenceAlRubroException;
import controllers.exceptions.RubroNoExisteException;
import models.repositories.RepositorioPrecioPorProveedor;
import models.repositories.RepositorioProductos;
import models.repositories.RepositorioProveedores;
import models.repositories.RepositorioRubros;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RubrosController {
    private static RubrosController instancia;
    private RepositorioRubros repositorioRubros;
    private RepositorioProductos repositorioProductos;
    private RepositorioPrecioPorProveedor repositorioPrecioPorProveedor;
    private RepositorioProveedores repositorioProveedores;

    public static RubrosController getInstancia () {
        if(RubrosController.instancia == null)
            instancia = new RubrosController();
        return instancia;
    }

    private RubrosController () {
        this.repositorioRubros = RepositorioRubros.getInstancia();
        this.repositorioProductos = RepositorioProductos.getInstancia();
        this.repositorioPrecioPorProveedor = RepositorioPrecioPorProveedor.getInstancia();
        this.repositorioProveedores = RepositorioProveedores.getInstancia();
    }

    //=================================================================================================================
    //INICIO GETTERS / SETTERS
    //=================================================================================================================

    //=================================================================================================================
    //FIN GETTERS / SETTERS
    //=================================================================================================================

    //=================================================================================================================
    //INICIO RUBRO
    //=================================================================================================================

    public void altaRubro (Rubro.RubroDTO rubroDTO) {
        Rubro rubro = new Rubro();
        asignarParametrosRubro(rubro, rubroDTO);
        this.repositorioRubros.agregar(rubro);
    }

    public void asignarParametrosRubro (Rubro rubro, Rubro.RubroDTO rubroDTO) {
        rubro.setNombre(rubroDTO.nombre);
        rubroDTO.idsProductos.forEach(idProducto -> {
            if (this.repositorioProductos.getPorID(idProducto).isPresent()) {
                rubro.agregarProducto(this.repositorioProductos.getPorID(idProducto).get());
            }
        });

        rubroDTO.idsProveedores.forEach(idProveedor -> {
            if (this.repositorioProveedores.getPorID(idProveedor).isPresent()) {
                rubro.agregarProveedores(this.repositorioProveedores.getPorID(idProveedor).get());
            }
        });
    }

    public void agregarProducto(Integer id) {
        this.repositorioRubros.getPorID(id).get().getProductos().add(this.repositorioProductos.getPorID(id).get());
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
    //=================================================================================================================
    //FIN RUBRO
    //=================================================================================================================

    //=================================================================================================================
    //INICIO PRODUCTO
    //=================================================================================================================

    public void asignarParametrosProducto (Producto producto, Producto.ProductoDTO productoDTO) {
        producto.setNombre(productoDTO.nombre);
        producto.setTipoUnidad(productoDTO.tipoUnidad);
        producto.setImpuesto(productoDTO.impuesto);
        //agregarPrecioPorProveedor(productoDTO.precioPorProveedor);
    }

    public void altaProducto (Producto.ProductoDTO productoDTO) {
        Producto producto = new Producto();
        asignarParametrosProducto(producto, productoDTO);

        this.repositorioProductos.agregar(producto);
    }

    public Producto.ProductoDTO verProducto (Integer id) {
        Optional<Producto> producto = this.repositorioProductos.getPorID(id);

        if(!producto.isPresent()) {
            throw new RubroNoExisteException("El producto solicitado es inexistente");
        }

        return producto.get().toDTO();
    }
    //=================================================================================================================
    //FIN PRODUCTO
    //=================================================================================================================

    //=================================================================================================================
    //INICIO PRECIO POR PROVEEDOR
    //=================================================================================================================

    public void asignarParametrosPrecioPorProveedor (PrecioPorProveedor precioPorProveedor,
                                                     PrecioPorProveedor.PrecioPorProveedorDTO precioPorProductoDTO) {
    }

    public void  altaPrecioPorProveedor (PrecioPorProveedor.PrecioPorProveedorDTO precioPorProductoDTO) {
        PrecioPorProveedor precioPorProveedor = new PrecioPorProveedor();
        //precioPorProveedor.asignarParametros(precioPorProductoDTO);

        this.repositorioPrecioPorProveedor.agregar(precioPorProveedor);
    }
    //=================================================================================================================
    //FIN PRECIO POR PROVEEDOR
    //=================================================================================================================

    //=================================================================================================================
    //INICIO CONSULTAS GENERALES
    //=================================================================================================================
    //Copmulsa De Precios
    //=================================================================================================================

    public List<PrecioPorProveedor> getPreciosPorProveedor (int idRubro, int idProducto) {
            Optional<Rubro> rubro = this.repositorioRubros.getPorID(idRubro);
            if (rubro.isPresent()) {
                if (rubro.get().getProductos().contains(this.repositorioProductos.getPorID(idProducto).get())) {
                    List<PrecioPorProveedor> precioPorProveedor = this.repositorioPrecioPorProveedor.buscarPorProducto(idProducto);

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
    //=================================================================================================================
    //FIN CONSULTAS GENERALES
    //=================================================================================================================
}
