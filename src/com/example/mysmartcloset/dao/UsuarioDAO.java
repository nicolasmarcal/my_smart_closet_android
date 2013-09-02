package com.example.mysmartcloset.dao;

import java.util.ArrayList;
import java.util.List;
import com.example.mysmartcloset.Models.Usuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UsuarioDAO extends DAO{

	private static final String TABELA = "usuario";
	private static final String[] COLS = {"id", "nome", "email", "senha", "dt_nasc", "altura", "peso", "olhos_cor_id", "cabelo_cor_id"};
	public UsuarioDAO(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public static boolean inserir(Usuario usuario){
		ContentValues values = new ContentValues();
//		TODO Format formatter = new SimpleDateFormat("yyyy-MM-dd");
//		String s = formatter.format(usuario.getDt_nasc());
		
		values.put(COLS[1], usuario.getNome());
		values.put(COLS[2], usuario.getEmail());
		values.put(COLS[3], usuario.getSenha());
		values.put(COLS[4], "1991-12-28");
		values.put(COLS[5], usuario.getAltura());
		values.put(COLS[6], usuario.getPeso());
		values.put(COLS[7], usuario.getCor_olhos().getDescricao());
		values.put(COLS[8], usuario.getCor_cabelo().getDescricao());
		
		return db.insert(TABELA, null, values) > 0;
	}
	
	public List<Usuario> listarUsuarios(){
		Cursor c = db.query(TABELA, COLS, null, null, null, null, null, null);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(c.moveToFirst()) {
			do{
				Usuario usuario = new Usuario();
				usuario.setId(c.getLong(0));
				usuario.setNome(c.getString(1));
				usuario.setEmail(c.getString(2));
				usuario.setSenha(c.getString(3));
				usuario.setDt_nasc(c.getString(4));
				usuario.setAltura(c.getFloat(5));
				usuario.setPeso(c.getFloat(6));
				usuarios.add(usuario);
			}while(c.moveToNext());
		}
		return usuarios;
	}
	
	public boolean temCadastrados(){
		return listarUsuarios().size() > 0;
	}
	
}
