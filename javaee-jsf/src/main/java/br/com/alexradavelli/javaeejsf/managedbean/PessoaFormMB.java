package br.com.alexradavelli.javaeejsf.managedbean;

import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alexradavelli.javaeejsf.dto.PessoaDTO;
import br.com.alexradavelli.javaeejsf.service.PessoaService;

@Named
@RequestScoped
public class PessoaFormMB extends AbstractMB {

	private final PessoaService pessoaService;
	
	private PessoaDTO pessoa;

	@Inject
	public PessoaFormMB(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	@PostConstruct
	private void init() {
		if (isUpdate()) {
			loadToUpdate();
		} else {
			createToInsert();
		}
	}

	private void loadToUpdate() {
		pessoa = pessoaService.findById(pessoa.getId())
				.map(PessoaDTO::parseDTO)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrada para alteração"));
	}

	private void createToInsert() {
		pessoa = PessoaDTO.create();
	}

	private boolean isUpdate() {
		return Objects.nonNull(pessoa) && Objects.nonNull(pessoa.getId());
	}
	
	public void insert() {
		pessoaService.insert(pessoa.toEntity());
		createToInsert();
		addInfoMessage("Pessoa salva com sucesso!");
	}
	
	public void update() {
		pessoa = PessoaDTO.parseDTO(pessoaService.update(pessoa.toEntity()));
	}
	
	public void remove() {
		pessoaService.remove(pessoa.toEntity());
	}
	
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
}
