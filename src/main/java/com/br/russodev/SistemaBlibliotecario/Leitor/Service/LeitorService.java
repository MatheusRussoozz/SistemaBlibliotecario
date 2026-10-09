package com.br.russodev.SistemaBlibliotecario.Leitor.Service;

import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Request.LeitorRequestDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Dto.Response.LeitorResponseDto;
import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Leitor.Mapper.Request.LeitorRequestMapper;
import com.br.russodev.SistemaBlibliotecario.Leitor.Mapper.Response.LeitorResponseMapper;
import com.br.russodev.SistemaBlibliotecario.Leitor.Repository.LeitorRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeitorService {
    private final LeitorRepository leitorRepository;
    private final LeitorRequestMapper leitorRequestMapper;
    private final LeitorResponseMapper leitorResponseMapper;


    public LeitorResponseDto criarLeitor(LeitorRequestDto leitorRequestDto){
        LeitorEntity leitorEntity = leitorRequestMapper.toRequest(leitorRequestDto);
        return leitorResponseMapper.toResponse(leitorEntity);
    }

    public List<LeitorResponseDto> listarLeitores(){
        List<LeitorEntity> leitores = leitorRepository.findAll();
              return leitores.stream()
                .map(leitorResponseMapper::toResponse)
                .collect(Collectors.toList());
    }

    public LeitorResponseDto listarLeitorPorId(Long id){
        Optional<LeitorEntity> procurarLeitor = leitorRepository.findById(id);
        if (procurarLeitor.isPresent()){
            return leitorResponseMapper.toResponse(procurarLeitor.get());
        }
        throw new RuntimeException("Leitor de id '" + id + "' não encontrado");
    }

    public Boolean deletarLeitor(Long id){
        Optional<LeitorEntity> procurarLeitor = leitorRepository.findById(id);
        if (procurarLeitor.isPresent()){
            leitorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public LeitorResponseDto atualizarLeitor(Long id, LeitorRequestDto leitorRequestDto){
        Optional<LeitorEntity> procurarLeitor = leitorRepository.findById(id);
        if (procurarLeitor.isPresent()){
            procurarLeitor.get().setNome(leitorRequestDto.nome());
            leitorRepository.save(procurarLeitor.get());
            return leitorResponseMapper.toResponse(procurarLeitor.get());
        } else {
            throw new RuntimeException("Nenhum leitor foi encontrado no id fornecido");
        }
    }

}
