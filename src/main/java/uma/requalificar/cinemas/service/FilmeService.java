package uma.requalificar.cinemas.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.cinemas.dto.ListaResposta;
import uma.requalificar.cinemas.model.Cinema;
import uma.requalificar.cinemas.model.Filme;
import uma.requalificar.cinemas.repository.AtorRepository;
import uma.requalificar.cinemas.repository.CinemaRepository;
import uma.requalificar.cinemas.repository.FilmeRepository;

@Service
public class FilmeService
{
	private final FilmeRepository filmeRepository;
	private final CinemaRepository cinemaRepository;
	private final AtorRepository atorRepository;

	@Autowired
	public FilmeService(FilmeRepository filmeRepository, CinemaRepository cinemaRepository,
			AtorRepository atorRepository)
	{
		this.filmeRepository = filmeRepository;
		this.cinemaRepository = cinemaRepository;
		this.atorRepository = atorRepository;
	}

	public List<Filme> getFilmes()
	{
		List<Filme> filmes = new ArrayList<>();
		filmeRepository.findAll().forEach(filmes::add);

		return filmes;
	}

	public List<Filme> getFilmesByCinema(String cinema_id)
	{

		return cinemaRepository.findById(Long.parseLong(cinema_id)).get().getFilmes();

	}

	public List<Filme> getFilmesByAtor(String ator_id)
	{

		return atorRepository.findById(Long.parseLong(ator_id)).get().getFilmes();

	}

	public ListaResposta addFilme(Filme filme, String cinema_id)
	{
		ListaResposta listaResposta = new ListaResposta();

		if (filme.getNome().isBlank())
		{
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}

		if ((filmeRepository.findByNome(filme.getNome()).size() > 0))
		{
			listaResposta.addMsg("Já existe um filme com este nome.");
			return listaResposta;
		}

		if (filme.getAtores().size() == 0)
		{
			listaResposta.addMsg("Tem de escolher pelo menos um ator.");
			return listaResposta;
		}

		Cinema cinema = cinemaRepository.findById(Long.parseLong(cinema_id)).get();
		filme.setCinema(cinema);

		filmeRepository.save(filme);
		listaResposta.setNewID(filme.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	public ListaResposta removeFilme(String id)
	{
		ListaResposta listaResposta = new ListaResposta();
		try
		{
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || filmeRepository.findById(id_long).isEmpty())
			{
				listaResposta.addMsg("ID de filme inexistente ou fora de formato.");
				return (listaResposta);
			}

			filmeRepository.delete(filmeRepository.findById(id_long).get());
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} catch (Exception e)
		{
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

}
