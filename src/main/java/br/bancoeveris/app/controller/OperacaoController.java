package br.bancoeveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.service.OperacaoService;
import br.bancoeveris.app.spec.OperacaoSpec;
import br.bancoeveris.app.spec.TransferenciaSpec;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController extends BaseController {

	// PROPRIEDADES
	private final OperacaoService _service;

	// CONSTRUTOR
	public OperacaoController(OperacaoService service) {
		_service = service;
	}

	// POST - FAZ DEPOSITO E SAQUE
	@PostMapping(path = "/depositoSaque")
	public ResponseEntity criar(@RequestBody OperacaoSpec operacaoSpec) {
		try {
			BaseResponse response = _service.criar(operacaoSpec);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	// POST - FAZ TRANSFERENCIA
	@PostMapping(path = "/transferencia")
	public ResponseEntity transferencia(@RequestBody TransferenciaSpec transferenciaSpec) {
		try {
			BaseResponse response = _service.transferencia(transferenciaSpec);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
}