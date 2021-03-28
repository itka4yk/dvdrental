package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Rental;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends BaseRepository<Rental, Long> {
}
