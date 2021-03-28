package org.dvdrental.sharedkernel.cqrs;

public interface ICommandHandler<C extends ICommand<R>, R> {
    R handle(C command);
}
