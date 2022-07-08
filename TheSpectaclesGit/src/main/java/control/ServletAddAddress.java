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



@WebServlet("/AddAddress")
public class ServletAddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IndirizziDao indDao= new IndirizziDao();
	
	public void init() throws ServletException {
		super.init();
		
		indDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
	}
	public ServletAddAddress() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession(false);
		UtenteBean bean= (UtenteBean)session.getAttribute("auth");
		
		
		System.out.println("Sono nella Servlet aggiungi indirizzo: \n");
		System.out.println(request.getAttribute("user_address"));
		String via= (String) request.getAttribute("user_address");
		String citta= (String) request.getAttribute("city");
		String provincia=(String) request.getAttribute("user_country");
		int cap=Integer.parseInt((String) request.getAttribute("zipcode")) ;
		String email= bean.getEmail();
		
		int status=1;
		
		
		try {
			IndirizziBean indirizzo= new IndirizziBean();
			indirizzo.setAddress(via);
			indirizzo.setCap(cap);
			indirizzo.setCity(citta);
			indirizzo.setProvince(provincia);
			indirizzo.setStatus(status);
			indirizzo.setEmail(email);
			indDao.doSave(indirizzo);
			
			
			
		} catch (SQLException e) {
			System.out.println("Errore Servelt aggiungi indirizzo" + e.getMessage());
		}
		
		
		RequestDispatcher dis= getServletContext().getRequestDispatcher("/Indirizzo");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
