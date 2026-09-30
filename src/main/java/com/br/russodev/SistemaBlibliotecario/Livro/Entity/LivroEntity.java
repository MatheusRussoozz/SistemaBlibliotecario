package com.br.russodev.SistemaBlibliotecario.Livro.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "quantidade")
    private int qauntidade;




}
