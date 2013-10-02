package com.example.mysmartcloset.WebService;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.example.mysmartcloset.dao.UsuarioDAO;

public class webService {
	public final static String URL = "http://192.168.1.108:3000/";
	
	public static JSONObject gerar_look(long ocasiao_id, float temperatura, boolean vestido){
		JSONObject obj = null;
		try {
			HttpGet uri = new HttpGet(URL + "api/v1/look/gerar_look/?email=" + UsuarioDAO.listarUsuarios().get(0).getEmail() +
					"&ocasiao_id="+ocasiao_id+"&temperatura="+temperatura+"&vestido="+vestido);
			
			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse resp = client.execute(uri);
			
			if(resp.getStatusLine().getStatusCode() == 200){
				String result = EntityUtils.toString(resp.getEntity());
				obj = new JSONObject(result);
			}
		}catch(Exception e){
			
		}
		return obj;
	}
}
