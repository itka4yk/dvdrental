package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends JpaRepository<Actor, Long> {
}
