package org.dvdrental.applicationcontract.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActorDto {
    Long id;
    String firstName;
    String lastName;
}
