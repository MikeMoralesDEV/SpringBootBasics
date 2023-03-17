package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String nombre;

    @Column(name = "email")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String email;

    @OneToMany(mappedBy = "profesor", orphanRemoval = true)
    private List<Modulos> modulos = new ArrayList<>();

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
