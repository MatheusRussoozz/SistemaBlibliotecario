package com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Request;

import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;


import java.time.LocalDate;

public record EmpretimoRequestDto(
         LeitorEntity leitor,

         LivroEntity livro

){
}
