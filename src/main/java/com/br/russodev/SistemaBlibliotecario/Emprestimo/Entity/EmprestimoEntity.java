package com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity;

import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private LeitorEntity leitor;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private LivroEntity livro;

    @Column(name = "data_emprestimo" )
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao_prevista")
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;

    public EmprestimoEntity(LeitorEntity leitor, LivroEntity livro) {
        this.leitor = leitor;
        this.livro = livro;

    }
}
