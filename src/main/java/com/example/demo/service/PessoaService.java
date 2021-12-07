package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.*;

import com.example.demo.models.Pessoa;

@Service
public class PessoaService {
	
	@Autowired
	Repository pessoaRepository;

	public List<Pessoa> getPessoas() {
		return this.pessoaRepository.findAll();
	}

	public Optional<Pessoa> getPessoa(long id) {
		return this.pessoaRepository.findById(id);		
	}

	public Pessoa postPessoa(Pessoa pessoa) {
		return this.pessoaRepository.save(pessoa);
	}

	public ResponseEntity<Pessoa> deletePessoa(long id) {
		var pessoa = this.pessoaRepository.findById(id);
		if(pessoa.isEmpty()) return ResponseEntity.notFound().build();
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<Pessoa> putPessoa(long id, Pessoa pessoa) {
		var pessoaAuxiliar = this.pessoaRepository.findById(id);
		if(pessoaAuxiliar.isEmpty()) return ResponseEntity.notFound().build();
		pessoaAuxiliar.get().setNome(pessoa.getNome());
		pessoaAuxiliar.get().setIdade(pessoa.getIdade());
		pessoaAuxiliar.get().setData_Nascimento(pessoa.getData_Nascimento());
		return ResponseEntity.ok(pessoa).of(pessoaAuxiliar);
	}
	
}
