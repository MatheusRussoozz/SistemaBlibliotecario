package com.br.russodev.SistemaBlibliotecario.Emprestimo.Mapper.Request;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Request.EmpretimoRequestDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;
import org.springframework.stereotype.Component;

@Component

public class EmprestimoRequestMapper {

    public EmprestimoEntity toRequest(EmpretimoRequestDto requestDto){
        return new EmprestimoEntity(
                requestDto.leitor(),
                requestDto.livro()
        );
    }

}
