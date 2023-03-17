package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;

@Entity
@Table(name="grades")
public class Grades {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name="lenguajes")
    public int lenguajes;

    @Column(name="entornos")
    public int entornos;

    @OneToOne(mappedBy = "grades")
    public Student student;

    public Grades(){
    }

    public Grades(int lenguajes, int entornos, Student student) {
        this.lenguajes = lenguajes;
        this.entornos = entornos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(int lenguajes) {
        this.lenguajes = lenguajes;
    }

    public int getEntornos() {
        return entornos;
    }

    public void setEntornos(int entornos) {
        this.entornos = entornos;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
