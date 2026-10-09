package com.br.russodev.SistemaBlibliotecario.Emprestimo.Service;

import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Request.EmpretimoRequestDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Dto.Response.EmprestimoResponseDto;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Entity.EmprestimoEntity;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Mapper.Request.EmprestimoRequestMapper;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Mapper.Response.EmprestimoResponseMapper;
import com.br.russodev.SistemaBlibliotecario.Emprestimo.Repository.EmprestimoRepository;
import com.br.russodev.SistemaBlibliotecario.Leitor.Entity.LeitorEntity;
import com.br.russodev.SistemaBlibliotecario.Leitor.Repository.LeitorRepository;
import com.br.russodev.SistemaBlibliotecario.Livro.Entity.LivroEntity;
import com.br.russodev.SistemaBlibliotecario.Livro.Repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LeitorRepository leitorRepository;
    private final LivroRepository livroRepository;
    private final EmprestimoRequestMapper emprestimoRequestMapper;
    private final EmprestimoResponseMapper emprestimoResponseMapper;


    //criar emprestimo

    public EmprestimoResponseDto criarEmprestimo(EmpretimoRequestDto empretimoRequestDto){
        Optional<LeitorEntity> procurarLeitor = leitorRepository.findById(empretimoRequestDto.leitor().getId());
        if (procurarLeitor.isPresent()){
            Optional<LivroEntity> procurarLivro = livroRepository.findById(empretimoRequestDto.livro().getId());
            if (procurarLivro.isPresent()){
                if (procurarLivro.get().getQuantidade()>0){
                    EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
                    emprestimoEntity = emprestimoRequestMapper.toRequest(new EmpretimoRequestDto(procurarLeitor.get(), procurarLivro.get()));
                    emprestimoEntity.setDataEmprestimo(LocalDate.now());
                    emprestimoEntity.setDataDevolucaoPrevista(emprestimoEntity.getDataEmprestimo().plusDays(10));
                    emprestimoRepository.save(emprestimoEntity);
                    procurarLivro.get().setQuantidade(procurarLivro.get().getQuantidade() - 1);
                    livroRepository.save(procurarLivro.get());
                    return emprestimoResponseMapper.toResponse(emprestimoEntity);
                } else {
                    throw new RuntimeException("O estoque no livro '"+ empretimoRequestDto.livro().getTitulo() + "' está esgotado, tente novamente em outro momento");
                }
            } else {
                throw new RuntimeException("Livro não encontrado");
            }
        } else {
            throw new RuntimeException("Leitor não encontrado");
        }
    }

    public EmprestimoResponseDto devolverEmprestimo (Long id){
        Optional<EmprestimoEntity> procurarEmprestimo = emprestimoRepository.findById(id);
        if (procurarEmprestimo.isPresent()){
            if (procurarEmprestimo.get().getDataDevolucao() == null) {
                 procurarEmprestimo.get().setDataDevolucao(LocalDate.now());
                 emprestimoRepository.save(procurarEmprestimo.get());
                 Optional<LivroEntity> procurarLivro;
                 procurarLivro = livroRepository.findById(procurarEmprestimo.get().getLivro().getId());
                 procurarLivro.get().setQuantidade(procurarLivro.get().getQuantidade() + 1);
                 livroRepository.save(procurarLivro.get());
                 return emprestimoResponseMapper.toResponse(procurarEmprestimo.get());
            } else {
                throw new RuntimeException("Esse a devolução desse emprestimo já foi feita!");
            }
        } else {
            throw new RuntimeException("Emprestimo nao encontrado insira um id valido");
        }
    }

    public List<EmprestimoResponseDto> listarEmprestimos(){
        List<EmprestimoEntity> emprestimos = emprestimoRepository.findAll();
        return emprestimos.stream()
                .map(emprestimoResponseMapper::toResponse)
                .collect(Collectors.toList());

    }

    public EmprestimoResponseDto listarEmprestimoPorId(Long id){
        Optional<EmprestimoEntity> emprestimo = emprestimoRepository.findById(id);
        return emprestimo.map(emprestimoResponseMapper::toResponse).orElseThrow(() -> new RuntimeException("Não existe nenhum emprestimo no id: "+ id));
    }

    public boolean deletarEmprestimo(Long id){
        Optional<EmprestimoEntity> emprestimo = emprestimoRepository.findById(id);
        if (emprestimo.isPresent()){
            emprestimoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
