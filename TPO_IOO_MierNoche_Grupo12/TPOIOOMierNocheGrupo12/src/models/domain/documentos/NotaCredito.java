package models.domain.documentos;


import models.domain.CantidadPorProducto;
import models.domain.Proveedor;

import java.time.LocalDateTime;
import java.util.List;

public class NotaCredito extends Documento {
    private String descripcion;
    private String emisor;

    public NotaCredito(String tipoDocumento, Proveedor proveedor, LocalDateTime fecha, List<CantidadPorProducto> articulos) {
        super(tipoDocumento, proveedor, fecha, articulos);
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
