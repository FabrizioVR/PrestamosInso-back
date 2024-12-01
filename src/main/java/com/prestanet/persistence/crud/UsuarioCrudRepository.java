package com.prestanet.persistence.crud;

import com.prestanet.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer>{

    Optional<Usuario> findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);

    Optional<Usuario> findById(int id);
}
