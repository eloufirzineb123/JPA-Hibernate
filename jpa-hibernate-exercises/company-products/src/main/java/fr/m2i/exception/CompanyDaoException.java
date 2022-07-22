package fr.m2i.exception;

public class CompanyDaoException extends RuntimeException{
    public CompanyDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
