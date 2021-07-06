package models.repositories;

import models.domain.documentos.Documento;
import models.repositories.Datos.DatosDocumentos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDocumentos extends Repositorio<Documento>{

    private static RepositorioDocumentos instancia;

    public static RepositorioDocumentos getInstancia(){
        if(RepositorioDocumentos.instancia == null)
            instancia = new RepositorioDocumentos();
        return instancia;
    }

    private RepositorioDocumentos(){
        super();
        super.elementos = DatosDocumentos.getDocumentos();
        System.out.println("Repo Documentos " + super.elementos);
    }

    public List<Documento> facturasEmitdasElDia(LocalDate unDia) {
        return this.getElementos().stream().
                filter(e -> e.getFecha().equals(unDia)).collect(Collectors.toList());

    }

    public List<Documento> buscarPorCuitProveedor(Integer cuit) {
        return this.getElementos()
                .stream()
                .filter(e -> e.getProveedor().get().getCuit().equals(cuit))
                .collect(Collectors.toList());
    }
}
