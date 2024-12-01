package com.prestanet.webController;

import com.prestanet.persistence.entity.PersonaNatural;
import com.prestanet.domain.service.NaturalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/natural-customers")
public class NaturalCustomerController {

    @Autowired
    private NaturalCustomerService naturalCustomerService;

    @GetMapping
    public List<PersonaNatural> getAllNaturalCustomers() {
        return naturalCustomerService.getAllNaturalCustomers();
    }

    // Obtener una persona natural por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonaNatural> getNaturalCustomerById(@PathVariable Integer id) {
        Optional<PersonaNatural> personaNatural = naturalCustomerService.getNaturalCustomerById(id);
        return personaNatural.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener una persona natural por DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<PersonaNatural> getNaturalCustomerByDni(@PathVariable String dni) {
        PersonaNatural personaNatural = naturalCustomerService.getNaturalCustomerByDni(dni);
        if (personaNatural != null) {
            return ResponseEntity.ok(personaNatural);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva persona natural
    @PostMapping
    public PersonaNatural createNaturalCustomer(@RequestBody PersonaNatural personaNatural) {
        return naturalCustomerService.saveNaturalCustomer(personaNatural);
    }

    // Actualizar una persona natural existente
    @PutMapping("/{id}")
    public ResponseEntity<PersonaNatural> updateNaturalCustomer(@PathVariable Integer id, @RequestBody PersonaNatural personaNaturalDetails) {
        Optional<PersonaNatural> personaNatural = naturalCustomerService.getNaturalCustomerById(id);

        if (personaNatural.isPresent()) {
            PersonaNatural updatedPersonaNatural = personaNatural.get();
            updatedPersonaNatural.setNombreClienteN(personaNaturalDetails.getNombreClienteN());
            updatedPersonaNatural.setDni(personaNaturalDetails.getDni());
            return ResponseEntity.ok(naturalCustomerService.saveNaturalCustomer(updatedPersonaNatural));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una persona natural por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNaturalCustomer(@PathVariable Integer id) {
        if (naturalCustomerService.getNaturalCustomerById(id).isPresent()) {
            naturalCustomerService.deleteNaturalCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
