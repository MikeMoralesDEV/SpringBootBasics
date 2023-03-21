package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="modulos")
public class Modulos {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;
    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String nombre;

    @ManyToMany
    @JoinTable(name = "modulos_students",
            joinColumns = @JoinColumn(name = "modulos_id"),
            inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "modulos_horas",
            joinColumns = @JoinColumn(name = "modulos_id"),
            inverseJoinColumns = @JoinColumn(name = "horas_id"))
    private List<Hora> horas = new ArrayList<>();


    @OneToMany(mappedBy = "modulos",  orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

}
