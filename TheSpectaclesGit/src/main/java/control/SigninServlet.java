package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.*;
import model.*;


@WebServlet("/Signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Model<UtenteBean, DataSource> utenteModel = new UtenteDao();
	private ArrayList<String> value= new ArrayList<String>();
	

	public void init() throws ServletException {
		super.init();
		utenteModel.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
    public SigninServlet() {
        super();
        
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("error.jsp"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		Date data= request.getParameter("data");
		String email= request.getParameter("email");
		String newPassword= request.getParameter("password");
		String ripPassword= request.getParameter("ripPassword");
		int
		PrintWriter out= response.getWriter();
		
		if (newPassword.equals(ripPassword)) {
		try {
			user.registraUtente(nome, cognome, username, email, ripPassword, telefono, cf, via, citta, provincia, cap);
			ClienteBean client = user.cercaUtente(email, ripPassword) ;
			request.getSession().setAttribute("accedi", client);
			out.print("ProdottiView.jsp");
		} catch (SQLException e) {
			System.out.println ("Errore nella registrazione: " + e.getMessage());
		}
		}
		else {
			request.getSession().setAttribute("accedi", false);
		}
		
	}

}
