package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;

    @Column(name="first_name", nullable=false)
    public String firstName;

    @Column(name="last_name")
    public String lastName;

    @Column(name="email")
    public String email;

    @OneToOne(mappedBy = "student", orphanRemoval = true)
    private Grades grades;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinTable(name = "students_modulos",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "modulos_id"))
    private List<Modulos> modulos = new ArrayList<>();

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private List<Nota> notas = new ArrayList<>();


}

