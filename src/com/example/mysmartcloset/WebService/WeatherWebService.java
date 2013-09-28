package com.example.mysmartcloset.WebService;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;

public class WeatherWebService {
	private final static String URL = "http://api.openweathermap.org/data/2.5/weather?";
	
	public static float getWeather(double latitude, double longitude){
		float temperatura = 0;
		try{
			HttpGet uri = new HttpGet(URL + "lat=" + latitude + "&lon=" + longitude);

			DefaultHttpClient client = new DefaultHttpClient();
			HttpResponse resp = client.execute(uri);
			
			if(resp.getStatusLine().getStatusCode() == 200){
				String result = EntityUtils.toString(resp.getEntity());
				JSONObject jObj = new JSONObject(result);
				JSONObject mainObj = getObject("main", jObj);
				temperatura = getFloat("temp", mainObj) - 273;
			}
		} catch(Exception e){
			temperatura = 3;;
		}

		return temperatura;
	}
	
	private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
	    JSONObject subObj = jObj.getJSONObject(tagName);
	    return subObj;
	}
	
	private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
	    return (float) jObj.getDouble(tagName);
	}
}
