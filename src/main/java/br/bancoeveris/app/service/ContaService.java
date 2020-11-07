package br.bancoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.repository.ContaRepository;
import br.bancoeveris.app.spec.ContaList;
import br.bancoeveris.app.spec.ContaSpec;
import br.bancoeveris.app.model.BaseResponse;

@Service
public class ContaService {

	final ContaRepository _repository;

	public ContaService(ContaRepository repository) {
		_repository = repository;
	}

	// POST - CRIAR
	public BaseResponse inserir(ContaSpec contaSpec) {
		Conta conta = new Conta();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (contaSpec.getHash() == "") {
			base.Message = "O Hash do cliente não foi preenchido.";
			return base;
		}

		if (contaSpec.getNome() == "") {
			base.Message = "O Nome do cliente não foi preenchido.";
			return base;
		}

		conta.setHash(contaSpec.getHash());
		conta.setNome(contaSpec.getNome());

		_repository.save(conta);
		base.StatusCode = 201;
		base.Message = "Conta inserida com sucesso.";
		return base;
	}

	// GET - OBTER POR UM POR HASH
	public List<Conta> listar(String hash){
		List<Conta> lista = _repository.findByHash(hash);
		return lista;
	}
	
	// GET - OBTER TUDO
	public ContaList listar() {

		List<Conta> lista = _repository.findAll();

		ContaList response = new ContaList();
		response.setContas(lista);
		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso.";

		return response;
	}

	
	
	
	
	
	
	//------------------------------------------------------------------------------
	//CAMPO DE TESTE
	
	// PUT - ATUALIZAR POR HASH
	
	
	//CAMPO DE TESTE
	//------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
//	// GET - OBTER UM POR ID
//	public Conta obter(Long id) {
//		Optional<Conta> conta = _repository.findById(id);
//		Conta response = new Conta();
//
//		if (conta == null) {
//			response.Message = "Conta não encontrada";
//			response.StatusCode = 404;
//			return response;
//		}
//
//		response.Message = "Conta obtida com sucesso";
//		response.StatusCode = 200;
//
//		response.setId(id);
//		response.setNome(conta.get().getNome());
//		response.setHash(conta.get().getHash());
//		return response;
//	}
//


	

	// DELETE - DELETAR
}
