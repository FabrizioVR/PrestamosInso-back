package com.prestanet.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONA_NATURAL")
public class PersonaNatural {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_n")
    private Integer idClienteN;

    @Column(name = "nombre_cliente_n")
    private String nombreClienteN;

    @Column(name = "dni", unique = true, length = 8)
    private String dni;

    // Getters y Setters
    public Integer getIdClienteN() { return idClienteN;
    }
    public void setIdClienteN(Integer idClienteN) { this.idClienteN = idClienteN;
    }

    public String getNombreClienteN() { return nombreClienteN;
    }
    public void setNombreClienteN(String nombreClienteN) { this.nombreClienteN = nombreClienteN;
    }

    public String getDni() { return dni;
    }
    public void setDni(String dni) { this.dni = dni;
    }

}
