package be.vdab.school.exceptions;

public class RepositoryException extends RuntimeException{
    public RepositoryException(Exception cause) {
        super(cause);
    }

}
