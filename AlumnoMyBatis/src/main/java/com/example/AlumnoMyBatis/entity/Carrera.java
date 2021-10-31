/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlumnoMyBatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
/**
 *
 * @author Martin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera implements Serializable{
    private int idcarrera;
    private String nombre;
}
