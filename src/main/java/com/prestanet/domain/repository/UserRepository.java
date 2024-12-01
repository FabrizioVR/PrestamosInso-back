package com.prestanet.domain.repository;

import com.prestanet.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByUserNameAndPassword(String userName, String password);

    User save(User user);

    Optional<User> getByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);

    Optional<User> getById(int userId);

}
