package org.dvdrental.application.commandHandlers;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.dvdrental.applicationcontract.commands.StartFilmRentalCommand;
import org.dvdrental.domain.Rental;
import org.dvdrental.persistence.repositories.FilmsRepository;
import org.dvdrental.persistence.repositories.RentalRepository;
import org.dvdrental.persistence.repositories.StaffRepository;
import org.dvdrental.sharedkernel.cqrs.ICommandHandler;
import org.dvdrental.sharedkernel.exception.EntityNotFoundException;
import org.dvdrental.sharedkernel.validation.Check;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Transactional
@Service
@RequiredArgsConstructor
public class StartFilmRentalCommandHandler implements ICommandHandler<StartFilmRentalCommand, Void> {
    private final FilmsRepository filmsRepository;
    private final StaffRepository staffRepository;
    private final RentalRepository rentalRepository;

    @SneakyThrows
    @Override
    public Void handle(StartFilmRentalCommand command) {
        Check.notNull(command.getFilmId(), "FilmId must be provided");
        Check.notNull(command.getStaffId(), "StaffId must be provided");

        // TODO: Get user from context
        // TODO: add user auth
        // TODO: Get store from user

        var film = filmsRepository.findById(command.getFilmId());
        if(film.isEmpty()) throw new EntityNotFoundException("Can't find film with id " + command.getFilmId());

        var staff = staffRepository.findById(command.getStaffId());
        if(staff.isEmpty()) throw new EntityNotFoundException("Can't find staff with id " + command.getFilmId());

        // TODO: check if staff is active

        // TODO: check inventory
        var rental = rentalRepository.create(Rental.class);
        rental.start(
                (long)1, // FIXME: this must be customer's id
                LocalDateTime.now(),
                (long)1, // FIXME: this must be inventory id
                staff.get().getId()
        );

        this.rentalRepository.save(rental);
        return null;
    }
}
