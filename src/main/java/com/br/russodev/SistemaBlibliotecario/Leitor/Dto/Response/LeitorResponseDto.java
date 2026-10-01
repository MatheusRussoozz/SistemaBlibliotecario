package com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Response;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;

import java.util.List;

public record LeitorResponseDto(

        String nome,
        List<EmprestimoEntity> emprestimo


) {
}
