package br.edu.unidep.aulaspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.util.JSONPObject;

import br.edu.unidep.aulaspring.entidades.Pessoa;
import br.edu.unidep.aulaspring.servicos.PessoaServico;

@Controller
@RequestMapping("/clientes")
public class PessoaController {
	@Autowired
	private PessoaServico pessoaServico;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listaPessoas(){
		List<Pessoa> pessoas = pessoaServico.listaPessoas();
		return ResponseEntity.ok().body(pessoas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> buscarPessoa(@PathVariable("id") Integer id) {
		Pessoa pessoa = pessoaServico.buscarPessoa(id);
		return ResponseEntity.ok().body(pessoa);
	}
	@GetMapping(value = "/buscarPessoaCpf/{cpf}")
	public ResponseEntity<Pessoa> buscarPessoaCpf(@PathVariable("cpf") String cpf) {
		Pessoa pessoa = pessoaServico.buscarPessoaCpf(cpf);
		return ResponseEntity.ok().body(pessoa);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarPessoaId(@PathVariable("id") Integer id) {
		String pessoa = pessoaServico.deletarPessoaId(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> inserirPessoa(@RequestBody Pessoa pessoa){
		Pessoa p = pessoaServico.inserirPessoa(pessoa);
		return ResponseEntity.ok().body(p);
	}
	
	
}
