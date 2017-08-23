package com.odev.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;
import com.odev.entity.Department;

public class Util {

	public static String getRestGetMethod(String stURL){
		String sonuc="";
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(stURL);
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				sonuc = sonuc + line ;
			    //System.out.println(line);
			}		
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sonuc;
	}  // end of public static String getRestGetMethod(String stURL){
	
	public static String getRestPostMethod(String stURL){
		String sonuc = "";
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(stURL);
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				sonuc = sonuc + line;
				//System.out.println(line);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sonuc;
	}  // end of public static String getRestPostMethod(String stURL){

	public static String Object2JSon(Object obj) throws Exception
	{
		Gson gs = new Gson();
		String js = gs.toJson(obj);
		return js;		
	}

	public static Object JSon2Object(Object o, String js) throws Exception
	{
		Gson gs = new Gson();
		Object obj = o.getClass().newInstance();
		obj = gs.fromJson(js, obj.getClass());
		return obj;	
	}

	public static Department JSon2Department(String js) throws Exception
	{
		Gson gs = new Gson();
		Object obj = gs.fromJson(js, Department.class);
		return (Department) obj;	
	}	
	
	
}
