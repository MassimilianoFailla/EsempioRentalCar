package dao;

import java.util.List;

import domain.Utente;

//questa classe serve per gestire un utente
public interface UtenteDao {

	// salva l'utente
	Long saveUtente(Utente utente);

	// aggiorna l'utente
	void updateUtente(Utente utente);

	// cancella l'utente
	void deleteUtente(Long id);

	// Cerca l'utente per id
	Utente findUtenteById(Long id);

	// Cerca tutti gli utenti in formato lista
	List<Utente> findAllUtenti();

}
