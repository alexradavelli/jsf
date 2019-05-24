package br.com.alexradavelli.javaeejsf.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.alexradavelli.javaeejsf.entity.PessoaEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4299552912132446794L;
	
	private Long id;
	private String name;
	private String cpf;
	private Date birthday;
	
	public PessoaEntity toEntity() {
		return PessoaEntity.builder()
				.id(id)
				.name(name)
				.cpf(cpf)
				.birthday(new Date()) // TODO ajustar
				.build();
	}
	
	public static PessoaDTO create() {
		return PessoaDTO.builder().build();
	}
	
	public static PessoaDTO parseDTO(PessoaEntity entity) {
		return PessoaDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.cpf(entity.getCpf())
				.birthday(entity.getBirthday())
				.build();
	}
	
}
