package com.example.EdificiosYDependencias.entity;

import jakarta.persistence.*;

@Entity
public class Dependencia {
    @Id
    @SequenceGenerator(
            name = "dependencia_id_sequence",
            sequenceName = "dependencia_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dependencia_id_sequence"
    )

    private Long id;
    private String nombre;
    private String domicilio;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Dependencia() {
    }

    public Dependencia(Long id, String nombre, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

}
