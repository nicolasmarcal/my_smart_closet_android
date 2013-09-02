package com.example.mysmartcloset.Models;

public class Vestido extends PecaDeRoupa {
	private TipoRoupa tipoVestido;
	
	public Vestido(){
		super();
	}
	
	public TipoRoupa getTipoVestido() {
		return tipoVestido;
	}

	public void setTipoVestido(TipoRoupa tipoVestido) {
		this.tipoVestido = tipoVestido;
	}
	
}
