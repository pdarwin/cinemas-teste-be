package uma.requalificar.cinemas.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Filme")
public class Filme
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private Date data_lancamento;

	private String imagem;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cinema_id", nullable = false)
	private Cinema cinema;

	@ManyToMany
	@JoinTable(name = "Filme_Ator", joinColumns =
	{ @JoinColumn(name = "filme_id") }, inverseJoinColumns =
	{ @JoinColumn(name = "ator_id") })
	List<Ator> atores = new ArrayList<>();

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the cinema
	 */
	public Cinema getCinema()
	{
		return cinema;
	}

	/**
	 * @param cinema the cinema to set
	 */
	public void setCinema(Cinema cinema)
	{
		this.cinema = cinema;
	}

	/**
	 * @return the imagem
	 */
	public String getImagem()
	{
		return imagem;
	}

	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem)
	{
		this.imagem = imagem;
	}

	public Date getData_lancamento()
	{
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento)
	{
		this.data_lancamento = data_lancamento;
	}

	public List<Ator> getAtores()
	{
		return atores;
	}

	public void setAtores(List<Ator> atores)
	{
		this.atores = atores;
	}

}
