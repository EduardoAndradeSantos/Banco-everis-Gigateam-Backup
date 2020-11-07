package br.bancoeveris.app.service;

import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.repository.OperacaoRepository;

@Service
public class OperacaoService {

	final OperacaoRepository _repository;

	// @Autowired
	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
	}

	// POST - CRIAR
	public void criar(Operacao operacao) {
		operacao.setId(0L);
		_repository.save(operacao);
	}

	// GET - OBTER SOMENTE UM
	public Optional<Operacao> listar(Long id) {
		return _repository.findById(id);
	}

	// PUT - ATUALIZAR
	public void atualizar(Operacao operacao, Long id) {
		operacao.setId(id);
		_repository.save(operacao);
	}
}