package controllers.exceptions;

public class RubroNoExisteException extends RuntimeException{
    public RubroNoExisteException (String mensaje) {
        super(mensaje);
    }
}
