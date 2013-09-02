package com.example.mysmartcloset.Models;

import java.util.List;

public abstract class PecaDeRoupa {
	private long id;
	private List<Cor> cores;
	private String descricao;
	private Usuario usuario;
	private Estilo estilo;
	private Marca marca;
	private Material material;
	private String caminhoImagem;
	
	public static final String[] TIPOS_ROUPA = {"Calca", "Acessorio", "Vestido", "Sapato", "Camisa", "Casaco", "Saia"};
	public static final String[] TIPOS_ROUPA_LABEL = {"Calça", "Acessório", "Vestido", "Sapato", "Camisa", "Casaco", "Saia"};
	
	public long getId(){
		return this.id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public List<Cor> getCores() {
		return cores;
	}
	public void setCores(List<Cor> cores) {
		this.cores = cores;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
	public String getCaminhoImagem(){
		return caminhoImagem;
	}
	
	public void setCaminhoImagem(String caminhoImagem){
		this.caminhoImagem = caminhoImagem;
	}
	
}
