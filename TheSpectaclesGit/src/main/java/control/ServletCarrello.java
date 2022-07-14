package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.*;
import model.*;



@WebServlet("/Prodotto2")
public class ServletCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletCarrello() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession(false);
		Carrello car= (Carrello) session.getAttribute("carrello");
		String id=  request.getParameter("nascosto");
		int scelta= Integer.parseInt(request.getParameter("scelta"));
		
		System.out.println("Sono nella Servlet Carrello: \nId: "+id+"\nQuantità scelta: "+scelta+"\n");
		
		
		car.insertQuantita(id, scelta);
		car.getPrezzoTotale(scelta, id);
		
		RequestDispatcher dis= getServletContext().getRequestDispatcher("/carrello.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
