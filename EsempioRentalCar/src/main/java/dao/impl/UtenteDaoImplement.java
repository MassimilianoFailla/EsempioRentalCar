package dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.UtenteDao;
import domain.Utente;
import util.HibernateConfiguration;

public class UtenteDaoImplement implements UtenteDao {

	private static UtenteDaoImplement utenteDaoImpl = null;

	// creo la sessione
	private SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

	public Long saveUtente(Utente utente) {

		// apro la sessione
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(utente);
		transaction.commit();
		// chiudo la sessione
		session.close();

		return id;
	}

	public void updateUtente(Utente utente) {

		// apro la sessione
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(utente);
		transaction.commit();
		// chiudo la sessione
		session.close();
	}

	// cancello l'utente per id
	public void deleteUtente(Long id) {

		// apro la sessione
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Utente utente = session.get(Utente.class, id);
		session.delete(utente);
		transaction.commit();
		// chiudo la sessione
		session.close();

	}

	// trova l'utente per id
	public Utente findUtenteById(Long id) {

		// apro la sessione
		Session session = this.sessionFactory.openSession();
		Utente utente = session.get(Utente.class, id);
		// chiudo la sessione
		session.close();
		return utente;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Utente> findAllUtenti() {
		// apro la sessione
		Session session = this.sessionFactory.openSession();
		List<Utente> listaUtenti = session.createCriteria(Utente.class).list();
		// chiudo la sessione
		session.close();
		return listaUtenti;
	}

	public static UtenteDao getInstance() {
		if (utenteDaoImpl == null)
			utenteDaoImpl = new UtenteDaoImplement();
		return utenteDaoImpl;
	}

}
