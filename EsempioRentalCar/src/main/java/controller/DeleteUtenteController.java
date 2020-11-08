package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtenteDao;
import dao.impl.UtenteDaoImplement;

// indirizzo cancellazione utente
@WebServlet("utente/cancellazione")
public class DeleteUtenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// costruttore di base
	public DeleteUtenteController() {

	}

	// metodo doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String utenteId = request.getParameter("utenteId");

		if (utenteId == "" || utenteId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long id = Long.parseLong(utenteId);
			UtenteDao utenteDao = UtenteDaoImplement.getInstance();

			utenteDao.deleteUtente(id);

			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
