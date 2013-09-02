package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.mysmartcloset.Models.Material;

import android.content.Context;
import android.database.Cursor;

public class MaterialDAO extends DAO{
	
	private static final String TABELA = "material";
	private static final String[] COLS = {"id", "descricao"};

	public MaterialDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static List<Material> todosMateriais(){
		List<Material> materiais = new ArrayList<Material>();
		Cursor c = db.query(TABELA, COLS, null, null, null, null, null, null );
		if(c.moveToFirst()){
			do{
				Material material = new Material();
				material.setId(c.getLong(0));
				material.setDescricao(c.getString(1));
				materiais.add(material);
			}while(c.moveToNext());
		}
		return materiais;
	}
	
	public static Material consultar(long id){
		Cursor c = db.query(TABELA, COLS, "id = ?", new String[] { id+"" }, null, null, null, null );
		Material material = new Material();
		if(c.moveToFirst()){
			do{
				material.setId(c.getLong(0));
				material.setDescricao(c.getString(1));
			}while(c.moveToNext());
			return material;
		} else {
			return null;
		}
		
	}
	
	public static String[] labelMateriais(){
		List<Material> materiais = todosMateriais();
		String[] labels = new String[materiais.size()];
		for(int i = 0; i<materiais.size(); i++){
			labels[i] = materiais.get(i).getDescricao();
		}
		return labels;
	}
	
	public static long[] idsMateriais(){
		List<Material> materiais = todosMateriais();
		long[] ids = new long[materiais.size()];
		for(int i = 0; i<materiais.size(); i++){
			ids[i] = materiais.get(i).getId();
		}
		return ids;
	}

}
