package com.example.pessoaquerydsl.pessoa.web;

import com.example.pessoaquerydsl.pessoa.Pessoa;
import com.example.pessoaquerydsl.pessoa.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PessoaResponseDTO buscarPorId(@PathVariable Long id){
        return this.buildPessoaResponse(this.service.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado.")));

    }

    private PessoaResponseDTO buildPessoaResponse(Pessoa pessoa) {
        return PessoaResponseDTO.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .numeroCelular(pessoa.getNumeroCelular())
                .build();
    }
}
