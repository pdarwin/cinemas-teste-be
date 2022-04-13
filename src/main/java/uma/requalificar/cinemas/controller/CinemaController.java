package uma.requalificar.cinemas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.cinemas.dto.ListaResposta;
import uma.requalificar.cinemas.dto.SimpleResponse;
import uma.requalificar.cinemas.model.Cinema;
import uma.requalificar.cinemas.service.CinemaService;

@RestController
@CrossOrigin
public class CinemaController {
	private final CinemaService cinemaService;

	@Autowired
	public CinemaController(CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}

	@GetMapping("/getAllCinemas")
	@CrossOrigin
	public List<Cinema> getCinemas() {
		return cinemaService.getCinemas();
	}

	@PostMapping("/addCinema")
	@CrossOrigin
	public ResponseEntity<ListaResposta> addCinema(@RequestBody Cinema cinema) {

		ListaResposta listaResposta = new ListaResposta();

		if (cinema.getId() != null) {
			listaResposta.addMsg("Ao adicionar um item, o ID tem de ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((cinema.getNome() == null)) {
			listaResposta.addMsg("Nome nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((cinema.getMorada() == null)) {
			listaResposta.addMsg("Morada nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = cinemaService.addCinema(cinema);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}

	@CrossOrigin
	@DeleteMapping("/removeCinema/{id}")
	public ResponseEntity<SimpleResponse> removeCinema(@PathVariable String id) {

		ListaResposta listaResposta = cinemaService.removeCinema(id);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}

	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping ("/updateCinema/{id}") public ResponseEntity<SimpleResponse>
	 * updateCinema (@PathVariable String id) {
	 * 
	 * ListaResposta listaResposta = cinemaService.updateCinema (id);
	 * 
	 * if (!listaResposta.isStatusOk() ) { return ResponseEntity.status
	 * (HttpStatus.BAD_REQUEST).body (listaResposta); } else { return
	 * ResponseEntity.status (HttpStatus.OK).body (listaResposta); }
	 * 
	 * }
	 */

}
