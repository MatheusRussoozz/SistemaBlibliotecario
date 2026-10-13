package com.br.russodev.SistemaBlibliotecario.Emprestimo.Controller;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Request.EmpretimoRequestDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmpretimoController {

    private final EmprestimoService emprestimoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarEmprestimo(@RequestBody EmpretimoRequestDto empretimoRequestDto){
        emprestimoService.criarEmprestimo(empretimoRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Emprestimo criado: "+ empretimoRequestDto );
    }

    @PatchMapping("/devolver/{id}")
    public ResponseEntity<?> devolverEmprestimo(@PathVariable Long id){
        emprestimoService.devolverEmprestimo(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Emprestimo devolvido com sucesso, agradecemos!");
    }

    @GetMapping("/listarEmprestimos")
    public ResponseEntity<?> listarEmprestimos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(emprestimoService.listarEmprestimos());
    }

    @GetMapping("/listarEmprestimoPorId/{id}")
    public ResponseEntity<?> listarEmprestimoPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(emprestimoService.listarEmprestimoPorId(id));
    }

    @DeleteMapping("/deletarEmprestimo/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable Long id){
        if (emprestimoService.deletarEmprestimo(id) != false){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Emprestimo deletado com sucesso");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Emprestimo de id: "+ id + " não encontrado!");
        }
    }

}
