package org.dvdrental.applicationcontract.commands;

import lombok.Getter;
import lombok.Setter;
import org.dvdrental.sharedkernel.cqrs.ICommand;

import java.time.LocalDateTime;

@Setter
@Getter
public class StartFilmRentalCommand implements ICommand<Void> {
    Long filmId;
    Long staffId;

    LocalDateTime rentalStartDate;
}
