package com.example.mysmartcloset.Models;

public class Casaco extends PecaDeRoupa {
	private TipoRoupa tipoCasaco;
	
	public Casaco(){
		super();
	}

	public TipoRoupa getTipoCasaco() {
		return tipoCasaco;
	}

	public void setTipoCasaco(TipoRoupa tipoCasaco) {
		this.tipoCasaco = tipoCasaco;
	}
	
}
