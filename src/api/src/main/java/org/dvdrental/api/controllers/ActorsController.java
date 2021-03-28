package org.dvdrental.api.controllers;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.ICommandBus;
import org.dvdrental.applicationcontract.IQueryBus;
import org.dvdrental.applicationcontract.dtos.ActorDto;
import org.dvdrental.applicationcontract.queries.GetAllActorsQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorsController {
    private final IQueryBus queryBus;
    private final ICommandBus commandBus;

    @GetMapping("/getAll")
    @ResponseBody
    public List<ActorDto> getAllActors(GetAllActorsQuery query) throws Exception {
        return queryBus.execute(query);
    }
}
