package br.edu.unidep.aulaspring.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unidep.aulaspring.entidades.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{
	
	//Chama a funcão LISTA_PESSOAS(); no SQL
	@Query(value = "select * from LISTA_PESSOAS();", nativeQuery = true)
	List<Pessoa> listaPessoas();

	
	//Chama a Procedure para realizar a exclusão de uma pessoa passando ID e retorna String se sucesso ou não encontrado
	@Procedure(name = "Pessoa.deletePessoaId")
	String deletarPessoaId (@Param("id") Integer id);

	//Realiza um select passando CPF
	@Query(value = "select * from tb_pessoa p where p.cpf = :cpf", nativeQuery = true)
	Pessoa buscarPessoaCpf(@Param("cpf") String cpf); 
	

		
}
