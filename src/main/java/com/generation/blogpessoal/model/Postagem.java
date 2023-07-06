package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagem {

	@Id // mostrar que ela é a chave primaria da tabela que será gerado no banco de
		// dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // aqui cria o auto_incremento (estratégia) do id da tabela
	private Long id;

	@NotBlank(message = "O atributo titulo é Obrigatório!") // funciona como o Not Null - noblank não aceita nem nulo e
															// nem vazio; o message é comentário
	@Size(min = 5, max = 100, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres") 
	private String titulo;

	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no minimo 10 e no máximo 1000 caracteres")
	private String texto;

	@UpdateTimestamp // anotação + configuração da variavel = será preenchida automático com o fuso - horário do sistema (data e hora)
	private LocalDateTime data;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	@ManyToOne
	@JsonIgnoreProperties("postagem") //ignorar o looping na busca da postagem em relação aquele tema da busca
	private Tema tema;
	
		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
}
