package com.br.russodev.SistemaBlibliotecario.Leitor.Controller;

import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Request.LeitorRequestDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Response.LeitorResponseDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Leitor.Mapper.Request.LeitorRequestMapper;
import com.br.russodev.SistemaBlibliotecario.Leitor.Service.LeitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leitor")
@RequiredArgsConstructor
public class LeitorController {

    private final LeitorService leitorService;

    @PostMapping("/criarLeitor")
    public ResponseEntity<?> criarLeitor(@RequestBody LeitorRequestDto leitorRequestDto){
        LeitorResponseDto criarLeitor = leitorService.criarLeitor(leitorRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarLeitor);
    }

    @PutMapping("/atualizarLeitor/{id}")
    public ResponseEntity<?> atualizarLeitor(@PathVariable Long id, @RequestBody LeitorRequestDto leitorRequestDto){
       LeitorResponseDto atualizarLeitor = leitorService.atualizarLeitor(id, leitorRequestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atualizarLeitor);
    }

    @GetMapping("/listarLeitores")
    public ResponseEntity<?> listarLeitores(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(leitorService.listarLeitores());
    }

    @GetMapping("/listarLeitor/{id}")
    public ResponseEntity<?> listarLeitorPorId(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(leitorService.listarLeitorPorId(id));
    }

    @DeleteMapping("/deletarLeitor")
    public ResponseEntity<?> deletarLeitor(@PathVariable Long id){
        leitorService.deletarLeitor(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }








}
