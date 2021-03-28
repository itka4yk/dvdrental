package org.dvdrental.application.cqrs;

import lombok.RequiredArgsConstructor;
import org.dvdrental.sharedkernel.cqrs.IQuery;
import org.dvdrental.sharedkernel.cqrs.IQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Service
class QueryHandlerDispatcher {
    private final Map<Class<? extends IQuery>, Class<? extends IQueryHandler>> registry = new HashMap<>();
    private final ApplicationContext ctx;

    @Autowired
    public QueryHandlerDispatcher(ApplicationContext ctx) {
        this.ctx = ctx;
        for (String name : ctx.getBeanNamesForType(IQueryHandler.class)) {
            var handlerClass = (Class<? extends IQueryHandler>) ctx.getType(name);
            if (handlerClass == null) continue;
            var generics = GenericTypeResolver.resolveTypeArguments(handlerClass, IQueryHandler.class);

            var queryType = (Class<? extends IQuery>) generics[0];
            registry.put(queryType, handlerClass);
        }
    }

    public <R, Q extends IQuery<R>, H extends IQueryHandler<Q, R>> H dispatch(Q query) throws Exception {
        var handlerClassName = registry.get(query.getClass());
        Assert.notNull(handlerClassName, "Can't find handler for " + query.getClass().getName());

        return (H)ctx.getBean(handlerClassName);
    }
}
