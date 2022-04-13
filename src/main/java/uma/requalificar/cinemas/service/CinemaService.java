package uma.requalificar.cinemas.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.cinemas.dto.ListaResposta;
import uma.requalificar.cinemas.model.Cinema;
import uma.requalificar.cinemas.repository.CinemaRepository;

@Service
public class CinemaService {

	private final CinemaRepository cinemaRepository;

	@Autowired
	public CinemaService(CinemaRepository cinemaRepository) {
		this.cinemaRepository = cinemaRepository;
	}

	public List<Cinema> getCinemas() {
		List<Cinema> cinemas = new ArrayList<>();
		cinemaRepository.findAll().forEach(cinemas::add);

		return cinemas;
	}

	public ListaResposta addCinema(Cinema cinema) {
		ListaResposta listaResposta = new ListaResposta();

		if (cinema.getNome().isBlank()) {
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}

		if (cinema.getMorada().isBlank()) {
			listaResposta.addMsg("Morada não preenchida.");
			return listaResposta;
		}

		if (cinemaRepository.findByNome(cinema.getNome()).size() > 0) {
			listaResposta.addMsg("Já existe um cinema com este nome.");
			return listaResposta;
		}

		cinemaRepository.save(cinema);
		listaResposta.setNewID(cinema.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	public ListaResposta updateCinema(String id) {
		ListaResposta listaResposta = new ListaResposta();
		try {
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || cinemaRepository.findById(id_long).isEmpty()) {
				listaResposta.addMsg("ID de cinema inexistente ou fora de formato.");
				return (listaResposta);
			}

			Cinema cinema = cinemaRepository.findById(id_long).get();
			cinemaRepository.save(cinema);
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} catch (Exception e) {
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

	public ListaResposta removeCinema(String id) {
		ListaResposta listaResposta = new ListaResposta();
		try {
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || cinemaRepository.findById(id_long).isEmpty()) {
				listaResposta.addMsg("ID de cinema inexistente ou fora de formato.");
				return (listaResposta);
			}

			cinemaRepository.delete(cinemaRepository.findById(id_long).get());
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} catch (Exception e) {
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

}
