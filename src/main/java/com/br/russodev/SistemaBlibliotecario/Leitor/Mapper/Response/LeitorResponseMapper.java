package com.br.russodev.SistemaBlibliotecario.Leitor.Mapper.Response;

import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Request.LeitorRequestDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Response.LeitorResponseDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;

public class LeitorResponseMapper {

    public LeitorResponseDto toResponse(LeitorEntity leitorEntity){
        return new LeitorResponseDto(
                leitorEntity.getNome(),
                leitorEntity.getEmprestimo()
        );
    }

}
