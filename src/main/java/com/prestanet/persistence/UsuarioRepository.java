package com.prestanet.persistence;

import com.prestanet.domain.User;
import com.prestanet.domain.repository.UserRepository;
import com.prestanet.persistence.crud.UsuarioCrudRepository;
import com.prestanet.persistence.entity.Usuario;
import com.prestanet.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository{

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public Optional<User> findByUserNameAndPassword(String userName, String password) {
        Optional<Usuario> usuario = usuarioCrudRepository.findByNombreUsuarioAndContrasena(userName, password);
        return usuario.map(mapper::toUser);
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public Optional<User> getByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena) {
        // Buscar usuario por nombre de usuario y contrasena
        Optional<Usuario> usuario = usuarioCrudRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
        return usuario.map(mapper::toUser); // Convertir de entidad a DTO
    }

    @Override
    public Optional<User> getById(int userId) {
        // Buscar usuario por ID
        Optional<Usuario> usuario = usuarioCrudRepository.findById(userId);
        return usuario.map(mapper::toUser); // Convertir de entidad a DTO
    }

}
