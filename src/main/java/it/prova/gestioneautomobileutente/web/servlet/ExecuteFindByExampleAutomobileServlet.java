package it.prova.gestioneautomobileutente.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestioneautomobileutente.model.Automobile;
import it.prova.gestioneautomobileutente.service.MyServiceFactory;
import it.prova.gestioneautomobileutente.utility.UtilityAutomobileForm;


@WebServlet("/ExecuteFindByExampleAutomobileServlet")
public class ExecuteFindByExampleAutomobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExecuteFindByExampleAutomobileServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String marcaInputParam = request.getParameter("marca");
		String modelloInputParam = request.getParameter("modello");
		String cilindrataInputStringParam = request.getParameter("cilindrata");
		String dataImmatricolazioneStringParam = request.getParameter("dataImmatricolazione");

		Date dataImmatricolazioneParsed = UtilityAutomobileForm.parseDataPubblicazioneFromString(dataImmatricolazioneStringParam);

		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		Integer cilindrata = 0;
		
		if(UtilityAutomobileForm.avoidNumberException(cilindrataInputStringParam) != null)
			cilindrata = Integer.parseInt(UtilityAutomobileForm.avoidNumberException(cilindrataInputStringParam));
		
		Automobile automobileInstance = new Automobile(marcaInputParam,modelloInputParam,cilindrata,dataImmatricolazioneParsed);
		
		try {
			request.setAttribute("listaAutomobiliAttribute", MyServiceFactory.getAutomobileServiceInstance().findByExample(automobileInstance));
		} catch (Exception e) {
			//qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/automobile/index.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/automobile/results.jsp").forward(request, response);

	}
}


