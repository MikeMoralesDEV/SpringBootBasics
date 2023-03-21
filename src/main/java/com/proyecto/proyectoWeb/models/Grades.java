package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
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


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private Student student;

}
