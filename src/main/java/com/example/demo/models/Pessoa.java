package com.example.demo.models;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "Pessoas")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	private String nome;
	private int idade;
	private Date data_nascinmento;
	
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
		return this.data_nascinmento;
	}
	
	public void setData_Nascimento(Date data_nasccimento) {
		this.data_nascinmento = data_nasccimento;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
