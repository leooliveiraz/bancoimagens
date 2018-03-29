package rocha.bancoImagens.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rocha.bancoImagens.entidades.Imagem;

@Repository
public interface  ImagemDAO extends CrudRepository<Imagem, Long> {	
	Imagem findById(Long id);
	List<Imagem> findAll();
}
