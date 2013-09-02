package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.mysmartcloset.Models.Cor;

import android.content.Context;
import android.database.Cursor;

public class CorDAO extends DAO{
	
	private static final String TABELA = "cor";
	private static final String[] COLS = {"id", "descricao", "rgb", "tipo_cor"};
	
	public CorDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static List<Cor> coresDoTipo(String tipoCor){
		Cursor c = db.query(TABELA, COLS, "tipo_cor = ?", new String[] { tipoCor }, null, null, null, null);
		List<Cor> cores = new ArrayList<Cor>();
		if(c.moveToFirst()){
			do{
				Cor cor = new Cor();
				cor.setId(c.getLong(0));
				cor.setDescricao(c.getString(1));
				cor.setRgb(c.getString(2));
				cor.setTipo_cor(c.getString(3));
				cores.add(cor);
			} while(c.moveToNext());
		}
		return cores;
	}
	
	public static Cor consultar(long id){
		Cursor c = db.query(TABELA, COLS, "id = ?", new String[] { id+"" }, null, null, null, null );
		Cor cor = new Cor();
		if(c.moveToFirst()){
			do{
				cor.setId(c.getLong(0));
				cor.setDescricao(c.getString(1));
				cor.setRgb(c.getString(2));
				cor.setTipo_cor(c.getString(3));
			}while(c.moveToNext());
			return cor;
		} else {
			return null;
		}
		
	}
	
	public static String[] labelCores(String tipoCor){
		List<Cor> cores = coresDoTipo(tipoCor);
		String[] labels = new String[cores.size()];
		for(int i = 0; i<cores.size(); i++){
			labels[i] = cores.get(i).getDescricao();
		}
		return labels;
	}
	
	public static long[] idsCores(String tipoCor){
		List<Cor> cores = coresDoTipo(tipoCor);
		long[] ids = new long[cores.size()];
		for(int i = 0; i<cores.size(); i++){
			ids[i] = cores.get(i).getId();
		}
		return ids;
	}
	
}
