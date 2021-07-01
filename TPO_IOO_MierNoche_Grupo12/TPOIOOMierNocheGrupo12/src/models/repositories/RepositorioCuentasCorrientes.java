package models.repositories;

import models.domain.CuentaCorriente;
import models.domain.Proveedor;

import java.util.Optional;

public class RepositorioCuentasCorrientes extends Repositorio<CuentaCorriente> {
    public Optional<CuentaCorriente> buscarPorCuitProveedor (int cuit) {
        return this.getElementos().stream().filter(cC ->
                cC.getProveedor().getCuit().equals(cuit)).findFirst();
    }
}
