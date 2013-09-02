package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.mysmartcloset.Models.Estilo;
import android.content.Context;
import android.database.Cursor;

public class EstiloDAO extends DAO{
	
	private static final String TABELA = "estilo";
	private static final String[] COLS = {"id", "descricao"};

	public EstiloDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static Estilo consultar(long id){
		Cursor c = db.query(TABELA, COLS, "id = ?", new String[] { id+"" }, null, null, null, null );
		Estilo estilo = new Estilo();
		if(c.moveToFirst()){
			do{
				estilo.setId(c.getLong(0));
				estilo.setDescricao(c.getString(1));
			}while(c.moveToNext());
			return estilo;
		} else {
			return null;
		}
		
	}
	
	public static long idEstilo(String descricao){
		Cursor c = db.query(TABELA, COLS, "descricao = ?", new String[] { descricao }, null, null, null, null );
		if(c.moveToFirst()){
			do{
				return c.getLong(0);
			}while(c.moveToNext());
		} else {
			return -1;
		}
	}

	public static String[] labelEstilos() {
		List<Estilo> estilos = todosEstilos();
		String[] labels = new String[estilos.size()];
		for(int i = 0; i<estilos.size(); i++){
			labels[i] = estilos.get(i).getDescricao();
		}
		return labels;
	}
	
	public static List<Estilo> todosEstilos(){
		List<Estilo> estilos = new ArrayList<Estilo>();
		Cursor c = db.query(TABELA, COLS, null, null, null, null, null, null );
		if(c.moveToFirst()){
			do{
				Estilo estilo = new Estilo();
				estilo.setId(c.getLong(0));
				estilo.setDescricao(c.getString(1));
				estilos.add(estilo);
			}while(c.moveToNext());
		}
		return estilos;
	}
}
