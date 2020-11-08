package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtenteDao;
import dao.impl.UtenteDaoImplement;
import domain.Utente;

// indirizzo per la registrazione dell'utente
@WebServlet("/utente/registrazione")
public class RegistrazioneUtenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UtenteDao utenteDao = UtenteDaoImplement.getInstance();

	public RegistrazioneUtenteController() {
		// costruttore di base
	}

	// implemento il doGet ed il doPost
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	// doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String utenteId = request.getParameter("id");
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String annoNascita = request.getParameter("annoNascita");

		Utente utente = new Utente(nome, cognome, annoNascita);

		if (utenteId == null || utenteId == "") {
			utenteDao.saveUtente(utente);
		} else {
			Long id = Long.parseLong(utenteId);
			utente.setId(id);
			utenteDao.updateUtente(utente);
		}
		response.sendRedirect(request.getContextPath() + "/");

	}
}
