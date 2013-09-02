package com.example.mysmartcloset.Models;

public class Calca extends PecaDeRoupa {
	private TipoRoupa tipoCalca;
	
	private Calca(){
		super();
	}

	public TipoRoupa getCorte() {
		return tipoCalca;
	}

	public void setCorte(TipoRoupa tipoCalca) {
		this.tipoCalca = tipoCalca;
	}
}
