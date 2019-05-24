package br.com.alexradavelli.javaeejsf.managedbean;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alexradavelli.javaeejsf.dto.PessoaDTO;
import br.com.alexradavelli.javaeejsf.service.PessoaService;

@Named
@RequestScoped
public class PessoaListMB {

	private final PessoaService pessoaService;
	
	private List<PessoaDTO> pessoas;

	@Inject
	public PessoaListMB(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostConstruct
	private void init() {
		listar();
	}
	
	public void listar() {
		pessoas = pessoaService.findAll()
				.stream()
				.map(PessoaDTO::parseDTO)
				.collect(Collectors.toList());
	}
	
	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}
	
}
