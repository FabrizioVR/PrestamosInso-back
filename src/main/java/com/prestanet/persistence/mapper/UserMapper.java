package com.prestanet.persistence.mapper;

import com.prestanet.domain.User;
import com.prestanet.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombreUsuario", target = "userName"),
            @Mapping(source = "contrasena", target = "password"),
    })

    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);

}
