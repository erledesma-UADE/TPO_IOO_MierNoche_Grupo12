package controllers;

import models.domain.CuentaCorriente;
import models.domain.repositories.RepositorioCuentaCorriente;

import java.util.List;
import java.util.stream.Collectors;

public class CuentaCorrienteController {
    private static CuentaCorrienteController instancia;
    private RepositorioCuentaCorriente repositorio;

    public static CuentaCorrienteController getInstancia(){
        if(CuentaCorrienteController.instancia == null)
            instancia = new CuentaCorrienteController();
        return instancia;
    }

    private CuentaCorrienteController(){this.repositorio = new RepositorioCuentaCorriente();}

    public List<CuentaCorriente.CuentaCorrienteDTO> ListarTodos(){
        return this.repositorio
                .buscarTodos()
                .stream()
                .map(CuentaCorriente::toDTO)
                .collect(Collectors.toList());


    }

    public CuentaCorriente.CuentaCorrienteDTO ver(Integer id){

    }


}
