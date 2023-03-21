package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="horas")
public class Hora {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name = "dia")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String dia;

    @Column(name = "franja_inicio")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String franja_inicio;

    @Column(name = "franja_fin")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String franja_fin;

    @ManyToMany(mappedBy = "horas")
    private List<Modulos> modulos = new ArrayList<>();


}
