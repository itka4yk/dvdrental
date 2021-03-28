package org.dvdrental.sharedkernel.cqrs;

import org.dvdrental.sharedkernel.exception.KnownException;

public interface IQueryHandler<Q extends IQuery<R>, R> {
    R handle(Q query) throws KnownException;
}
