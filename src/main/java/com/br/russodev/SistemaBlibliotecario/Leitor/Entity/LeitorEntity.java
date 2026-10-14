package com.br.russodev.SistemaBlibliotecario.Leitor.Entity;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Scanner;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_leitor")
public class LeitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "leitor")
    private List<EmprestimoEntity> emprestimo;

    public LeitorEntity(String nome) {
        this.nome = nome;
    }
}
