package models.repositories;

import models.domain.CuentaCorriente;
import models.domain.Proveedor;
import models.repositories.Datos.DatosDocumentos;

import java.util.Optional;

public class RepositorioCuentasCorrientes extends Repositorio<CuentaCorriente> {

    private static RepositorioCuentasCorrientes instancia;

    public static RepositorioCuentasCorrientes getInstancia(){
        if(RepositorioCuentasCorrientes.instancia == null)
            instancia = new RepositorioCuentasCorrientes();
        return instancia;
    }

    private RepositorioCuentasCorrientes(){
        super();
        //super.elementos = DatosDocumentos.getDocumentos();
    }

    public Optional<CuentaCorriente> buscarPorCuitProveedor (int cuit) {
        return this.getElementos().stream().filter(cC ->
                cC.getProveedor().getCuit().equals(cuit)).findFirst();
    }
}
