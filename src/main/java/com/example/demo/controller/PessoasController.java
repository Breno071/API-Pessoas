package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pessoa;
import com.example.demo.service.PessoaService;

@RequestMapping(path = "api/v1/pessoas")
@RestController
public class PessoasController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> getPessoas(){
		return this.pessoaService.getPessoas(); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable long id) {
		return this.pessoaService.getPessoa(id);
	}
	
	@PostMapping("/post")
	public Pessoa postPessoa(@Validated @RequestBody Pessoa pessoa){
		return this.pessoaService.postPessoa(pessoa);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Pessoa> deletePessoa(@PathVariable long id){
		return this.pessoaService.deletePessoa(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pessoa> putPessoa(@PathVariable(value = "id") long id, @Validated @RequestBody Pessoa pessoa){
		return this.pessoaService.putPessoa(id, pessoa);
	}

}
