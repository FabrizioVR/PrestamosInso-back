package com.prestanet.domain.service;


import com.prestanet.persistence.entity.PersonaNatural;
import com.prestanet.persistence.crud.PersonaNaturalCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NaturalCustomerService {

    @Autowired
    private PersonaNaturalCrudRepository personaNaturalCrudRepository;

    public List<PersonaNatural> getAllNaturalCustomers() {
        return (List<PersonaNatural>) personaNaturalCrudRepository.findAll();
    }

    public Optional<PersonaNatural> getNaturalCustomerById(Integer id) {
        return personaNaturalCrudRepository.findById(id);
    }

    public PersonaNatural getNaturalCustomerByDni(String dni) {
        return personaNaturalCrudRepository.findByDni(dni);
    }

    public PersonaNatural saveNaturalCustomer(PersonaNatural personaNatural) {
        return personaNaturalCrudRepository.save(personaNatural);
    }

    public void deleteNaturalCustomer(Integer id) {
        personaNaturalCrudRepository.deleteById(id);
    }
}