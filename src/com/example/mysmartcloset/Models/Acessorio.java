package com.example.mysmartcloset.Models;

public class Acessorio extends PecaDeRoupa {
	private TipoRoupa tipo;
	
	public Acessorio(){
		super();
	}
	public TipoRoupa getTipo() {
		return tipo;
	}

	public void setTipo(TipoRoupa tipo) {
		this.tipo = tipo;
	}
}
