package com.proyecto.proyectoWeb.services;

import com.proyecto.proyectoWeb.models.Modulos;
import com.proyecto.proyectoWeb.repository.RepositoryModulos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesModulos implements InterfacesModulos {


    RepositoryModulos repositoryModulos;

    public ServicesModulos(RepositoryModulos repositoryModulos) {
        this.repositoryModulos = repositoryModulos;
    }

    @Override
    public List<Modulos> findAll(){
        return repositoryModulos.findAll();
    };

    public void save(Modulos modulo){
        repositoryModulos.save(modulo);
    }

    @Override
    public void actualizarFKProfesor(int modulo_id, int profesor_id){ repositoryModulos.actualizarFKProfesor(modulo_id, profesor_id);}


}
