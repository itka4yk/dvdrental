package org.dvdrental.api.controllers;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.ICommandBus;
import org.dvdrental.applicationcontract.IQueryBus;
import org.dvdrental.applicationcontract.commands.StartFilmRentalCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental")
@RequiredArgsConstructor
public class RentalController {
    private final IQueryBus queryBus;
    private final ICommandBus commandBus;

    @PostMapping("/start")
    @ResponseBody
    public void startRental(@RequestBody StartFilmRentalCommand command) throws Exception {
        this.commandBus.execute(command);
    }

}
