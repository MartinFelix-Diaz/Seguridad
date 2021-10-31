/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlumnoMyBatis.entity;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Martin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno implements Serializable {
    private static final long serialVersionUID = 3754851399214200439L;
	private int idalumno;
	private String nombre;
	private int telefono;
	private String correo;	
	private int idcarrera;
}
