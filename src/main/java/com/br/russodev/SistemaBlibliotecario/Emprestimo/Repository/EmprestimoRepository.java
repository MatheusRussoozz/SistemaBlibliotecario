package com.br.russodev.SistemaBlibliotecario.Emprestimo.Repository;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
