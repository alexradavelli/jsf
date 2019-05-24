package br.com.alexradavelli.javaeejsf.service;

import java.util.List;
import java.util.Optional;

import br.com.alexradavelli.javaeejsf.entity.PessoaEntity;

public interface PessoaService {
	
	Optional<PessoaEntity> findById(Long id);

	List<PessoaEntity> findAll();

	PessoaEntity insert(PessoaEntity pessoaEntity);
	 
	PessoaEntity update(PessoaEntity pessoaEntity);
 
    void remove(PessoaEntity pessoaEntity);

}
