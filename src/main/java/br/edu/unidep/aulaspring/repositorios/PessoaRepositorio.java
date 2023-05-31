package br.edu.unidep.aulaspring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.unidep.aulaspring.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{
	
	@Query(value = "select * from LISTA_PESSOAS();", nativeQuery = true)
	List<Pessoa> listaPessoas();

	@Procedure(name = "Pessoa.deletePessoaId")
	String deletarPessoaId (@Param("id") Integer id); 
	

		
}
