package models.repositories.Datos;

import models.domain.CantidadPorProducto;
import models.domain.Proveedor;
import models.domain.Rubro;
import models.domain.enums.TipoDocumento;
import models.repositories.RepositorioProveedores;
import models.repositories.RepositorioRubros;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DatosRubros {
    public static List<Rubro> getRubros () {
        List<Rubro> rubros = new ArrayList<>();
        //RepositorioProveedores repositorioProveedores = RepositorioProveedores.getInstancia();


        Rubro rubro1 = new Rubro();
        rubro1.setNombre("Cosas");
        rubro1.setID(1);
        //Optional<Proveedor> proveedor1 = repositorioProveedores.buscarPorCuit(1234);
        //rubro1.setProveedores(proveedor1);
        //rubro1.agregarProducto(proveedor1.get().getCatalogo().get(1).getProducto());
        //rubro1.agregarProducto(proveedor1.get().getCatalogo().get(2).getProducto());
        Rubro rubro2 = new Rubro();
        rubro2.setNombre("Cosas2");
        rubro2.setID(2);

        rubros.add(rubro1);
        rubros.add(rubro2);

        return rubros;
    }
}
