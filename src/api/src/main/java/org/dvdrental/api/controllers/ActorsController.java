package org.dvdrental.api.controllers;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.dtos.ActorDto;
import org.dvdrental.applicationcontract.queries.GetAllActorsQuery;
import org.dvdrental.applicationcontract.IQueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
@RequiredArgsConstructor
public class ActorsController {
    @Autowired
    private final IQueryBus queryBus;

    @GetMapping("/getAll")
    @ResponseBody
    public List<ActorDto> getAllActors(GetAllActorsQuery query) throws Exception {
        return queryBus.execute(query);
    }
}
