package br.com.alexradavelli.javaeejsf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alexradavelli.javaeejsf.entity.PessoaEntity;
import br.com.alexradavelli.javaeejsf.repository.PessoaRepository;
import br.com.alexradavelli.javaeejsf.service.PessoaService;

@Stateless
public class PessoaServiceImpl implements PessoaService {

	private final PessoaRepository repository;

	@Inject
	public PessoaServiceImpl(PessoaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Optional<PessoaEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<PessoaEntity> findAll() {
		return repository.findAll()
				.stream()
				.collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public PessoaEntity insert(PessoaEntity pessoaEntity) {
		return repository.insert(pessoaEntity);
	}

	@Override
	public PessoaEntity update(PessoaEntity pessoaEntity) {
		return repository.update(pessoaEntity);
	}

	@Override
	public void remove(PessoaEntity pessoaEntity) {
		repository.remove(pessoaEntity);
	}

}
