package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.mysmartcloset.Models.TipoRoupa;

import android.content.Context;
import android.database.Cursor;

public class TipoRoupaDAO extends DAO{
	
	private static final String TABELA = "tipo_roupa";
	private static final String[] COLS = {"id", "descricao", "tipo_roupa"};
	
	public TipoRoupaDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static List<TipoRoupa> tiposRoupaDoTipo(String tipoRoupa){
		Cursor c = db.query(TABELA, COLS, "tipo_roupa = ?", new String[] { tipoRoupa }, null, null, null, null);
		List<TipoRoupa> tiposRoupa = new ArrayList<TipoRoupa>();
		if(c.moveToFirst()){
			do{
				TipoRoupa tipo_roupa = new TipoRoupa();
				tipo_roupa.setId(c.getLong(0));
				tipo_roupa.setDescricao(c.getString(1));
				tipo_roupa.setTipoRoupa(c.getString(2));
				
				tiposRoupa.add(tipo_roupa);
			} while(c.moveToNext());
		}
		return tiposRoupa;
	}
	
}
