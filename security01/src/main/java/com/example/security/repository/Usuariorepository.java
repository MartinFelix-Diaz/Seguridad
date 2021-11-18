package com.example.security.repository;

import com.example.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Usuariorepository extends JpaRepository<Usuario, Integer>{
	public Usuario findByUsername(String username);
}
