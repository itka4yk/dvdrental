package org.dvdrental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Actor {
    @Id
    @Column(name="actor_id")
    Long id;

    String firstName;
    String lastName;

    LocalDateTime lastUpdate;
}
