package br.com.alexradavelli.javaeejsf.managedbean;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alexradavelli.javaeejsf.dto.PessoaDTO;
import br.com.alexradavelli.javaeejsf.service.PessoaService;

@Named
@ViewScoped
public class PessoaListMB extends AbstractMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7667436084402937529L;

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
	
	public void remove(PessoaDTO pessoa) {
		pessoaService.remove(pessoa.toEntity());
		listar();
		addInfoMessage("Pessoa excluída com sucesso!");
	}
	
	public List<PessoaDTO> getPessoas() {
		return pessoas;
	}
	
}
