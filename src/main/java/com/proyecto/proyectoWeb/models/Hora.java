package com.proyecto.proyectoWeb.models;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

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

    public List<Modulos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulos> modulos) {
        this.modulos = modulos;
    }

    public String getFranja_fin() {
        return franja_fin;
    }

    public void setFranja_fin(String franja_fin) {
        this.franja_fin = franja_fin;
    }

    public String getFranja_inicio() {
        return franja_inicio;
    }

    public void setFranja_inicio(String franja_inicio) {
        this.franja_inicio = franja_inicio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
