package br.edu.unidep.aulaspring.servicos;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.aulaspring.Pessoa;
import br.edu.unidep.aulaspring.repositorios.PessoaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PessoaServico {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	public List<Pessoa> listaPessoas() {
		return pessoaRepositorio.listaPessoas();
	}

	public Pessoa buscarPessoa(Integer id) {
		Optional<Pessoa> pessoa = pessoaRepositorio.findById(id);
		return pessoa.get();
	}

	public String deletarPessoaId(int id) {
		return pessoaRepositorio.deletarPessoaId(id);		
	}

}
