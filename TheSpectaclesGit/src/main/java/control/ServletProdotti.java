package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.OcchialeDao;
import model.*;

@WebServlet("/Prodotto")
public class ServletProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static boolean isDataSource = true;
	private ArrayList<String> valori= new ArrayList<String>();
	//private static Model<OcchialeBean, DataSource> modelOcchiale = new OcchialeDao();
	private OcchialeDao modelOcchiale = new OcchialeDao();
	public void init() throws ServletException {
		super.init();
		modelOcchiale.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
	public ServletProdotti() {
		super();
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession();
		/*Carrello car= (Carrello) session.getAttribute("carrello");
		if (car == null) {
			car= new Carrello();
			session.setAttribute("carrello", car);
		}*/
		valori.add(request.getParameter("id"));
	
		synchronized (session) {
		try {
			//request.setAttribute("occhiali", modelOcchiale.doRetriveAll());
			request.removeAttribute("descrizione");
			request.setAttribute("descrizione", modelOcchiale.doRetrieveByKey(valori));
			//request.setAttribute("id", Integer.parseInt(request.getParameter("id")));
			//session.setAttribute("carrello", car);
		
		String azione= request.getParameter("action");
		
		System.out.println("Action value: "+ azione);
			
		if (azione != null && azione.equals("dettagli")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/prodotto.jsp");
			dispatcher.forward(request, response);
		}
		
		/*if (azione != null && azione.equalsIgnoreCase("aggiungi")) {
			ProdottiBean pr= (ProdottiBean) request.getAttribute("descrizione");
			if (!car.searchProdotto(pr.getId())) {
			car.addCarrello(pr);
			}
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiCarrello.jsp");
				dis.forward(request, response);
			}
		
		if (Integer.parseInt(request.getParameter("scelta")) >= 1) {
			RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiCarrello.jsp");
			dis.forward(request, response);
		}*/
		
		}
		catch (Exception e) {
			System.out.println ("Errore Servlet Prodotti: " + e.getMessage());
		}
		
		}
		
		/*RequestDispatcher dis= getServletContext().getRequestDispatcher("/shop.jsp");
		dis.forward(request, response);*/
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
