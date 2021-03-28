package org.dvdrental.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Staff {
    @Id
    @Column(name="staff_id")
    Long id;
    String firstName;
    String lastName;
    Long addressId;
    String email;
    Long storeId;
    Boolean active;
    String username;
    String password;
    Byte[] picture;
}
