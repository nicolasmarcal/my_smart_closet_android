package com.example.mysmartcloset.Models;

import com.example.mysmartcloset.dao.UsuarioDAO;

import android.content.ContentValues;

public class Usuario {
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String dt_nasc;
	private float peso;
	private float altura;
	private Cor cor_cabelo;
	private Cor cor_olhos;
	
	public Usuario(long id, String nome, String email, String senha,
			String dt_nasc, float peso, float altura, Cor cor_cabelo, Cor cor_olhos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.peso = peso;
		this.setAltura(altura);
		this.cor_cabelo = cor_cabelo;
		this.cor_olhos = cor_olhos;
	}
	
	public Usuario(String nome, String email, String senha,
			String dt_nasc, float peso, float altura, Cor cor_cabelo, Cor cor_olhos) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dt_nasc = dt_nasc;
		this.peso = peso;
		this.setAltura(altura);
		this.cor_cabelo = cor_cabelo;
		this.cor_olhos = cor_olhos;
	}
	
	public Usuario(){
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Cor getCor_cabelo() {
		return cor_cabelo;
	}
	public void setCor_cabelo(Cor cor_cabelo) {
		this.cor_cabelo = cor_cabelo;
	}
	public Cor getCor_olhos() {
		return cor_olhos;
	}
	public void setCor_olhos(Cor cor_olhos) {
		this.cor_olhos = cor_olhos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public static ContentValues toValues(Usuario usuario){
		ContentValues values = new ContentValues();
		values.put("nome", usuario.getNome());
		values.put("email", usuario.getEmail());
		values.put("senha", usuario.getSenha());
		values.put("dt_nasc", usuario.getDt_nasc());
		values.put("peso", usuario.getPeso());
		values.put("altura", usuario.getAltura());
		return values;
	}
	
	public boolean cadastrar(){
		return UsuarioDAO.inserir(this);
	}
}
