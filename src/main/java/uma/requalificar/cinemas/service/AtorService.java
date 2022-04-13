package uma.requalificar.cinemas.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.cinemas.dto.ListaResposta;
import uma.requalificar.cinemas.model.Filme;
import uma.requalificar.cinemas.model.Ator;
import uma.requalificar.cinemas.repository.FilmeRepository;
import uma.requalificar.cinemas.utils.Utils;
import uma.requalificar.cinemas.repository.AtorRepository;

@Service
public class AtorService
{
	private final AtorRepository atorRepository;
	private final FilmeRepository filmeRepository;

	@Autowired
	public AtorService(AtorRepository atorRepository, FilmeRepository filmeRepository)
	{
		this.atorRepository = atorRepository;
		this.filmeRepository = filmeRepository;
	}

	public List<Ator> getAtors()
	{
		List<Ator> ators = new ArrayList<>();
		atorRepository.findAll().forEach(ators::add);

		return ators;
	}

	public List<Ator> getAtoresByFilme(String filme_id)
	{

		return filmeRepository.findById(Long.parseLong(filme_id)).get().getAtores();

	}

	public ListaResposta addAtor(Ator ator)
	{
		ListaResposta listaResposta = new ListaResposta();

		// Filme filme = filmeRepository.findById(Long.parseLong(filme_id)).get();
		// ator.setFilme(filme);

		if (ator.getEmail().isBlank())
		{
			listaResposta.addMsg("Email não preenchido.");
			return listaResposta;
		}
		
		if (ator.getTelemovel().isBlank())
		{
			listaResposta.addMsg("Telemovel não preenchido.");
			return listaResposta;
		}

		if (!Utils.validateEmail(ator.getEmail())) {
			listaResposta.addMsg("Email inválido.");
			return listaResposta;
		}
		
		//Teste data nascimento
				LocalDate dataMaxima = LocalDate.now();

				LocalDate dataMinima = dataMaxima.minusYears(120);

				if (dataMinima.compareTo(ator.getData_nascimento().toLocalDate()) > 0
						|| dataMaxima.compareTo(ator.getData_nascimento().toLocalDate()) <= 0) {
					listaResposta.addMsg("Data de nascimento inválida.");
					return listaResposta;
				}

		
		atorRepository.save(ator);
		listaResposta.setNewID(ator.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	public ListaResposta removeAtor(String id)
	{
		ListaResposta listaResposta = new ListaResposta();
		try
		{
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || atorRepository.findById(id_long).isEmpty())
			{
				listaResposta.addMsg("ID de ator inexistente ou fora de formato.");
				return (listaResposta);
			}

			atorRepository.delete(atorRepository.findById(id_long).get());
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} catch (Exception e)
		{
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

}
