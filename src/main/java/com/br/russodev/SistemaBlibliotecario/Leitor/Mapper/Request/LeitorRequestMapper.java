package com.br.russodev.SistemaBlibliotecario.Leitor.Mapper.Request;

import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Request.LeitorRequestDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import org.springframework.stereotype.Component;

@Component
public class LeitorRequestMapper {

    public LeitorEntity toRequest(LeitorRequestDto requestDto){
        return new LeitorEntity(
                requestDto.nome()
                );
    }

}
