package models.domain.exceptions;

public class ProductoNoPertenceAlRubroException extends RuntimeException {
    public ProductoNoPertenceAlRubroException (String mensaje) {
        super(mensaje);
    }
}
