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
import uma.requalificar.cinemas.model.Filme;
import uma.requalificar.cinemas.model.Ator;
import uma.requalificar.cinemas.service.AtorService;

@RestController
@CrossOrigin
public class AtorController {
	private final AtorService atorService;

	@Autowired
	public AtorController(AtorService atorService) {
		this.atorService = atorService;
	}

	@GetMapping("/getAtores")
	@CrossOrigin
	public List<Ator> getAtors() {
		return atorService.getAtors();
	}

	@GetMapping("/getAtoresByFilme/{filme_id}")
	@CrossOrigin
	public List<Ator> getAtorsByFilme(@PathVariable String filme_id) {
		return atorService.getAtoresByFilme(filme_id);
	}

	@PostMapping("/addAtor")
	@CrossOrigin
	public ResponseEntity<ListaResposta> addAtor(@RequestBody Ator ator) {
		ListaResposta listaResposta = new ListaResposta();

		if (ator.getId() != null) {
			listaResposta.addMsg("Ao adicionar um ator, o ID tem de ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = atorService.addAtor(ator);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}
	
	@CrossOrigin
	@DeleteMapping("/removeAtor/{id}")
	public ResponseEntity<SimpleResponse> removeAtor(@PathVariable String id) {

		ListaResposta listaResposta = atorService.removeAtor(id);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}

}
