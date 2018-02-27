package br.com.af.techcontrol.authorization.entity.base.validation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import br.com.af.techcontrol.authorization.entity.Pessoa;

public class PessoaGroupSequenceProvider implements DefaultGroupSequenceProvider<Pessoa> {

	@Override
	public List<Class<?>> getValidationGroups(Pessoa pessoa) {
		List<Class<?>> grupos = new ArrayList<>();
		grupos.add(Pessoa.class);

		if (isPessoaSelecionada(pessoa)) {
			grupos.add(pessoa.getTipoPessoa().getGrupo());
		}

		return grupos;
	}

	private boolean isPessoaSelecionada(Pessoa pessoa) {
		return pessoa != null && pessoa.getTipoPessoa() != null;
	}

}
