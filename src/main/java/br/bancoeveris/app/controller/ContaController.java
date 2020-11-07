package br.bancoeveris.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.service.ContaService;
import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.spec.ContaSpec;
import br.bancoeveris.app.spec.ContaList;

@RestController
@RequestMapping("/contas")
public class ContaController extends BaseController {

	// PROPRIEDADES
	private final ContaService _service;

	// CONSTRUTOR
	public ContaController(ContaService service) {
		_service = service;
	}

	// POST - CRIAR
	@PostMapping
	public ResponseEntity inserir(@RequestBody ContaSpec contaSpec) {
		try {
			BaseResponse response = _service.inserir(contaSpec);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	// GET - OBTER POR UM HASH
	@GetMapping(path = "/{hash}")
	public ResponseEntity listar(@PathVariable String hash) {
		List<Conta> contas = _service.listar(hash);
		return ResponseEntity.status(HttpStatus.OK).body(contas);

	}

	// GET - OBTER TUDO
	@GetMapping
	public ResponseEntity listar() {
		try {
			ContaList contas = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(contas);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
	
	
	// ------------------------------------------------------------------------------
	//CAMPO DE TESTE
	
	// PUT - ATUALIZAR POR HASH
	
	
	//CAMPO DE TESTE
	// ------------------------------------------------------------------------------

	
	
	
	
	
	
	
	
	// // GET - OBTER UM POR ID
//	@GetMapping(path = "/{id}")
//    public ResponseEntity obter(@PathVariable Long id) {		
//		try {
//			Conta response = _service.obter(id);
//			return ResponseEntity.status(response.StatusCode).body(response);	
//		} catch (Exception e) {
//			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
//		}   	
//    }
//	

	// PUT - ATUALIZAR

	// DELETE - DELETAR

}