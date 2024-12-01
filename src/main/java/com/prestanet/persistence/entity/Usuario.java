package com.prestanet.persistence.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    private String contrasena;

    //get y set
    public Integer getIdUsuario() {return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() { return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() { return contrasena;
    }
    public void setContrasena(String contrasena) {this.contrasena = contrasena;
    }
}
