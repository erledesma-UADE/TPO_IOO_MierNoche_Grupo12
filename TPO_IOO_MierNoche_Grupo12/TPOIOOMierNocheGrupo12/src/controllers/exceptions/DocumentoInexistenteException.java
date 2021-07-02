package controllers.exceptions;

public class DocumentoInexistenteException extends RuntimeException {
    public DocumentoInexistenteException (String mensaje) { super(mensaje); }
}
