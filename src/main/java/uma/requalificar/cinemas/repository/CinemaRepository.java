package uma.requalificar.cinemas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.cinemas.model.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository <Cinema, Long>
{

	List<Cinema> findByNome(String nome);
}
