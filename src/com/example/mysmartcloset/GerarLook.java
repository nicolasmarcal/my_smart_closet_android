package com.example.mysmartcloset;

import com.example.mysmartcloset.WebService.WeatherWebService;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GerarLook extends Activity {
	private long ocasiao_id;
	private boolean vestido = false;
	private float temperatura;
	private AlertDialog.Builder builder;
	private AlertDialog alertDialog;
	private AlertDialog alerta;
	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gerar_look);
		getOcasiao();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gerar_look, menu);
		return true;
	}
	
	public void getOcasiao(){
		final int[] ocasiao_ids = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		String[] ocasioes = {"Selecione","Formal Evento", "Formal Trabalho", "Formal Entrevista de Emprego", "Casual Trabalho", "Casual Passeio", "Casual Trabalho", "Casual Balada", "Casual Reunião em Família", "Esporte", "Despojado"};
		ArrayAdapter<String> adp = new ArrayAdapter<String>(GerarLook.this,
	            android.R.layout.simple_spinner_dropdown_item, ocasioes);
		
		Spinner combo_ocasioes = new Spinner(GerarLook.this);
		combo_ocasioes.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		combo_ocasioes.setAdapter(adp);
		combo_ocasioes.setPrompt("Para qual ocasião você vai?");
		combo_ocasioes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
				ocasiao_id = ocasiao_ids[position];
				if(position != 0){
					alertDialog.cancel();
					isVestido();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		builder = new AlertDialog.Builder(GerarLook.this);
		builder.setView(combo_ocasioes);
		builder.setMessage("Para onde você vai?");
		alertDialog = builder.create();
		alertDialog.show();
	}
	
	public void isVestido(){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Gostaria de usar vestido hoje?");
		builder.setCancelable(false);
		builder.setPositiveButton("Sim", new OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				vestido = true;
				gerarLook();
			}
		});
		builder.setNegativeButton("Não", new OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				vestido = false;
				gerarLook();
			}
		});
		alerta = builder.create();
		alerta.show();
	}
	
	public void gerarLook(){
		showProgressDialog();
		getTemperatura();
		getLook();
	}
	
	public void getLook(){
		
	}
	
	public void showProgressDialog(){
		progressDialog = new ProgressDialog(this);
		progressDialog.setTitle("Gerando Look");
		progressDialog.setMessage("Gerando Look. Por favor, aguarde...");
		progressDialog.setIndeterminate(true);
		progressDialog.setCancelable(false);
		progressDialog.show();
	}
	
	private void getTemperatura(){
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		if(location!=null){
			double longitude = location.getLongitude();
			double latitude = location.getLatitude();
			temperatura = WeatherWebService.getWeather(latitude, longitude);
			Toast.makeText(getApplicationContext(), "Temperatura:" + temperatura, Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(getApplicationContext(), "Não foi possível obter sua localização.", Toast.LENGTH_LONG).show();
		}
	}
	
	

}
