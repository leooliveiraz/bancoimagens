package rocha.bancoImagens.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Imagem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String imagem;
	
}
