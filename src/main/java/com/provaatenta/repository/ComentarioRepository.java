package com.provaatenta.repository;

import org.springframework.data.repository.CrudRepository;

import com.provaatenta.model.Comentario;
import com.provaatenta.model.Sapato;

public interface ComentarioRepository extends CrudRepository<Comentario, Long>{

	
	Iterable<Comentario> findBySapato(Sapato sapato);
	Comentario findByUltimaUlt(String ultimaUlt);
}
