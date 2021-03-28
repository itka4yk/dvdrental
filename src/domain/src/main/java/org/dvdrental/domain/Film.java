package org.dvdrental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Film {
    @Id @Column(name="film_id")
    Long id;
    String title;
    String description;
    long releaseYear;
    long languageId;
    short rentalDuration;
    long rentalRate;
    short length;
    long replacementCost;
    String rating;
}
