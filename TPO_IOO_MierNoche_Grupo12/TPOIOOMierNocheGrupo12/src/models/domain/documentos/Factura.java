package models.domain.documentos;

import models.domain.CantidadPorProducto;
import models.domain.Impuesto;
import models.domain.OrdenCompra;
import models.domain.Proveedor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Factura extends Documento {
    private OrdenCompra ordenDeCompra;
    private List<Impuesto> impuestos;

    public Factura() {
        this.impuestos = new ArrayList<>();
    }

    public OrdenCompra getOrdenDeCompra() {
        return ordenDeCompra;
    }

    public void setOrdenDeCompra(OrdenCompra ordenDeCompra) {
        this.ordenDeCompra = ordenDeCompra;
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(List<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public FacturaDTO facturaDTO () {
        FacturaDTO dto = new FacturaDTO();

        dto.idFactura = super.getIdDocumento();
        dto.ordenCompraDTO = this.ordenDeCompra.toDTO();
        this.impuestos.forEach(impuesto -> {
            dto.impuestosDTO.add(impuesto.toDTO());
        });

        return dto;
    }

    public static class FacturaDTO {
        public int idFactura;
        public OrdenCompra.OrdenCompraDTO ordenCompraDTO;
        public List<Impuesto.ImpuestoDTO> impuestosDTO;
    }
}
