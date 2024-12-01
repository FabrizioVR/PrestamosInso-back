package com.prestanet.persistence.crud;

import com.prestanet.persistence.entity.PersonaJuridica;
import org.springframework.data.repository.CrudRepository;


public interface PersonaJuridicaCrudRepository extends CrudRepository<PersonaJuridica, Integer> {
    PersonaJuridica findByRuc(String ruc);

    PersonaJuridica findByNombre(String nombreClienteP);
}
