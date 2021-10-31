/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlumnoMyBatis.repository;

import com.example.AlumnoMyBatis.entity.Carrera;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author Martin
 */
@Mapper
public interface CarreraRepository {
    @Select("select * from carrera")
    public List<Carrera> findAll();
}
