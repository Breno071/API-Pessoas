package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.exception.PessoaNaoEncontradaException;
import com.example.demo.models.Pessoa;
import com.example.demo.pessoadto.PessoaDTO;

@Service
public class PessoaService {
	
	@Autowired
	Repository pessoaRepository;
	
	//GET <port>/api/v1/pessoas
	public List<Pessoa> getPessoas() {
		return this.pessoaRepository.findAll();
	}
	
	//GET by ID <port>/api/v1/pessoas/{id}
	public ResponseEntity<Pessoa> getPessoa(long id) throws PessoaNaoEncontradaException {
		var pessoa = this.pessoaRepository.findById(id);
		if(!pessoa.isPresent()) throw new PessoaNaoEncontradaException(id);
		return ResponseEntity.of(pessoa);
		
	}

	//POST <port>/api/v1/pessoas/post
	public Pessoa postPessoa(PessoaDTO pessoaDto) {
		var pessoa = new Pessoa(pessoaDto);
		return this.pessoaRepository.save(pessoa);
	}

	//DELETE <port>/api/v1/pessoas{id}
	public ResponseEntity<Pessoa> deletePessoa(long id) throws PessoaNaoEncontradaException {
		var pessoa = this.pessoaRepository.findById(id);
		if(!pessoa.isPresent()) throw new PessoaNaoEncontradaException(id);
		
		this.pessoaRepository.delete(pessoa.get());
		return ResponseEntity.ok().build();
	}

	//PUT <port>/api/v1/pessoas{id}
	public ResponseEntity<Pessoa> putPessoa(long id, PessoaDTO pessoa) throws PessoaNaoEncontradaException {
		var pessoaAuxiliar = this.pessoaRepository.findById(id);
		if(!pessoaAuxiliar.isPresent()) throw new PessoaNaoEncontradaException(id);
		
		pessoaAuxiliar.get().setId(id);
		pessoaAuxiliar.get().setNome(pessoa.getNomeDto());
		pessoaAuxiliar.get().setIdade(pessoa.getIdadeDto());
		final Pessoa pessoaAtualizada = this.pessoaRepository.save(pessoaAuxiliar.get());
		return ResponseEntity.ok(pessoaAtualizada);
	}
	
}
