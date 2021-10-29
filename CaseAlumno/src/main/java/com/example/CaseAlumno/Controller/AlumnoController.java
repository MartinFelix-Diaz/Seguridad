/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CaseAlumno.Controller;

import com.example.CaseAlumno.entity.Alumno;
import com.example.CaseAlumno.entity.Carrera;
import com.example.CaseAlumno.repository.AlumnoRepository;
import com.example.CaseAlumno.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Martin
 */
@Controller
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CarreraRepository carreraRepository;
    @RequestMapping("/")
    public String mensaje(Model model){
        model.addAttribute("mensaje", "Bienvenidos Thymeleaf");
        return "index";
    }
    @RequestMapping("/alums")
    public String alums(Model model) {
        model.addAttribute("alums", alumnoRepository.findAll());
        return "alums";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("carres", carreraRepository.findAll());
        return "add";
    }
    @RequestMapping("/add")
    public String Guardar(@RequestParam String nombre, @RequestParam int telefono,
                          @RequestParam String correo ,@RequestParam int idcarre,Model model) {
        Alumno alum = new Alumno();
        Carrera carre = carreraRepository.findById(idcarre).get();
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setCarrera(carre);
        alumnoRepository.save(alum);
        return "redirect:/alums";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
         Alumno alum = alumnoRepository.findById(id).orElse(null);
        alumnoRepository.delete(alum);
        return "redirect:/alums";
    }
     @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("alum", alumnoRepository.findById(id).orElse(null));
        model.addAttribute("carres", carreraRepository.findAll());
        return "edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String nombre, 
           @RequestParam int telefono,@RequestParam String correo ,@RequestParam int carrera) {
        Alumno alum= alumnoRepository.findById(id).orElse(null);
        Carrera carre = carreraRepository.findById(carrera).get();
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setCarrera(carre);
        alumnoRepository.save(alum);
        return "redirect:/alums";
    }
}
