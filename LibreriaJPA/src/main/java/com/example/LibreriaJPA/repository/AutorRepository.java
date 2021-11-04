/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.LibreriaJPA.repository;

import com.example.LibreriaJPA.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Martin
 */
public interface AutorRepository extends JpaRepository<Autor, Integer>{
    
}
