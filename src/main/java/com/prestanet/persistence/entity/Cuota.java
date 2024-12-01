package com.prestanet.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CUOTA")
public class Cuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private Integer idCuota;

    @ManyToOne
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Prestamo prestamo;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "monto_capital", nullable = false)
    private Double montoCapital;

    @Column(name = "monto_interes", nullable = false)
    private Double montoInteres;

    @Column(nullable = false)
    private Boolean pagada;

    // Getters y Setters
    public Integer getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(Integer idCuota) {
        this.idCuota = idCuota;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMontoCapital() {
        return montoCapital;
    }

    public void setMontoCapital(Double montoCapital) {
        this.montoCapital = montoCapital;
    }

    public Double getMontoInteres() {
        return montoInteres;
    }

    public void setMontoInteres(Double montoInteres) {
        this.montoInteres = montoInteres;
    }

    public Boolean getPagada() {
        return pagada;
    }

    public void setPagada(Boolean pagada) {
        this.pagada = pagada;
    }
}
