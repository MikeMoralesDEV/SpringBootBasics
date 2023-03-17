package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "modulos", orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }


    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
