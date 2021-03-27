package org.dvdrental.applicationcontract.queries;

import lombok.Getter;
import lombok.Setter;
import org.dvdrental.applicationcontract.dtos.ActorDto;
import org.dvdrental.sharedkernel.cqrs.IQuery;

import java.util.List;

@Setter
@Getter
public class GetAllActorsQuery implements IQuery<List<ActorDto>> {
    Long take = 20L;
    Long skip = 0L;
}
