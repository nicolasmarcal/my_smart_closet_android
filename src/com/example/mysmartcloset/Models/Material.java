package com.example.mysmartcloset.Models;

public class Material {
	private long id;
	private String descricao;
	
	public Material(){
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
