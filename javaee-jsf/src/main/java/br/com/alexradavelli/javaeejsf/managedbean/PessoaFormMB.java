package br.com.alexradavelli.javaeejsf.managedbean;

import java.util.Objects;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alexradavelli.javaeejsf.dto.PessoaDTO;
import br.com.alexradavelli.javaeejsf.service.PessoaService;

@Named
@ViewScoped
public class PessoaFormMB extends AbstractMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1881914658287676575L;

	private final PessoaService pessoaService;
	
	private Long id;
	private PessoaDTO pessoa;

	@Inject
	public PessoaFormMB(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	public void init() {
		if (FacesContext.getCurrentInstance().isPostback()) {
			return;
		}
		if (Objects.isNull(id)) {
			createToInsert();
		} else {
			prepareToUpdate();
		}
	}
	
	private void prepareToUpdate() {
		pessoa = pessoaService.findById(id)
				.map(PessoaDTO::parseDTO)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrada para alteração"));
	}

	private void createToInsert() {
		pessoa = PessoaDTO.create();
	}

	public void save() {
		pessoaService.save(pessoa.toEntity());
		addInfoMessage("Pessoa salva com sucesso!");
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	
}
