package br.com.alexradavelli.javaeejsf.repository.impl;

import br.com.alexradavelli.javaeejsf.entity.PessoaEntity;
import br.com.alexradavelli.javaeejsf.repository.PessoaRepository;

public class PessoaRepositoryImpl extends JPARepositoryImpl<PessoaEntity, Long> implements PessoaRepository {

	@Override
	protected Class<PessoaEntity> getClassType() {
		return PessoaEntity.class;
	}
	
}
