package com.br.russodev.SistemaBlibliotecario.Livro.Repository;

import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity,Long> {
}
