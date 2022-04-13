package uma.requalificar.cinemas.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Ator")
public class Ator
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private Date data_nascimento;

	private String email;

	private String telemovel;

	@JsonIgnore
	@ManyToMany(mappedBy = "atores")
	private List<Filme> filmes = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Date getData_nascimento()
	{
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento)
	{
		this.data_nascimento = data_nascimento;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTelemovel()
	{
		return telemovel;
	}

	public void setTelemovel(String telemovel)
	{
		this.telemovel = telemovel;
	}

	public List<Filme> getFilmes()
	{
		return filmes;
	}

	public void setFilmes(List<Filme> filmes)
	{
		this.filmes = filmes;
	}

}
