package com.example.mysmartcloset;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.example.mysmartcloset.dao.UsuarioDAO;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {
	private Button mButton;
	private AlertDialog alerta;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		mButton = (Button)findViewById(R.id.meu_closet_btn);
        registerForContextMenu(mButton);
        criaBanco();
        if(!temUsuario())
        	cadastroUsuario();
        else
        	Toast.makeText(this, "Bem Vindo!", Toast.LENGTH_LONG).show();
	}
	
	@Override
    public boolean onContextItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.submenu_closet_cadastrar:{
			Intent it = new Intent(MenuActivity.this, CadastroRoupaActivity.class);
			startActivity(it);
			break;
		}
		case R.id.submenu_closet_ver_todos:{
			
			break;
		}
		}
		return super.onContextItemSelected(item);
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu,View v, ContextMenuInfo menuInfo){
    	super.onCreateContextMenu(menu, v, menuInfo);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu_closet, menu);
    }
	
	public void abreSubMenuCloset(View v){
		openContextMenu(v);
	}
	
	public void criaBanco(){
		String destFile = Environment.getExternalStorageDirectory().toString().concat("/Android/data/mysmartcloset/database");
		File pasta = new File(destFile);
		if (!pasta.exists()){
			pasta.mkdirs();
			File DbFile = new File(Environment.getExternalStorageDirectory().toString().concat("/Android/data/mysmartcloset/database/msc.sqlite"));
    		try {
                DbFile.createNewFile();
                System.out.println("File Created successfully");
                InputStream is = getApplicationContext().getAssets().open("msc.sqlite");
                FileOutputStream fos = new FileOutputStream(DbFile);
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                System.out.println("File succesfully placed on sdcard");
                // Close the streams
                fos.flush();
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
	
	private boolean temUsuario(){
		UsuarioDAO u = new UsuarioDAO(this);
		return u.temCadastrados();
	}
	
	private void cadastroUsuario(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Aviso");
		builder.setMessage("Para utilizar o aplicativo é necessário cadastro. Se cadastrar agora?");
		builder.setCancelable(false);
		builder.setPositiveButton("Sim", new OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				Intent it = new Intent(MenuActivity.this, CadastroUsuarioActivity.class);
				startActivity(it);
				finish();
			}
		});
		builder.setNegativeButton("Não", new OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				finish();
			}
		});
		alerta = builder.create();
		alerta.show();
	}
}
