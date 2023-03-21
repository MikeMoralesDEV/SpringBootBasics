package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
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


}
