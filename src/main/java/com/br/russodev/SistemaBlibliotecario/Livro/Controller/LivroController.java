package com.br.russodev.SistemaBlibliotecario.Livro.Controller;

import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Request.LivroRequestDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Response.LivroResponseDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping("/criarLivro")
    public ResponseEntity<?> criarLivro(@RequestBody LivroRequestDto livroRequestDto){
        LivroResponseDto livroCriado = livroService.criarLivro(livroRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livroCriado);
    }

    @GetMapping("/listarLivros")
    public ResponseEntity<?> listarLivros(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroService.listarLivros());
    }

    @GetMapping("/buscarLivro/{id}")
    public ResponseEntity<?> buscarLivro(@PathVariable Long id){
        LivroResponseDto livroBuscado = livroService.buscarLivroPorId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroBuscado);
    }

    @DeleteMapping("/deletarlivro/{id}")
    public ResponseEntity<?> deletarLeitor(@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }
}
