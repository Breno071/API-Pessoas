package com.example.demo.models;

import java.util.Date;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

import com.example.demo.pessoadto.PessoaDTO;


@Entity
@Table(name = "Pessoas")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	private String nome;
	private int idade;
	private Date entity_data_criacao;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Date getData_Nascimento() {
		return this.entity_data_criacao;
	}
	
	public void setData_Nascimento(Date data_nasccimento) {
		this.entity_data_criacao = data_nasccimento;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Pessoa(PessoaDTO pessoaDto) {
		this.nome = pessoaDto.getNomeDto();
		this.idade = pessoaDto.getIdadeDto();
		this.entity_data_criacao = new Date(System.currentTimeMillis());
	}
	
	public Pessoa() {
		
	}
}
