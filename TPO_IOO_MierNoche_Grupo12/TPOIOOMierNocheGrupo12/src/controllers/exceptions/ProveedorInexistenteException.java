package controllers.exceptions;

public class ProveedorInexistenteException extends RuntimeException {
    public ProveedorInexistenteException (String mensaje) { super(mensaje); }
}
