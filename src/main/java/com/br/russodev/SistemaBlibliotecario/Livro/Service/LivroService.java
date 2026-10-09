package com.br.russodev.SistemaBlibliotecario.Livro.Service;

import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Request.LivroRequestDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Dto.Response.LivroResponseDto;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;
import com.br.russodev.SistemaBlibliotecario.Livro.Mapper.Request.LivroRequestMapper;
import com.br.russodev.SistemaBlibliotecario.Livro.Mapper.Response.LivroResponseMapper;
import com.br.russodev.SistemaBlibliotecario.Livro.Repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroRequestMapper livroRequestMapper;
    private final LivroResponseMapper livroResponseMapper;

    public LivroResponseDto criarLivro(LivroRequestDto livroRequestDto){
        LivroEntity livroEntity = livroRequestMapper.toRequest(livroRequestDto);
        livroRepository.save(livroEntity);
        return livroResponseMapper.toResponse(livroEntity);
    }

    public List<LivroResponseDto> listarLivros(){
        List<LivroResponseDto> livroParaDto = new ArrayList<>();
        List<LivroEntity> livroEntityList = livroRepository.findAll();
        for (LivroEntity livro : livroEntityList){
            if (livro.getQuantidade() > 0){
               LivroResponseDto livroDto = livroResponseMapper.toResponse(livro);
               livroParaDto.add(livroDto);


            }
        }
        return livroParaDto;
    }

    public LivroResponseDto buscarLivroPorId(Long id){
        Optional<LivroEntity> buscarLivro = livroRepository.findById(id);
        if (buscarLivro.isPresent()){
            return livroResponseMapper.toResponse(buscarLivro.get());
        } else {
            throw  new RuntimeException("Livro de id: "+ id + " não foi encontrado" );
        }
    }

    public Boolean deletarLivro(Long id){
        Optional<LivroEntity> buscarLivro = livroRepository.findById(id);
        if (buscarLivro.isPresent()) {
            livroRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }


}
