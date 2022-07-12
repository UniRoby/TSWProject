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
import java.util.*;

import dao.*;
import model.*;

@WebServlet("/Amministratore")
public class ServletAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OcchialeDao modelOcchiale = new OcchialeDao();
	public void init() throws ServletException {
		super.init();
		modelOcchiale.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
	public ServletAmministratore() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.removeAttribute("occhiali");
			request.setAttribute("occhiali", modelOcchiale.doRetrieveAll(null));
			UtenteBean cerca= (UtenteBean) request.getSession().getAttribute("auth");
			request.setAttribute("admin", cerca);
			
			String azione= request.getParameter("action");
			if (azione != null && azione.equalsIgnoreCase("dettagli")) {
				ArrayList<String> valori= new ArrayList<String>();
				valori.add(request.getParameter("id"));
			
				request.setAttribute("des", modelOcchiale.doRetrieveByKey(valori));	
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ProdottiDesAmministratore.jsp");
				dis.forward(request, response);
			}
			
			if (azione != null && azione.equalsIgnoreCase("modifica")) {
				ArrayList<String> valori= new ArrayList<String>();
				valori.add(request.getParameter("id"));
				request.setAttribute("modifica", modelOcchiale.doRetrieveByKey(valori));	
				
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/ModificaAmministratore.jsp");
				dis.forward(request, response);		
			}
			
			if (azione != null && azione.equalsIgnoreCase("aggiungi")) {
				RequestDispatcher dis= getServletContext().getRequestDispatcher("/AggiungiProdAdmin.jsp");
				dis.forward(request, response);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dis= getServletContext().getRequestDispatcher("/PageAmministratore.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
