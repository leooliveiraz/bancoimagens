package rocha.bancoImagens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rocha.bancoImagens.dao.ImagemDAO;
import rocha.bancoImagens.entidades.Imagem;

@Service
public class ImagemService {
	@Autowired
	ImagemDAO dao;

	public void salvar(Imagem imagem) {
		dao.save(imagem);
	}

	public void deletar(Imagem imagem) {
		dao.delete(imagem);
	}

	public Imagem buscar(Long id) {
		Imagem img = dao.findById(id);
		return img;
	}
	public List<Imagem> listar() {
		List<Imagem> lista = dao.findAll();	
		return lista;
	}
}
