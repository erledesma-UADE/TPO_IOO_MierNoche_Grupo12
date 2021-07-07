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

        Rubro rubro1 = new Rubro();
        rubro1.setNombre("Quiosco");
        rubro1.setID(1);

        Rubro rubro2 = new Rubro();
        rubro2.setNombre("Servicios");
        rubro2.setID(2);

        rubros.add(rubro1);
        rubros.add(rubro2);

        return rubros;
    }
}
