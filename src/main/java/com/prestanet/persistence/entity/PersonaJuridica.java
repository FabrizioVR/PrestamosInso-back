package com.prestanet.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONA_JURIDICA")

public class PersonaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_p")
    private Integer idClienteP;

    @Column(name = "nombre_cliente_j")
    private String nombreClienteJ;

    @Column(name = "ruc", unique = true, length = 11)
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    // Getters y Setters
    public Integer getIdClienteP() { return idClienteP;
    }

    public void setIdClienteP(Integer idClienteP) { this.idClienteP = idClienteP;
    }

    public String getNombreClienteJ() { return nombreClienteJ;
    }
    public void setNombreClienteJ(String nombreClienteJ) { this.nombreClienteJ = nombreClienteJ;
    }

    public String getRuc() { return ruc;
    }
    public void setRuc(String ruc) { this.ruc = ruc;
    }

    public String getRazonSocial() { return razonSocial;
    }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial;
    }
}
