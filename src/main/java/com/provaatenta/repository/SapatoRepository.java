package com.provaatenta.repository;

import org.springframework.data.repository.CrudRepository;

import com.provaatenta.model.Sapato;

public interface SapatoRepository  extends CrudRepository<Sapato, Long> {

	Iterable<Sapato> findBycorSapato(String corSapato);
	Iterable<Sapato> findBymarcaSapato(String marcaSapato);
	Iterable<Sapato> findByestiloSapato(String estiloSapato);
}
