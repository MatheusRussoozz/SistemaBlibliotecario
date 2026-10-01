package com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Response;

import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;

import java.time.LocalDate;

public record EmprestimoResponseDto (

        LeitorEntity leitor,

        LivroEntity livro,

        LocalDate dataEmprestimo,

        LocalDate dataDevolucaoPrevista,

        LocalDate dataDevolucao
){
}
