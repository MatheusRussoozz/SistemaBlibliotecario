package com.br.russodev.SistemaBlibliotecario.Livro.Mapper.Response;

import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Request.LivroRequestDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Response.LivroResponseDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;

public class LivroResponseMapper {

    public LivroResponseDto toResponse(LivroEntity livroEntity){

        return new LivroResponseDto(
                livroEntity.getTitulo(),
                livroEntity.getAutor(),
                livroEntity.getDataLancamento(),
                livroEntity.getQuantidade()
        );

    }

}
