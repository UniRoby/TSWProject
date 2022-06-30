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
import javax.sql.DataSource;

import dao.*;
import model.*;



@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	private OcchialeDao modelOcchiale = new OcchialeDao();
	
	public void init() throws ServletException {
		super.init();
		modelOcchiale.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	public CategoriaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo= request.getParameter("tipo");
		String colore= request.getParameter("colore");
		String sex= request.getParameter("sex");
		ArrayList<String> valori= new ArrayList<String>();
		valori.add(tipo);
		System.out.println("ServletCategoria: "+ valori.get(0));
		
		try {
		
			request.removeAttribute("occhiali");
			request.setAttribute("occhiali", modelOcchiale.doRetrieveByKey(valori));
		}
		catch (SQLException e) {
			System.out.println("Errore Categoria Servlet: " + e.getMessage());
		}
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shopCategoria.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}