package br.bancoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.repository.ContaRepository;
import br.bancoeveris.app.repository.OperacaoRepository;
import br.bancoeveris.app.spec.ContaList;
import br.bancoeveris.app.spec.ContaSpec;
import br.bancoeveris.app.model.BaseResponse;

@Service
public class ContaService {

	final ContaRepository _repository;
	final OperacaoService _operacaoService;

	public ContaService(ContaRepository repository, OperacaoService operacaoService) {
		_repository = repository;
		_operacaoService = operacaoService;
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
	public ContaList listar(String hash){
		List<Conta> lista = _repository.findByHash(hash);
		
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
	
	// GET - OBTER TUDO
	public ContaList listar() {

		List<Conta> lista = _repository.findAll();

		ContaList response = new ContaList();
		response.setContas(lista);
		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso.";

		return response;
	}
	
	
	//SALDO
	public Conta Saldo(String hash) {
			
		Conta response = new Conta();
		response.StatusCode = 400;
		
		List<Conta> lista = _repository.findByHash(hash);
		
		if (lista.size() == 0) {
			response.Message = "Conta não encontrada!!";
			return response;
		}
			Double Saldo = _operacaoService.Saldo(lista.get(0).getId());
			response.Message = "Saldo de :"+ Saldo+ "R$";
			response.StatusCode=200;
			return response;
	}


	
	// PUT - ATUALIZAR POR HASH
	public BaseResponse atualizar(String hash,ContaSpec contaSpec) {
		
		BaseResponse response = new BaseResponse();
		Conta conta = new Conta();
		response.StatusCode = 400;
		
		if (hash == null || hash == "") {
			response.Message= "Hash não Inserido!!";
			return response;
		}
		if (contaSpec.getNome() == "") {			
			response.Message = "O nome do cliente não foi preenchido.";
			return response;
		}
		
		List<Conta> lista = _repository.findByHash(hash);
		
		conta = lista.get(0);
		conta.setNome(contaSpec.getNome());
		conta.setHash(contaSpec.getHash());
	
		_repository.save(conta);
		response.StatusCode = 200;
		response.Message = "Conta Atualizada com sucesso.";
		return response;	
	
	}

	// DELETE - DELETAR POR HASH
	public BaseResponse deletar(String hash) {
		BaseResponse response = new BaseResponse();
		
		if (hash == null || hash == "") {
			response.StatusCode = 400;
			return response;
		}
		
		List<Conta> lista = _repository.findByHash(hash);
		
		Conta conta = lista.get(0);
		_repository.deleteById(conta.getId());
		
		response.StatusCode = 200;
		response.Message = "Conta Excluida com sucesso!";
		return response;
	}
	
	
	
}
