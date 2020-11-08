package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utente")
public class Utente {

	// genero la colonna id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	// genero la colonna nome utente
	@Column(name = "Nome")
	private String nome;

	// genero la colonna cognome utente
	@Column(name = "Cognome")
	private String cognome;

	// genero la colonna Data di Nascita
	@Column(name = "Data Di Nascita")
	private String annoNascita;

	// genero il costruttore che non fa niente
	public Utente() {

	}

	// genero il costruttore che utilizzer�+
	public Utente(String nome, String cognome, String annoNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
	}

	// genero i get e set

	// genero il toString
	public String toString() {

		return "Utente -> Nome: " + nome + ", Cognome: " + cognome + ", Data Nascita: " + annoNascita + " ;";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
	}

}
