package org.dvdrental.sharedkernel.cqrs;

public interface IQueryHandler<Q extends IQuery<R>, R> {
    R handle(Q query);
}
