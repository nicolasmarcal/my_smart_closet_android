package com.example.mysmartcloset;

import com.example.mysmartcloset.Models.PecaDeRoupa;
import com.example.mysmartcloset.dao.EstiloDAO;
import com.example.mysmartcloset.dao.MarcaDAO;
import com.example.mysmartcloset.dao.MaterialDAO;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CadastroRoupaActivity extends Activity {
	private Spinner tipos_roupa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro_roupa);
		carregaEstilosRoupa();
		carregaMarcasRoupa();
		carregaMateriaisRoupa();
		carregaTiposRoupa();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro_roupa, menu);
		return true;
	}
	
	public void carregaEstilosRoupa(){
		Spinner estilos_roupa = (Spinner) findViewById(R.id.estilo_roupa);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, EstiloDAO.labelEstilos());
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		estilos_roupa.setAdapter(dataAdapter);
		estilos_roupa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

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
	
	public void carregaMarcasRoupa(){
		Spinner marcas = (Spinner) findViewById(R.id.marca_roupa);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, MarcaDAO.labelMarcas());
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		marcas.setAdapter(dataAdapter);
		marcas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void carregaMateriaisRoupa(){
		Spinner materiais = (Spinner) findViewById(R.id.material_roupa);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, MaterialDAO.labelMateriais());
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		materiais.setAdapter(dataAdapter);
		materiais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void carregaTiposRoupa(){
		tipos_roupa = (Spinner) findViewById(R.id.tipo_roupa);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, PecaDeRoupa.TIPOS_ROUPA_LABEL);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		tipos_roupa.setAdapter(dataAdapter);
		tipos_roupa.setPrompt("Selecione");
		tipos_roupa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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
	
	

}
