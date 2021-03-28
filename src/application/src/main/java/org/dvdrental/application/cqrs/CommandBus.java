package org.dvdrental.application.cqrs;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.ICommandBus;
import org.dvdrental.sharedkernel.cqrs.ICommand;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class CommandBus implements ICommandBus {
    private final CommandHandlerDispatcher dispatcher;

    @Override
    public <C extends ICommand<R>, R> R execute(C command) throws Exception {
        Assert.notNull(command, "Query is null");

        var commandHandler = dispatcher.dispatch(command);
        return commandHandler.handle(command);
    }
}