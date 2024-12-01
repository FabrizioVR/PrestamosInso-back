package com.prestanet.webController;

import com.prestanet.persistence.entity.PersonaJuridica;
import com.prestanet.domain.service.LegalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/legal-customers")
public class LegalCustomerController {

    @Autowired
    private LegalCustomerService LegalCustomerService;

    // Obtener todas las personas jurídicas
    @GetMapping
    public List<PersonaJuridica> getAllLegalCustomers() {
        return LegalCustomerService.getAllLegalCustomers();
    }

    // Obtener una persona jurídica por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonaJuridica> getLegalCustomerById(@PathVariable Integer id) {
        Optional<PersonaJuridica> personaJuridica = LegalCustomerService.getLegalCustomerById(id);
        return personaJuridica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener una persona jurídica por RUC
    @GetMapping("/ruc/{ruc}")
    public ResponseEntity<PersonaJuridica> getLegalCustomerByRuc(@PathVariable String ruc) {
        PersonaJuridica personaJuridica = LegalCustomerService.getLegalCustomerByRuc(ruc);
        if (personaJuridica != null) {
            return ResponseEntity.ok(personaJuridica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva persona jurídica
    @PostMapping
    public PersonaJuridica createLegalCustomer(@RequestBody PersonaJuridica personaJuridica) {
        return LegalCustomerService.saveLegalCustomer(personaJuridica);
    }

    // Actualizar una persona jurídica existente
    @PutMapping("/{id}")
    public ResponseEntity<PersonaJuridica> updateLegalCustomer(@PathVariable Integer id, @RequestBody PersonaJuridica personaJuridicaDetails) {
        Optional<PersonaJuridica> personaJuridica = LegalCustomerService.getLegalCustomerById(id);

        if (personaJuridica.isPresent()) {
            PersonaJuridica updatedPersonaJuridica = personaJuridica.get();
            updatedPersonaJuridica.setNombreClienteJ(personaJuridicaDetails.getNombreClienteJ());
            updatedPersonaJuridica.setRuc(personaJuridicaDetails.getRuc());
            updatedPersonaJuridica.setRazonSocial(personaJuridicaDetails.getRazonSocial());
            return ResponseEntity.ok(LegalCustomerService.saveLegalCustomer(updatedPersonaJuridica));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una persona jurídica por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegalCustomer(@PathVariable Integer id) {
        if (LegalCustomerService.getLegalCustomerById(id).isPresent()) {
            LegalCustomerService.deleteLegalCustomer(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
