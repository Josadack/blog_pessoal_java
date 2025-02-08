package com.josadaque.blogpessoal.repository;

import java.util.Optional;
import com.josadaque.blogpessoal.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByUsuario(String usuario);

    Optional<Object> cadastrarUsuario(@Valid Usuario usuario);

    Optional<Object> atualizarUsuario(@Valid Usuario usuario);
}
