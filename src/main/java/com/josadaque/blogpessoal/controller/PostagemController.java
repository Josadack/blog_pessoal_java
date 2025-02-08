package com.josadaque.blogpessoal.controller;


import com.josadaque.blogpessoal.model.Postagem;
import com.josadaque.blogpessoal.repository.PostagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.josadaque.blogpessoal.repository.TemaRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable (value = "id") Long id){
        Optional<Postagem> postagemModel = postagemRepository.findById(id);
        if(!postagemModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não Localizado❗");

        return ResponseEntity.status(HttpStatus.OK).body(postagemModel.get());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<Postagem> post(@Valid @RequestBody Postagem postagem) {
        // Verifica se o Tema está faltando ou inválido
        if (postagem.getTema() == null || postagem.getTema().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "❌ Tema não informado! Verifique se o campo tema e seu ID foram preenchidos.");
        }

        // Verifica se o Tema existe no banco de dados
        if (temaRepository.existsById(postagem.getTema().getId())) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(postagemRepository.save(postagem));
        }

        // Caso o Tema informado não exista
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "❌ Tema não encontrado no banco de dados.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable(value = "id") Long id, @Valid @RequestBody Postagem postagem) {
        // Verifica se a Postagem existe no banco de dados
        if (postagemRepository.existsById(id)) {
            // Verifica se o Tema foi enviado corretamente
            if (postagem.getTema() == null || postagem.getTema().getId() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "❌ Tema não informado! Verifique se o campo tema e seu ID foram preenchidos.");
            }

            // Verifica se o Tema existe no banco de dados
            if (temaRepository.existsById(postagem.getTema().getId())) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(postagemRepository.save(postagem));
            }

            // Caso o Tema informado não exista
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "❌ Tema não encontrado no banco de dados.");
        }

        // Caso a Postagem não exista no banco de dados
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("⚠️ Postagem não encontrada!");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable (value = "id") Long id){
        Optional<Postagem> postagemModel = postagemRepository.findById(id);
        if(!postagemModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("⚠️ Postagem não encontrada!");

        postagemRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Postagem deletada com sucesso❗");
    }

}
