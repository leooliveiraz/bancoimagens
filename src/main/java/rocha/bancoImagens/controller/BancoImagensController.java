package rocha.bancoImagens.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import rocha.bancoImagens.entidades.Imagem;
import rocha.bancoImagens.service.ImagemService;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_APPLICATION)
public class BancoImagensController {
	@Autowired
	ImagemService imagemService;
	
	private List<Imagem> imagens = new ArrayList<Imagem>();
	
	
	@PostConstruct
	public void init() {
		imagens = imagemService.listar();
		if(imagens == null) {
			imagens = new ArrayList<Imagem>();
		}
		System.out.println("Iniciado Lista.");
	}
	
	public List<Imagem> getImagens(){
		return imagens;
	}
}
