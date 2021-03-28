package org.dvdrental.sharedkernel.exception;

public class EntityNotFoundException extends KnownException {
    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
