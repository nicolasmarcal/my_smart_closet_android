package com.example.mysmartcloset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.mysmartcloset.Models.Cor;
import com.example.mysmartcloset.Models.Usuario;
import com.example.mysmartcloset.dao.CorDAO;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroUsuarioActivity extends Activity {

	protected static final int DATE_DIALOG_ID = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Cadastro Usuário");
		setContentView(R.layout.activity_cadastro_usuario);
		carregaSpinnerOlhos();
		carregaSpinnerCebelo();
		showDialogData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro_usuario, menu);
		return true;
	}
	
	public void carregaSpinnerOlhos(){
		Spinner cor_olhos = (Spinner) findViewById(R.id.cor_olhos_usuario);
		cor_olhos.setAdapter(carregaCores(Cor.COR_OLHOS));
		cor_olhos.setPrompt("Selecione");
		cor_olhos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void carregaSpinnerCebelo(){
		Spinner cor_olhos = (Spinner) findViewById(R.id.cor_cabelo_usuario);
		cor_olhos.setAdapter(carregaCores(Cor.COR_CABELO));
		cor_olhos.setPrompt("Selecione");
		cor_olhos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void cadastrarUsuario(View v){
		if(validaForm()){
			EditText nome = (EditText) findViewById(R.id.nome_usuario);
			EditText email = (EditText) findViewById(R.id.email_usuario);
			EditText senha = (EditText) findViewById(R.id.senha_usuario);
			EditText dataNasc = (EditText) findViewById(R.id.dt_nasc_usuario);
			EditText peso = (EditText) findViewById(R.id.peso_usuario);
			EditText altura = (EditText) findViewById(R.id.altura_usuario);
			Spinner cor_cabelo_id = (Spinner) findViewById(R.id.cor_cabelo_usuario);
			Spinner cor_olhos_id = (Spinner) findViewById(R.id.cor_olhos_usuario);
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome.getText().toString());
			usuario.setEmail(email.getText().toString());
			usuario.setSenha(senha.getText().toString());
			usuario.setDt_nasc(dataNasc.getText().toString());
			usuario.setPeso(Float.parseFloat(peso.getText().toString()));
			usuario.setAltura(Float.parseFloat(altura.getText().toString()));
			usuario.setCor_cabelo(CorDAO.coresDoTipo(Cor.COR_CABELO).get(cor_cabelo_id.getSelectedItemPosition()));
			usuario.setCor_olhos(CorDAO.coresDoTipo(Cor.COR_OLHOS).get(cor_olhos_id.getSelectedItemPosition()));
			
			if(usuario.cadastrar()){
				Intent it = new Intent(CadastroUsuarioActivity.this, MenuActivity.class);
				startActivity(it);
				finish();
			}
		}
	}
	
	public ArrayAdapter<String> carregaCores(String tipoCor){
		String[] cores = CorDAO.labelCores(tipoCor);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, cores);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		return dataAdapter;
	}
	
	public boolean validaForm(){
		EditText nome = (EditText) findViewById(R.id.nome_usuario);
		EditText email = (EditText) findViewById(R.id.email_usuario);
		EditText senha = (EditText) findViewById(R.id.senha_usuario);
		EditText dataNasc = (EditText) findViewById(R.id.dt_nasc_usuario);
		EditText peso = (EditText) findViewById(R.id.peso_usuario);
		EditText altura = (EditText) findViewById(R.id.altura_usuario);
		Pattern email_regex = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher confere_email = email_regex.matcher(email.getText().toString());
		if(nome.getText().toString().matches("")){
			Toast.makeText(this, "Nome obrigatório", Toast.LENGTH_LONG).show();
			nome.requestFocus();
			return false;
		}
		if(!confere_email.find()){
			Toast.makeText(this, "E-mail inválido", Toast.LENGTH_LONG).show();
			email.requestFocus();
			return false;
		}
		if(senha.getText().toString().matches("")){
			Toast.makeText(this, "Senha obrigatória", Toast.LENGTH_LONG).show();
			senha.requestFocus();
			return false;
		}
		if(dataNasc.getText().toString().matches("")){
			Toast.makeText(this, "Data de nascimento obrigatória", Toast.LENGTH_LONG).show();
			dataNasc.requestFocus();
			return false;
		}
		try {
			Double.parseDouble(peso.getText().toString());
		} catch(NumberFormatException e){
			Toast.makeText(this, "Peso obrigatório", Toast.LENGTH_LONG).show();
			peso.requestFocus();
			return false;
		}
		try {
			Double.parseDouble(altura.getText().toString());
		} catch(NumberFormatException e){
			Toast.makeText(this, "Altura obrigatória.", Toast.LENGTH_LONG).show();
			altura.requestFocus();
			return false;
		}
		return true;
	}
	
	public void showDialogData(){
		EditText dataNasc = (EditText) findViewById(R.id.dt_nasc_usuario);
		dataNasc.setOnClickListener(new View.OnClickListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog){
		((DatePickerDialog) dialog ).updateDate(2012, 1, 1);
	}
	
	@Override
	protected Dialog onCreateDialog(int id){
		return new DatePickerDialog(this, mDateListener, 2012, 1, 1);
	}
	
	private DatePickerDialog.OnDateSetListener mDateListener = new DatePickerDialog.OnDateSetListener(){
		public void onDateSet(DatePicker view, int ano, int mes, int dia){
			EditText dataNasc = (EditText) findViewById(R.id.dt_nasc_usuario);
			dataNasc.setText(new StringBuilder().append(dia).append("/").append(mes+1).append("/").append(ano));
		}
	};
	
}
