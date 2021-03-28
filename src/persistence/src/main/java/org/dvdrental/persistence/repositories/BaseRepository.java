package org.dvdrental.persistence.repositories;

import lombok.SneakyThrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface BaseRepository<C, K> extends JpaRepository<C, K> {
    @SneakyThrows
    default C create (Class<C> cls) {
        return cls.getDeclaredConstructor().newInstance();
    }
}
