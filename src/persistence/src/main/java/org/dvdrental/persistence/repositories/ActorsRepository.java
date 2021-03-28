package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Actor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends BaseRepository<Actor, Long> {
}
