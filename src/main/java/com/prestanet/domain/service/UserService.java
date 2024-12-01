package com.prestanet.domain.service;

import com.prestanet.domain.User;
import com.prestanet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Iniciar sesión (devuelve la ID del usuario)
    public Optional<User> iniciarSesion(String nombreUsuario, String contrasena) {
        return userRepository.getByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }

    // Registrar un nuevo usuario
    public User registrarse(String nombreUsuario, String contrasena) {
        User newUser = new User();
        newUser.setUserName(nombreUsuario);
        newUser.setPassword(contrasena);
        return userRepository.save(newUser);
    }

    // Editar datos del usuario
    public Optional<User> editar(int userId, String nombreUsuario, String contrasena) {
        Optional<User> existingUser = userRepository.getById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUserName(nombreUsuario);
            user.setPassword(contrasena);
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

}
