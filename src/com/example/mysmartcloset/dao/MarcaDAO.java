package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.mysmartcloset.Models.Marca;
import android.content.Context;
import android.database.Cursor;

public class MarcaDAO extends DAO {
	
	private static final String TABELA = "marca";
	private static final String[] COLS = {"id", "descricao"};

	public MarcaDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static List<Marca> todasMarcas(){
		List<Marca> marcas = new ArrayList<Marca>();
		Cursor c = db.query(TABELA, COLS, null, null, null, null, null, null );
		if(c.moveToFirst()){
			do{
				Marca marca = new Marca();
				marca.setId(c.getLong(0));
				marca.setDescricao(c.getString(1));
				marcas.add(marca);
			}while(c.moveToNext());
		}
		return marcas;
	}
	
	public static Marca consultar(long id){
		Cursor c = db.query(TABELA, COLS, "id = ?", new String[] { id+"" }, null, null, null, null );
		Marca marca = new Marca();
		if(c.moveToFirst()){
			do{
				marca.setId(c.getLong(0));
				marca.setDescricao(c.getString(1));
			}while(c.moveToNext());
			return marca;
		} else {
			return null;
		}
		
	}
	
	public static String[] labelMarcas(){
		List<Marca> marcas = todasMarcas();
		String[] labels = new String[marcas.size()];
		for(int i = 0; i<marcas.size(); i++){
			labels[i] = marcas.get(i).getDescricao();
		}
		return labels;
	}
	
	public static long[] idsMarcas(){
		List<Marca> marcas = todasMarcas();
		long[] ids = new long[marcas.size()];
		for(int i = 0; i<marcas.size(); i++){
			ids[i] = marcas.get(i).getId();
		}
		return ids;
	}

}
