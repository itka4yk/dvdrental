package org.dvdrental.application.cqrs;

import org.dvdrental.sharedkernel.cqrs.ICommand;
import org.dvdrental.sharedkernel.cqrs.ICommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Service
class CommandHandlerDispatcher {
    private final Map<Class<? extends ICommand>, Class<? extends ICommandHandler>> registry = new HashMap<>();
    private final ApplicationContext ctx;

    @Autowired
    public CommandHandlerDispatcher(ApplicationContext ctx) {
        this.ctx = ctx;
        for (String name : ctx.getBeanNamesForType(ICommandHandler.class)) {
            var handlerClass = (Class<? extends ICommandHandler>) ctx.getType(name);
            if (handlerClass == null) continue;
            var generics = GenericTypeResolver.resolveTypeArguments(handlerClass, ICommandHandler.class);

            var commandType = (Class<? extends ICommand>) generics[0];
            registry.put(commandType, handlerClass);
        }
    }

    public <R, C extends ICommand<R>, H extends ICommandHandler<C, R>> H dispatch(C command) throws Exception {
        var handlerClassName = registry.get(command.getClass());
        Assert.notNull(handlerClassName, "Can't find handler for " + command.getClass().getName());

        return (H)ctx.getBean(handlerClassName);
    }
}
