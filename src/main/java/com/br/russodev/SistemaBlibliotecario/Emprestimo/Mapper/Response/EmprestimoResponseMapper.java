package com.br.russodev.SistemaBlibliotecario.Emprestimo.Mapper.Response;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Request.EmpretimoRequestDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Response.EmprestimoResponseDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;

public class EmprestimoResponseMapper {

    public EmprestimoResponseDto toResponse(EmprestimoEntity emprestimoEntity){
        return new EmprestimoResponseDto(
                emprestimoEntity.getLeitor(),
                emprestimoEntity.getLivro(),
                emprestimoEntity.getDataEmprestimo(),
                emprestimoEntity.getDataDevolucaoPrevista(),
                emprestimoEntity.getDataDevolucao()
        );
    }

}
