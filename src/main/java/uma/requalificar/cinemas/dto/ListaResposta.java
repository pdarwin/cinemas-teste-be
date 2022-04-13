package uma.requalificar.cinemas.dto;

import java.util.List;
import java.util.Optional;

public class ListaResposta extends SimpleResponse {
	private List<?> lista;
	private Optional<?> optional;
	private long newID;
	private String newUsername;

	/**
	 * @return the filmes
	 */
	public List<?> getLista() {
		return lista;
	}

	/**
	 * @param filmes the filmes to set
	 */
	public void setLista(List<?> lista) {
		this.lista = lista;
	}

	/**
	 * @return the newID
	 */
	public long getNewID() {
		return newID;
	}

	/**
	 * @param newID the newID to set
	 */
	public void setNewID(long newID) {
		this.newID = newID;
	}

	/**
	 * @return the optional
	 */
	public Optional<?> getOptional() {
		return optional;
	}

	/**
	 * @param optional the optional to set
	 */
	public void setOptional(Optional<?> optional) {
		this.optional = optional;
	}

	/**
	 * @return the newUsername
	 */
	public String getNewUsername() {
		return newUsername;
	}

	/**
	 * @param newUsername the newUsername to set
	 */
	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	

}
