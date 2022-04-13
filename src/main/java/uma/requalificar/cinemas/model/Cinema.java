package uma.requalificar.cinemas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Cinema")
public class Cinema
{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;

	private String nome;
		
	private String morada;
	
	private String imagem;
	
	
	@OneToMany (mappedBy = "cinema")
	private List<Filme> filmes;

	
	/**
	 * @return the nome
	 */
	public String getNome ()
	{
		return nome;
	}

	
	/**
	 * @param nome the nome to set
	 */
	public void setNome (String nome)
	{
		this.nome = nome;
	}

	
	/**
	 * @return the morada
	 */
	public String getMorada ()
	{
		return morada;
	}

	
	/**
	 * @param morada the morada to set
	 */
	public void setMorada (String morada)
	{
		this.morada = morada;
	}

	
	/**
	 * @return the id
	 */
	public Long getId ()
	{
		return id;
	}

	
	/**
	 * @return the filmes
	 */
	public List<Filme> getFilmes ()
	{
		return filmes;
	}

	
	/**
	 * @param filmes the filmes to set
	 */
	public void setFilmes (List<Filme> filmes)
	{
		this.filmes = filmes;
	}


	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}


	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	
}
