package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtenteDao;
import dao.impl.UtenteDaoImplement;
import domain.Utente;

// questa � la servlet

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtenteDao utenteDao = UtenteDaoImplement.getInstance();

	public HomeController() {
		// costruttore
	}

	// ora si devono i creare il doGet e il doPost
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Utente> listaUtenti = utenteDao.findAllUtenti();

		request.setAttribute("Lista Utenti", listaUtenti);

		// per il getRequest ci vuole un file jsp
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	// doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
