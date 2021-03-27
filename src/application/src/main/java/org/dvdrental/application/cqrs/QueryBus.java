package org.dvdrental.application.cqrs;

import org.dvdrental.sharedkernel.cqrs.IQuery;
import org.dvdrental.applicationcontract.IQueryBus;
import org.dvdrental.sharedkernel.cqrs.IQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryBus implements IQueryBus {
    private final Map<Class<? extends IQuery>, Class<? extends IQueryHandler>> providerMap = new HashMap<>();
    private final ApplicationContext applicationContext;

    @Autowired
    public QueryBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        for (String name : this.applicationContext.getBeanNamesForType(IQueryHandler.class)) {
            var handlerClass = (Class<? extends IQueryHandler>) this.applicationContext.getType(name);
            if (handlerClass == null) continue;
            var queryHandler = (IQueryHandler<?, ?>) this.applicationContext.getBean(handlerClass);
            var generics = GenericTypeResolver.resolveTypeArguments(handlerClass, IQueryHandler.class);

            var queryType = (Class<? extends IQuery>) generics[0];
            providerMap.put(queryType, handlerClass);
        }
    }

    @Override
    public <Q extends IQuery<R>, R> R execute(Q query) throws Exception {
        if (query == null) throw new Exception("Query is null");

        var queryHandlerClass = providerMap.get(query.getClass());
        if (queryHandlerClass == null) throw new Exception("Cant find query handler for query " + query.getClass().getName());

        var queryHandler = (IQueryHandler<Q, R>) applicationContext.getBean(queryHandlerClass);
        return queryHandler.handle(query);
    }
}