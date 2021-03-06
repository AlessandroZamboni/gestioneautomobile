package it.prova.gestioneautomobileutente.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobileutente.model.Automobile;
import it.prova.gestioneautomobileutente.service.MyServiceFactory;


@WebServlet("/ExecuteDeleteAutomobileServlet")
public class ExecuteDeleteAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteAutomobileServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String idAutomobileParam = request.getParameter("idAutomobileDelete");
		
		Automobile automobileInstance = null;		
		
		try {
			
			automobileInstance = MyServiceFactory.getAutomobileServiceInstance().caricaSingoloElemento(Long.parseLong(idAutomobileParam));
			MyServiceFactory.getAutomobileServiceInstance().rimuovi(automobileInstance);
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/delete.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);
	}

}
