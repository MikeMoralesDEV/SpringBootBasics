package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    @Column(name="first_name", nullable=false)
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    @Column(name="email")
    public String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grades_id")
    public Grades grades;

    @ManyToMany(mappedBy = "students")
    private List<Modulos> modulos = new ArrayList<>();

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }

    public Student() {
    }

    public Student(String first_name, String last_name, String email) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }
}

