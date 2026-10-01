package com.br.russodev.SistemaBlibliotecario.Livro.Dto.Response;

import java.time.LocalDate;

public record LivroResponseDto(

        String titulo,
        String autor,
        LocalDate dataLancamento,
        int quantidade


) {
}
