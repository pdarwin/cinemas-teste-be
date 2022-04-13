package uma.requalificar.cinemas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.cinemas.model.Ator;
import uma.requalificar.cinemas.model.Cinema;

@Repository
public interface AtorRepository extends CrudRepository <Ator, Long>
{
	List<Ator> findByNome(String nome);
}
