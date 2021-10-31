/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlumnoMyBatis.controller;

import com.example.AlumnoMyBatis.entity.Alumno;
import com.example.AlumnoMyBatis.repository.AlumnoRepository;
import com.example.AlumnoMyBatis.repository.CarreraRepository;
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
    private CarreraRepository carreraRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @RequestMapping("/alums")
    public String alums(Model model) {
        model.addAttribute("alums", alumnoRepository.findAll());
        return "alumno/alums";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("cars", carreraRepository.findAll());
        return "alumno/add";
    }
    @RequestMapping("/add")
    public String guardar(@RequestParam String nombre, @RequestParam int telefono, @RequestParam String correo , @RequestParam int idcar, Model model) {
        Alumno alum = new Alumno();
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setIdcarrera(idcar);
        alumnoRepository.insert(alum);
        return "redirect:/alums";
    }
    @RequestMapping("/del/{id}")
    public String deleteprod(@PathVariable(value="id") int id) {
        alumnoRepository.deleteById(id);
        return "redirect:/alums";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("cars", carreraRepository.findAll());
        model.addAttribute("alum", alumnoRepository.readAlumno(id));
        return "producto/edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam int idalumno, @RequestParam String nombre, 
            @RequestParam int telefono,  @RequestParam String correo, @RequestParam int idcarrera) {
        System.out.println(idalumno+"/"+nombre+"/"+telefono+"/"+correo+"/"+idcarrera);
        Alumno alum = alumnoRepository.readAlumno(idalumno);
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setIdcarrera(idcarrera);
        alumnoRepository.update(alum);
        return "redirect:/alums";
    }
}
