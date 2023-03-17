package com.proyecto.proyectoWeb.controllers;

import com.proyecto.proyectoWeb.models.Grades;
import com.proyecto.proyectoWeb.models.Student;
import com.proyecto.proyectoWeb.services.ServicesGrades;
import com.proyecto.proyectoWeb.services.ServicesStudent;
import java.util.ArrayList;
import java.util.List;
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

    private List<Student> studentsList = new ArrayList<>();

    public StudentController(ServicesStudent studentService, ServicesGrades gradesServices){

        this.studentService=studentService;
        this.gradesServices = gradesServices;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students")
    public String formStudent(Model model){
        model.addAttribute("student", new Student());
        return "formulario";
    }
    @PostMapping("/students")
    public Object saveStudent(@ModelAttribute("student") Student student, Model model) {
        String mensaje = new String("null");
        if(student.email.indexOf(String.valueOf("@")) == -1){
            mensaje = "Email erróneo";
        }
        if(!mensaje.equals("null")){
            model.addAttribute("mensaje", mensaje);
            return "/error";
        }
        studentService.addStudent(student.firstName, student.lastName, student.email);
        return new RedirectView("/");
    }


    @GetMapping("/students/delete/{id}")
    public RedirectView deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
        return new RedirectView("/");

    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return ("editar");
    }

    @PostMapping("/students/edit/{id}")
    public Object saveStudent(@ModelAttribute("student") Student student, @PathVariable String id, Model model) {
        String mensaje = new String("null");
        if(student.email.indexOf(String.valueOf("@")) == -1){
            mensaje = "Email erróneo";
        }
        if(!mensaje.equals("null")){
            model.addAttribute("mensaje", mensaje);
            return "/error";
        }
        studentService.editStudent(id, student.firstName, student.lastName, student.email);
        return new RedirectView("/");
    }

    @GetMapping("/students/grade/{id}")
    public String gradeForm(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("grades", new Grades());
        return ("calificar");
    }

    @PostMapping("/students/grade/{id}")
    public RedirectView gradeStudent(@ModelAttribute("grades") Grades grades, @PathVariable String id, Model model) {
        gradesServices.gradeStudent(id, grades.lenguajes, grades.entornos);
        studentService.refreshGrades();
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
}
