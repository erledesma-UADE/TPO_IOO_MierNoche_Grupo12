package models.repositories;

import models.domain.Proveedor;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RepositorioDocumentos extends Repositorio<Documento>{

    public List<Factura> facturasEmitdasElDia(LocalDate unDia) {
        return (List<Factura>) this.getElementos()
                .stream()
                .filter(e -> e.getFecha().equals(unDia));
    }




}
