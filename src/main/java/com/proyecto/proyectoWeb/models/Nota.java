package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="notas")
public class Nota {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name = "nota")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer nota;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "modulos_id")
    private Modulos modulos;

}
