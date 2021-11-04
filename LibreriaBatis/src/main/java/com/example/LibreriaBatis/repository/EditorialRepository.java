/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.LibreriaBatis.repository;

import com.example.LibreriaBatis.entity.Editorial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 *
 * @author Martin
 */
@Mapper
public interface EditorialRepository {
    @Select("select * from editorial")
    public List<Editorial> findAll();
}
