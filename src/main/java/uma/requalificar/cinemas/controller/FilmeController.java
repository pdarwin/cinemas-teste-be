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
import uma.requalificar.cinemas.model.Filme;
import uma.requalificar.cinemas.service.FilmeService;


@RestController
@CrossOrigin
public class FilmeController 
{
	private final FilmeService filmeService;

	
	@Autowired
	public FilmeController (FilmeService filmeService)
	{
		this.filmeService = filmeService;
	}

	@GetMapping("/getAllFilmes")
	@CrossOrigin
	public List<Filme> getFilmes() {
		return filmeService.getFilmes();
	}
	
    @GetMapping ("/getFilmesByCinema/{cinema_id}")
	@CrossOrigin
    public List<Filme> getFilmesByCinema (@PathVariable String cinema_id)
    {
		return filmeService.getFilmesByCinema (cinema_id);
    }
    
    @GetMapping ("/getFilmesByAtor/{ator_id}")
	@CrossOrigin
    public List<Filme> getFilmesByAtor (@PathVariable String ator_id)
    {
		return filmeService.getFilmesByAtor (ator_id);
    }
    
    
    @PostMapping ("/addFilme/{cinema_id}")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addFilme (@RequestBody Filme filme, @PathVariable String cinema_id)
	{
    	ListaResposta listaResposta = new ListaResposta ();

		if (filme.getId () != null)
		{
			listaResposta.addMsg ("ID filme não nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if (cinema_id == null || cinema_id.isBlank () )
		{
			listaResposta.addMsg ("ID do cinema não preenchido.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}


		listaResposta = filmeService.addFilme (filme, cinema_id);

		if (!listaResposta.isStatusOk() )
		{
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		} 
		else
		{
			return ResponseEntity.status (HttpStatus.OK).body (listaResposta);
		}

	}

    
	@CrossOrigin
	@DeleteMapping("/removeFilme/{id}")
	public ResponseEntity<SimpleResponse> removeFilme(@PathVariable String id) {

		ListaResposta listaResposta = filmeService.removeFilme(id);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}
    
}
