package com.odev.util;

import com.google.gson.Gson;
import com.odev.entity.Department;

public class Util {
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
