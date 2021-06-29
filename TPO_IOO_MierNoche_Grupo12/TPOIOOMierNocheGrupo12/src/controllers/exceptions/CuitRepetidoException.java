package controllers.exceptions;

public class CuitRepetidoException extends RuntimeException{
    public CuitRepetidoException(String mensaje) {
        super(mensaje);
    }
}
