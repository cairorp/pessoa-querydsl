package com.example.pessoaquerydsl.pessoa;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaRepository repository;


    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Optional<Pessoa> buscarPorId(Long id){
        return this.repository.findById(id);
    }
}
