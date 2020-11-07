package br.bancoeveris.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.bancoeveris.app.model.Operacao;
import br.bancoeveris.app.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController extends BaseController {

	// PROPRIEDADES
	private final OperacaoService _service;

	// CONSTRUTOR
	public OperacaoController(OperacaoService service) {
		_service = service;
	}

	// ATUALIZAR UM
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Operacao operacao, @PathVariable Long id) {
		try {
			_service.atualizar(operacao, id);
			return ResponseEntity.status(HttpStatus.OK).body("Operacao atualizada com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("!ERRO! CONTATE O ADMINISTRADOR");
		}
	}
}
