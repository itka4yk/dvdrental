package org.dvdrental.application.cqrs;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.IQueryBus;
import org.dvdrental.sharedkernel.cqrs.IQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class QueryBus implements IQueryBus {
    private final QueryHandlerDispatcher dispatcher;

    @Override
    public <Q extends IQuery<R>, R> R execute(Q query) throws Exception {
        Assert.notNull(query, "Query is null");

        var queryHandler = dispatcher.dispatch(query);
        return queryHandler.handle(query);
    }
}