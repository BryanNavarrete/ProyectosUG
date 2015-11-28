package com.lsi.business;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.lsi.model.Nota;
import com.lsi.model.Periodo;


public class Main {

	public List<Nota> obtenerNota(String codigo, String periodo){

		Client client=ClientBuilder.newBuilder().property("connection.timeout", 100).register(JacksonJsonProvider.class).build();

		ArrayList<Nota> notas=(ArrayList<Nota>)client.target("http://lisrestful.azurewebsites.net/api/notas?cod_estudiante="+codigo+"&cod_lectivo="+periodo+"")
				.request().accept("application/json")
				.get(new GenericType<List<Nota>>(){});

		//for(Nota obj:notas){
		//	System.out.println(obj);
		//}

		return notas;
	}

	public List<Periodo> obtenerPeriodo(){

		Client client=ClientBuilder.newBuilder().property("connection.timeout", 100).register(JacksonJsonProvider.class).build();

		ArrayList<Periodo> periodos=(ArrayList<Periodo >)client.target("http://lisrestful.azurewebsites.net/api/periodoLectivo")
				.request().accept("application/json")
				.get(new GenericType<List<Periodo>>(){});

		//for(Nota obj:notas){
		//	System.out.println(obj);
		//}

		return periodos;
	}
}
