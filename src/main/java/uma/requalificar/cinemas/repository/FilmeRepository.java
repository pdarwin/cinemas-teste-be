package uma.requalificar.cinemas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.cinemas.model.Cinema;
import uma.requalificar.cinemas.model.Filme;

@Repository
public interface FilmeRepository extends CrudRepository <Filme, Long>
{
	List<Filme> findByNome(String nome);
}
