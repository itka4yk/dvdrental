package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<Film, Long> {
}
