package models.repositories;

import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.domain.enums.TipoDocumento;
import models.repositories.Datos.DatosDocumentos;

import java.time.LocalDate;
import java.util.ArrayList;
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
    }

    public List<Documento> facturasEmitdasElDia(LocalDate unDia) {
        List<Documento> facturas = new ArrayList<>();
        List<Documento> documentos= this.getElementos().stream().
                filter(e -> e.getFecha().equals(unDia)).collect(Collectors.toList());

        documentos.forEach(documento -> {
            if (documento.getTipoDocumento().equals(TipoDocumento.Factura)) {
                facturas.add(documento);
            }});

        return facturas;
    }
}
