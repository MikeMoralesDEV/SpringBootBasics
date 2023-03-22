package com.proyecto.proyectoWeb.controllers;

import com.proyecto.proyectoWeb.models.*;
import com.proyecto.proyectoWeb.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {

    @Autowired
    private ServicesStudent studentService;

    @Autowired
    private final ServicesGrades gradesServices;

    @Autowired
    private final ServicesModulos modulosServices;

    @Autowired
    private final ServicesProfesor profesorServices;

    @Autowired
    private final ServicesNotas notasServices;

    private List<Student> studentsList = new ArrayList<>();

    public StudentController(ServicesStudent studentService, ServicesGrades gradesServices, ServicesModulos modulosServices, ServicesProfesor profesorServices, ServicesNotas notasServices){

        this.studentService = studentService;
        this.gradesServices = gradesServices;
        this.modulosServices = modulosServices;
        this.profesorServices = profesorServices;
        this.notasServices = notasServices;
    }

    // Esto en un futuro será /students como tal. Pues el inicio estaría bien que fuera otro.
    @GetMapping("/")
    public String home(Model model) {

        List<Student> estudiantes = studentService.getAllStudents();
        List<Float> medias = new ArrayList<Float>();
        estudiantes.forEach((estudiante) -> {
                    if (estudiante.getGrades() != null) {
                        medias.add(
                                (
                                        ((float) estudiante.getGrades().getLenguajes() + (float) estudiante.getGrades().getEntornos()) / 2.0F));
                    }else{
                        medias.add(0.0F);
                    }
                }
        );
        model.addAttribute("students", estudiantes);
        model.addAttribute("medias", medias);
        return "students";
    }

    @GetMapping("/students/registro")
    public String formStudent(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("modulos", modulosServices.findAll());
        return "registroAlumno";
    }
    @PostMapping("/students/registro")
    public Object saveStudent(@ModelAttribute("student") Student student, Model model) {
        String mensaje = new String("null");
        if(student.email.indexOf(String.valueOf("@")) == -1){
            mensaje = "Email erróneo";
        }
        if(!mensaje.equals("null")){
            model.addAttribute("mensaje", mensaje);
            return "/error";
        }
        List<Modulos> modulos = student.getModulos();

        studentService.save(student);
        return new RedirectView("/");
    }


    @GetMapping("/students/delete/{id}")
    public RedirectView deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return new RedirectView("/");

    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable int id, Model model){
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        model.addAttribute("student", estudiante);
        return ("modificarAlumno");
    }

    @PostMapping("/students/edit/{id}")
    public Object saveStudent(@ModelAttribute("student") Student student, @PathVariable int id, Model model) {
        String mensaje = new String("null");
        if(student.email.indexOf(String.valueOf("@")) == -1){
            mensaje = "Email erróneo";
        }
        if(!mensaje.equals("null")){
            model.addAttribute("mensaje", mensaje);
            return "/error";
        }
        student.setId(id);
        studentService.save(student);
        return new RedirectView("/");
    }

    @GetMapping("/students/modulos/{id}")
    public String editModulosStudents(@PathVariable int id, Model model){
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        //Aqui del repositirio modulos, cojo todos los modulos y los paso al modal. Podría pasar al modal solo los que no estén ya en el alumno y le ahorro trabajo a la vista y la lógica de después.
        model.addAttribute("student", estudiante);
        return ("editar");
    }

//    De aqui para abajo es testing y será borrado.
    @GetMapping("/students/grade/{id}")
    public String gradeForm(@PathVariable int id, Model model){
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        model.addAttribute("student", estudiante);
        model.addAttribute("grades", new Grades());
        return ("calificar");
    }

    @PostMapping("/students/grade/{id}")
    public RedirectView gradeStudent(@ModelAttribute("grades") Grades grades, @PathVariable int id, Model model) {
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        System.out.println(estudiante);

        grades.setStudent(estudiante);

        gradesServices.gradeStudent(grades);
        return new RedirectView("/");
    }

    @GetMapping("/welcome/{nombre}")
    public String welcome(Model model, @PathVariable String nombre){
        model.addAttribute("persona", nombre);
        return "welcome";
    }

    @GetMapping("/welcome")
    public String welcomeDefault(Model model){
        model.addAttribute("persona", "desconocido");
        return "welcome";
    }


    //A partir de aquí irán las rutas de /profesores que posteriormente se dividirá a otro controlador.
    @GetMapping("/profesores")
    public String profesoresInicio(Model model){
        model.addAttribute("profesores", profesorServices.findAll());
        return "profesores";
    }

    @GetMapping("/profesores/nuevo")
    public String profesoresNuevo(Model model){
        model.addAttribute("profesor", new Profesor());
        model.addAttribute("modulos", modulosServices.findAll());
        return "registroProfesor";
    }

    @PostMapping("/profesores/nuevo")
    public RedirectView guardarProfesor(@ModelAttribute("profesor") Profesor profesor, Model model) {
        //Aqui se debería hacer control por si ya existe
        profesorServices.save(profesor);
        return new RedirectView("/profesores");

    }

    //A partir de aquí las rutas modulos
    @GetMapping("/modulos/nuevo")
    public String moduloNuevo(Model model){
        model.addAttribute("modulo", new Modulos());
        return "registroModulo";
    }

    @PostMapping("/modulos/nuevo")
    public RedirectView guardarModulo(@ModelAttribute("modulo") Modulos modulo, Model model) {
        //Aqui se deberia hacer control por si ya existe.
        modulosServices.save(modulo);
        return new RedirectView("/modulos");
    }

    @GetMapping("/modulos")
    public String modulos(Model model){
        model.addAttribute("modulos", modulosServices.findAll());
        return "modulos";
    }


    // Testing notas
    @GetMapping("/evaluar/{id}")
    public String evaluar(Model model, @PathVariable int id){
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        model.addAttribute("estudiante", estudiante);
        List<Nota> listaNotas = new ArrayList<Nota>(estudiante.getModulos().size());
        estudiante.setNotas(listaNotas); //estaria bien hacerlo cuando edite tambien los modulos en los que está
        studentService.save(estudiante); //A ver si se crean las notas vacias
        auxiliaryList auxiliaryList = new auxiliaryList(listaNotas);
        model.addAttribute("notas", auxiliaryList);
        return "evaluarAlumno";
    }

    @PostMapping("/evaluar/{id}")
    public RedirectView guardarEvaluacion(@ModelAttribute("notas") auxiliaryList auxiliaryList, @PathVariable int id){
        Optional<Student> aux = studentService.findById(id);
        Student estudiante = aux.orElseThrow(() ->
                new RuntimeException("El usuario no existe")
        );
        List<Nota> notasForm = auxiliaryList.getListNota();
        for(int i=0; i < estudiante.getModulos().size(); i++){

            notasForm.get(i).setStudent(estudiante);
            notasForm.get(i).setModulos(estudiante.getModulos().get(i));
            notasServices.save(notasForm.get(i));

        }
        return new RedirectView("/");
    }


}
