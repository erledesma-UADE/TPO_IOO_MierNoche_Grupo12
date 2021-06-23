package models.domain.exceptions;

public class RubroNoExisteException extends RuntimeException{
    public RubroNoExisteException (String mensaje) {
        super(mensaje);
    }
}
