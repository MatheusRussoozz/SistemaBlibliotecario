package com.br.russodev.SistemaBlibliotecario.Livro.Dto.Request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public record LivroRequestDto(

     String titulo,
     String autor,
     LocalDate dataLancamento,
     int quantidade


) {
}
