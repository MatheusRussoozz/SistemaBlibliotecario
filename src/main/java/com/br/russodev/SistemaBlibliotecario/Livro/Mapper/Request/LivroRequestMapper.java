package com.br.russodev.SistemaBlibliotecario.Livro.Mapper.Request;

import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Request.LivroRequestDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;

public class LivroRequestMapper {

    public LivroEntity toRequest(LivroRequestDto livroRequestDto){
        return new LivroEntity(
                livroRequestDto.titulo(),
                livroRequestDto.autor(),
                livroRequestDto.dataLancamento(),
                livroRequestDto.quantidade()
        );
    }

}
