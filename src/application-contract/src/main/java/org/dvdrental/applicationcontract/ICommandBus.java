package org.dvdrental.applicationcontract;

import org.dvdrental.sharedkernel.cqrs.ICommand;

public interface ICommandBus {
    <C extends ICommand<R>, R> R execute(C command) throws Exception;
}
