package br.edu.unidep.aulaspring.servicos;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unidep.aulaspring.entidades.Pessoa;
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
	
	public Pessoa buscarPessoaCpf(String cpf) {
		Pessoa pessoa = pessoaRepositorio.buscarPessoaCpf(cpf);
		return pessoa;
	}

	public String deletarPessoaId(int id) {
		return pessoaRepositorio.deletarPessoaId(id);		
	}
	
	public Pessoa inserirPessoa(Pessoa pessoa) {
		Pessoa p = new Pessoa();
		p.setId(pessoa.getId());
		p.setCpf(pessoa.getCpf());
		p.setEmail(pessoa.getEmail());
		p.setNome(pessoa.getNome());
		p.setIdade(pessoa.getIdade());
		p.setSexo(pessoa.getSexo());
		p.setTelefone(pessoa.getTelefone());
		
		return pessoaRepositorio.save(p);
				
	}

}
