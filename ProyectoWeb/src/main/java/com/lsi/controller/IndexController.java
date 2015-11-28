package com.lsi.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.lsi.business.Main;
import com.lsi.model.Nota;
import com.lsi.model.Periodo;

@ManagedBean(name="indexController")
@RequestScoped
public class IndexController implements Serializable{
	private static final long serialVersionUID = 1L;
	private Nota nota;
	private Periodo periodo;
	private List<Periodo> listPeriodos;
	private List<Nota> listNotas;

	public IndexController() {
		this.nota = new Nota();
		this.periodo = new Periodo();
		Main main = new Main();		
		this.listPeriodos = new ArrayList<Periodo>();
		this.listPeriodos = main.obtenerPeriodo();
	}

	public void buscar(){		
		Main main = new Main();
		this.listNotas = new ArrayList<Nota>();
		this.listNotas = main.obtenerNota(nota.getCod_estudiante(), periodo.getCod_periodo());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bienvenido al sistema Web hecho en PrimeFaces"));		
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Periodo> getListPeriodos() {
		return listPeriodos;
	}

	public void setListPeriodos(List<Periodo> listPeriodos) {
		this.listPeriodos = listPeriodos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Nota> getListNotas() {
		return listNotas;
	}

	public void setListNotas(List<Nota> listNotas) {
		this.listNotas = listNotas;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

}
