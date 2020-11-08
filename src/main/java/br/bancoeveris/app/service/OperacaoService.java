package br.bancoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.repository.ContaRepository;
import br.bancoeveris.app.repository.OperacaoRepository;
import br.bancoeveris.app.spec.ContaList;

@Service
public class OperacaoService {

	final OperacaoRepository _repository;
	
	@Autowired
	ContaRepository contaRepository;
	
	// @Autowired
	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
	}

	// GET - OBTER POR UM POR HASH
		public ContaList obterSaldo(String hash){
			List<Conta> lista = contaRepository.findByHash(hash);
			
			ContaList response = new ContaList();
					
			if (lista.isEmpty()) { //checa se lista é vazia
				response.StatusCode = 400;
				response.Message = "Hash code não encontrado.";
				return response;
			}
					
			response.setContas(lista);
			response.StatusCode = 200;
			response.Message = "Hash obtido com sucesso.";
			return response;
		}
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
//	// POST - CRIAR
//	public void criar(Operacao operacao) {
//		operacao.setId(0L);
//		_repository.save(operacao);
//	}
//
//	// GET - OBTER SOMENTE UM
//	public Optional<Operacao> listar(Long id) {
//		return _repository.findById(id);
//	}
//
//	// PUT - ATUALIZAR
//	public void atualizar(Operacao operacao, Long id) {
//		operacao.setId(id);
//		_repository.save(operacao);
//	}
//}