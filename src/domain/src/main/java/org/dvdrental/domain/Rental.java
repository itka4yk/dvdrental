package org.dvdrental.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

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

    public void start(Long customerId, LocalDateTime rentalDate, Long inventoryId, Long staffId) {
        Assert.notNull(customerId, "Customer Id should not be empty");
        Assert.notNull(inventoryId, "Inventory Id should not be empty");
        Assert.notNull(staffId, "Staff Id should not be empty");
        Assert.notNull(rentalDate, "RentalDate should not be empty");
        this.customerId = customerId;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.staffId = staffId;
    }

    public void finish(LocalDateTime returnDate) {
        Assert.isTrue(returnDate.isAfter(this.rentalDate), "Return date should be after rental date");
        this.returnDate = returnDate;
    }
}
