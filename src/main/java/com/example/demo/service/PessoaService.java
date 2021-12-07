package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;

import com.example.demo.models.Pessoa;

@Service
public class PessoaService {
	
	@Autowired
	Repository pessoaRepository;
	
	//GET <port>/api/v1/pessoas
	public List<Pessoa> getPessoas() {
		return this.pessoaRepository.findAll();
	}
	
	//GET by ID <port>/api/v1/pessoas/{id}
	public ResponseEntity<Pessoa> getPessoa(long id) {
		var pessoa = this.pessoaRepository.findById(id);
		if(!pessoa.isPresent()) return ResponseEntity.notFound().build();
		return ResponseEntity.of(pessoa);
		
	}

	//POST <port>/api/v1/pessoas/post
	public Pessoa postPessoa(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	//DELETE <port>/api/v1/pessoas{id}
	public ResponseEntity<Pessoa> deletePessoa(long id) {
		var pessoa = this.pessoaRepository.findById(id);
		if(!pessoa.isPresent()) return ResponseEntity.notFound().build();
		
		this.pessoaRepository.delete(pessoa.get());
		return ResponseEntity.ok().build();
	}

	//PUT <port>/api/v1/pessoas{id}
	public ResponseEntity<Pessoa> putPessoa(long id, Pessoa pessoa) {
		var pessoaAuxiliar = this.pessoaRepository.findById(id);
		if(!pessoaAuxiliar.isPresent()) return ResponseEntity.notFound().build();
		
		pessoaAuxiliar.get().setId(id);
		pessoaAuxiliar.get().setNome(pessoa.getNome());
		pessoaAuxiliar.get().setIdade(pessoa.getIdade());
		pessoaAuxiliar.get().setData_Nascimento(pessoa.getData_Nascimento());
		final Pessoa pessoaAtualizada = this.pessoaRepository.save(pessoaAuxiliar.get());
		return ResponseEntity.ok(pessoaAtualizada);
	}
	
}
