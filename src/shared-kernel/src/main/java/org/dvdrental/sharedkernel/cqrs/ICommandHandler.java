package org.dvdrental.sharedkernel.cqrs;

import org.dvdrental.sharedkernel.exception.KnownException;

public interface ICommandHandler<C extends ICommand<R>, R> {
    R handle(C command) throws KnownException;
}
