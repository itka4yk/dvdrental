package org.dvdrental.application.commandHandlers;

import lombok.RequiredArgsConstructor;
import org.dvdrental.applicationcontract.commands.StartFilmRentalCommand;
import org.dvdrental.domain.Rental;
import org.dvdrental.persistence.repositories.FilmsRepository;
import org.dvdrental.persistence.repositories.RentalRepository;
import org.dvdrental.persistence.repositories.StaffRepository;
import org.dvdrental.sharedkernel.cqrs.ICommandHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Transactional
@Service
@RequiredArgsConstructor
public class StartFilmRentalCommandHandler implements ICommandHandler<StartFilmRentalCommand, Void> {
    private final FilmsRepository filmsRepository;
    private final StaffRepository staffRepository;
    private final RentalRepository rentalRepository;

    @Override
    public Void handle(StartFilmRentalCommand command) {
        // TODO: add custom validator service
        Assert.notNull(command.getFilmId(), "FilmId must be provided");
        Assert.notNull(command.getStaffId(), "StaffId must be provided");

        // TODO: Get user from context
        // TODO: add user auth
        // TODO: Get store from user

        var film = filmsRepository.findById(command.getFilmId());
        Assert.isTrue(film.isPresent(), "Can't find film with id " + command.getFilmId());

        var staff = staffRepository.findById(command.getStaffId());
        Assert.isTrue(staff.isPresent(), "Can't find staff with id " + command.getStaffId());
        Assert.isTrue(staff.get().getActive(), "Staff must be active");

        // TODO: check inventory

        var rental = new Rental(
                (long)1, // FIXME: this must be customer's id
                LocalDateTime.now(),
                (long)1, // FIXME: this must be inventory id
                staff.get().getId()
        );

        this.rentalRepository.save(rental);
        // FIXME
        return null;
    }
}
