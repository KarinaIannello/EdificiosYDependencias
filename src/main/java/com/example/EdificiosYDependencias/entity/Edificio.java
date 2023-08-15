package com.example.EdificiosYDependencias.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Edificio {
    @Id
    @SequenceGenerator(
            name = "edificio_id_sequence",
            sequenceName = "edificio_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "edificio_id_sequence"
    )

    private Long id;
    private String nombre;
    private String domicilio;

    @OneToMany(mappedBy = "edificio", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Dependencia> dependencias;

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

    public List<Dependencia> getDependencias() {
        return dependencias;
    }

    public void setDependencias(List<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }

    public Edificio() {
    }

    public Edificio(Long id, String nombre, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public Edificio(Long id) {
        this.id = id;
    }

}
