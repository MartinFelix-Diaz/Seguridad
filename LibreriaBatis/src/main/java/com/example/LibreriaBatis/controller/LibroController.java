/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.LibreriaBatis.controller;

import com.example.LibreriaBatis.entity.Libro;
import com.example.LibreriaBatis.repository.AutorRepository;
import com.example.LibreriaBatis.repository.EditorialRepository;
import com.example.LibreriaBatis.repository.LibroRepository;
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
public class LibroController {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private AutorRepository autorRepository;
    @RequestMapping("/libs")
    public String libs(Model model) {
        model.addAttribute("libs", libroRepository.findAll());
        return "/libro/libs";
    }
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("eds", editorialRepository.findAll());
        model.addAttribute("auts",autorRepository.findAll());
        return "/libro/add";
    }
    @RequestMapping("/add")
    public String Guardar(@RequestParam String nombre,@RequestParam int idaut,@RequestParam int ided,Model model) {
        Libro lib = new Libro();
        lib.setNombre(nombre);
        lib.setIdautor(idaut);
        lib.setIdeditorial(ided);
        libroRepository.insert(lib);
        return "redirect:/libs";
    }
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        libroRepository.deleteById(id);
        return "redirect:/libs";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("lib", libroRepository.readLibro(id));
        model.addAttribute("eds", editorialRepository.findAll());
        model.addAttribute("auts",autorRepository.findAll());
        return "/libro/edit";
    }
    @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String nombre,
                        @RequestParam int idautor,@RequestParam int ideditorial) {
        System.out.println(id+"/"+nombre+"/"+idautor+"/"+ideditorial);
        Libro lib= libroRepository.readLibro(id);
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroRepository.update(lib);
        return "redirect:/libs";
    }
}
