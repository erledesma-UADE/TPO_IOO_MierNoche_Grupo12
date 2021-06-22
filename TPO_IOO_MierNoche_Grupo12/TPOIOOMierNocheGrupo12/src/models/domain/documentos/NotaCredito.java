package models.domain.documentos;


import models.domain.Proveedor;
import models.domain.enums.TipoDocumento;

import java.time.LocalDateTime;

public class NotaCredito extends Documento {
    private String descripcion;
    private String emisor;

    public NotaCredito(TipoDocumento tipoDocumento, Proveedor proveedor, LocalDateTime fecha) {
        super(tipoDocumento, proveedor, fecha);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

}
