package com.josadaque.blogpessoal.repository;

import com.josadaque.blogpessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
}
