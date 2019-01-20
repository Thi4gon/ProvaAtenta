package com.provaatenta.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sapato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nomeSapato;
	private String corSapato;
	private String marcaSapato;
	private String estiloSapato;
	private String dataCompra;
	private Double valorSapato;
	private String nomeLoja;
	
	@OneToMany( mappedBy="sapato", cascade=CascadeType.ALL, orphanRemoval=true) // para poder deletar em cascata também os comentarios que estão relacionados.
	private List<Comentario> comentarios;
	
	
	
public Sapato() {}



public Sapato(Long id, String nomeSapato, String corSapato, String marcaSapato, String estiloSapato, String dataCompra,
		String ultimaUlt, Double valorSapato, String nomeLoja, List<Comentario> comentarios) {
	super();
	this.id = id;
	this.nomeSapato = nomeSapato;
	this.corSapato = corSapato;
	this.marcaSapato = marcaSapato;
	this.estiloSapato = estiloSapato;
	this.dataCompra = dataCompra;
	
	this.valorSapato = valorSapato;
	this.nomeLoja = nomeLoja;
	this.comentarios = comentarios;
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getNomeSapato() {
	return nomeSapato;
}



public void setNomeSapato(String nomeSapato) {
	this.nomeSapato = nomeSapato;
}



public String getCorSapato() {
	return corSapato;
}



public void setCorSapato(String corSapato) {
	this.corSapato = corSapato;
}



public String getMarcaSapato() {
	return marcaSapato;
}



public void setMarcaSapato(String marcaSapato) {
	this.marcaSapato = marcaSapato;
}



public String getEstiloSapato() {
	return estiloSapato;
}



public void setEstiloSapato(String estiloSapato) {
	this.estiloSapato = estiloSapato;
}



public String getDataCompra() {
	return dataCompra;
}



public void setDataCompra(String dataCompra) {
	this.dataCompra = dataCompra;
}






public Double getValorSapato() {
	return valorSapato;
}



public void setValorSapato(Double valorSapato) {
	this.valorSapato = valorSapato;
}



public String getNomeLoja() {
	return nomeLoja;
}



public void setNomeLoja(String nomeLoja) {
	this.nomeLoja = nomeLoja;
}



public List<Comentario> getComentarios() {
	return comentarios;
}



public void setComentarios(List<Comentario> comentarios) {
	this.comentarios = comentarios;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}




}