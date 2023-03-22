package com.proyecto.proyectoWeb.controllers;

import com.proyecto.proyectoWeb.models.Nota;
import lombok.Data;

import java.util.List;

@Data
public class auxiliaryList {
    List<Nota> listNota;

    public auxiliaryList(List<Nota> listNota) {
        this.listNota = listNota;
    }
}
