package org.dvdrental.applicationcontract;

import org.dvdrental.sharedkernel.cqrs.IQuery;

public interface IQueryBus {
    <Q extends IQuery<R>, R> R execute(Q query) throws Exception;
}
