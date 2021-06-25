package controllers.exceptions;

public class cuitRepetidoException extends RuntimeException{
    public cuitRepetidoException (String mensaje) {
        super(mensaje);
    }
}
