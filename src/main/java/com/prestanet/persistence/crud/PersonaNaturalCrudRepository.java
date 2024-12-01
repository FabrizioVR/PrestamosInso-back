package com.prestanet.persistence.crud;

import com.prestanet.persistence.entity.PersonaNatural;
import com.prestanet.persistence.entity.PersonaNatural;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaNaturalCrudRepository extends CrudRepository<PersonaNatural, Integer> {

    Optional<PersonaNatural> findByNombreAndDni(String nombreClienteN, String dni);

    Optional<PersonaNatural> findById(int id);

}
