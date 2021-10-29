/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CaseAlumno.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Martin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private int id;
    @Column(name = "nom_car")
    private String nomcar;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idalumno")
    private Set<Alumno> alumnos;
}
