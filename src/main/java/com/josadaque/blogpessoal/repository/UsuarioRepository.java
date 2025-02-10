package com.josadaque.blogpessoal.repository;

import java.util.Optional;

import com.josadaque.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByUsuario(String usuario);

}