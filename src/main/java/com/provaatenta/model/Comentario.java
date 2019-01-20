package com.provaatenta.model;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.domain.EntityScan;



@Entity
public class Comentario {

	
	@Id
	private String ultimaUlt;
	
	
	private String comentarioUU;
	
	@ManyToOne
	private Sapato sapato;
	
	public Comentario() {}
	


	public Comentario(String ultimaUlt, String comentarioUU, Sapato sapato) {
		super();
		this.ultimaUlt = ultimaUlt;
		this.comentarioUU = comentarioUU;
		this.sapato = sapato;
	}



	public String getUltimaUlt() {
		return ultimaUlt;
	}

	public void setUltimaUlt(String ultimaUlt) {
		this.ultimaUlt = ultimaUlt;
	}

	public String getComentarioUU() {
		return comentarioUU;
	}

	public void setComentarioUU(String comentarioUU) {
		this.comentarioUU = comentarioUU;
	}

	public Sapato getSapato() {
		return sapato;
	}

	public void setSapato(Sapato sapato) {
		this.sapato = sapato;
	}

	
	
	
	
	
	
}
