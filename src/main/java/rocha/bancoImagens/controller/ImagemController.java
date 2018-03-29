package rocha.bancoImagens.controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rocha.bancoImagens.entidades.Imagem;
import rocha.bancoImagens.service.ImagemService;

@RestController
@RequestMapping("/imagem")
public class ImagemController {
	@Autowired
	ImagemService imgService;
	@Autowired
	BancoImagensController bdController;

	@RequestMapping("/{id}")
	public String buscaImagem(@PathVariable Long id) {
		try {
			Imagem img = bdController.getImagens().stream()
	                .filter(i -> id.equals(i.getId()))
	                .findAny()
	                .orElse(null);			
			return img.getImagem();
		} catch (Exception e) {
			return "data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw";
		}
	}

	@RequestMapping(value="/salvar",method=RequestMethod.POST)
	public String salvarImagem(@RequestBody  String imagem) {
		try {
			imagem = URLDecoder.decode(imagem, "UTF-8");
			imagem = imagem.replaceAll(" ", "+");
			Imagem img =new Imagem();
			img.setImagem(imagem.toString());
			imgService.salvar(img);			
			if(img != null) {
				bdController.getImagens().add(img);
			}
			return img.getId().toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@RequestMapping("/excluir/{id}")
	public String excluirImagem(@PathVariable Long id) {
		try {
			Imagem img = bdController.getImagens().stream()
	                .filter(i -> id.equals(i.getId()))
	                .findAny()
	                .orElse(null);	
			imgService.deletar(img);
			bdController.getImagens().remove(img);			
			return img.getImagem()+" excluído";
		} catch (Exception e) {
			return "erro";
		}
	}
	

	
}
