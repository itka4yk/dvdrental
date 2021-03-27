package org.dvdrental.application.queryHandlers;

import lombok.RequiredArgsConstructor;
import org.dvdrental.sharedkernel.cqrs.IQueryHandler;
import org.dvdrental.applicationcontract.dtos.ActorDto;
import org.dvdrental.applicationcontract.queries.GetAllActorsQuery;
import org.dvdrental.persistence.repositories.ActorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllActorsQueryHandler implements IQueryHandler<GetAllActorsQuery, List<ActorDto>> {
    private final ActorsRepository repository;

    @Override
    public List<ActorDto> handle(GetAllActorsQuery query) {
        return this.repository
                .findAll()
                .stream()
                .skip(query.getSkip())
                .limit(query.getTake())
                .map(a -> new ActorDto(a.getId(), a.getFirstName(), a.getLastName()))
                .collect(Collectors.toList());
    }
}
