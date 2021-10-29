/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CaseAlumno.repository;

import com.example.CaseAlumno.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Martin
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
    
}
