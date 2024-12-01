package com.prestanet.domain.service;

import com.prestanet.persistence.entity.PersonaJuridica;
import com.prestanet.persistence.crud.PersonaJuridicaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalCustomerService {

    @Autowired
    private PersonaJuridicaCrudRepository personaJuridicaCrudRepository;

    public List<PersonaJuridica> getAllLegalCustomers() {
        return (List<PersonaJuridica>) personaJuridicaCrudRepository.findAll();
    }

    public Optional<PersonaJuridica> getLegalCustomerById(Integer id) {
        return personaJuridicaCrudRepository.findById(id);
    }

    public PersonaJuridica getLegalCustomerByRuc(String ruc) {
        return personaJuridicaCrudRepository.findByRuc(ruc);
    }

    public PersonaJuridica saveLegalCustomer(PersonaJuridica personaJuridica) {
        return personaJuridicaCrudRepository.save(personaJuridica);
    }

    public void deleteLegalCustomer(Integer id) {
        personaJuridicaCrudRepository.deleteById(id);
    }
}