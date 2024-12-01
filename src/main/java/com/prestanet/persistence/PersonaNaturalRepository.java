package com.prestanet.persistence;

import com.prestanet.persistence.entity.PersonaNatural;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaNaturalRepository extends JpaRepository<PersonaNatural, Integer>{

    Optional<PersonaNatural> findByDni(String dni);

}
