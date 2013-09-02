package com.example.mysmartcloset.Models;

public class Cor {
	private long id;
	private String descricao;
	private String rgb;
	private String tipo_cor;
	public static final String COR_OLHOS = "Olhos";
	public static final String COR_CABELO = "Cabelo";
	
	public Cor(long id, String descricao, String rgb, String tipo_cor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.rgb = rgb;
		this.tipo_cor = tipo_cor;
	}
	
	public Cor(){
		
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

	public String getRgb() {
		return rgb;
	}

	public void setRgb(String rgb) {
		this.rgb = rgb;
	}

	public String getTipo_cor() {
		return tipo_cor;
	}

	public void setTipo_cor(String tipo_cor) {
		this.tipo_cor = tipo_cor;
	}
	
}
