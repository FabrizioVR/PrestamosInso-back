package com.prestanet.domain;

import com.prestanet.persistence.entity.Usuario;

public class NaturalCustomer {

    private int idClienteN;
    private String nombreClienteN;
    private String dni;

    public int getIdClienteN() { return idClienteN;
    }
    public void setIdClienteN(int idClienteN) { this.idClienteN = idClienteN;
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
