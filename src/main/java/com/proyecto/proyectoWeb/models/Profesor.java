package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="profesores")
public class Profesor  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String nombre;

    @Column(name = "email")
    @JdbcTypeCode(SqlTypes.CHAR)
    private String email;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Modulos> modulos = new ArrayList<>();

}
