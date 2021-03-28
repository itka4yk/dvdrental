package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Film;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends BaseRepository<Film, Long> {
}
