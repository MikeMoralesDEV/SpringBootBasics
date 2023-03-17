package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;

@Entity
@Table(name="notas")
public class Nota {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "modulos_id")
    private Modulos modulos;

    public Modulos getModulos() {
        return modulos;
    }

    public void setModulos(Modulos modulos) {
        this.modulos = modulos;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
