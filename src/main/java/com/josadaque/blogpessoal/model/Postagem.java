package com.josadaque.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "O atributo é obrigatório!")
    @Size(min = 5, max = 1000, message = "O atributo texto deve conter no minimo 5 e no maximo 1000 caracteres")
    private String texto;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties("postagens")
    private Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario usuario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O atributo é obrigatório!") @Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O atributo é obrigatório!") @Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no maximo 100 caracteres") String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank(message = "O atributo é obrigatório!") @Size(min = 5, max = 1000, message = "O atributo texto deve conter no minimo 5 e no maximo 1000 caracteres") String getTexto() {
        return texto;
    }

    public void setTexto(@NotBlank(message = "O atributo é obrigatório!") @Size(min = 5, max = 1000, message = "O atributo texto deve conter no minimo 5 e no maximo 1000 caracteres") String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
