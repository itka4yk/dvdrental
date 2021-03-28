package org.dvdrental.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.dvdrental.sharedkernel.exception.DomainException;
import org.dvdrental.sharedkernel.validation.Check;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Rental {
    @Id
    @Column(name="rental_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime rentalDate;
    Long inventoryId;
    Long customerId;
    LocalDateTime returnDate;
    Long staffId;

    @SneakyThrows
    public void start(Long customerId, LocalDateTime rentalDate, Long inventoryId, Long staffId) {
        Check.notNull(customerId, "Customer Id should not be empty");
        Check.notNull(inventoryId, "Inventory Id should not be empty");
        Check.notNull(staffId, "Staff Id should not be empty");
        Check.notNull(rentalDate, "RentalDate should not be empty");
        this.customerId = customerId;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.staffId = staffId;
    }

    @SneakyThrows
    public void finish(LocalDateTime returnDate) {
        if(returnDate.isBefore(this.rentalDate)) throw new DomainException("Return date should be after rental date");
        this.returnDate = returnDate;
    }
}
