package com.br.russodev.SistemaBlibliotecario.Leitor.Repository;

import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Long> {
}
