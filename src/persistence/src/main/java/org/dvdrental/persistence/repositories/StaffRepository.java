package org.dvdrental.persistence.repositories;

import org.dvdrental.domain.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends BaseRepository<Staff, Long> {
}
