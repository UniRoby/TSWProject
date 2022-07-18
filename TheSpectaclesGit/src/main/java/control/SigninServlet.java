package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
		
		String newPassword= request.getParameter("password");
		
        byte[] data1 = newPassword.getBytes("UTF-8");
        MessageDigest mdhash = null;
		try {
			mdhash = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        byte[] digest = mdhash.digest(data1);              
        String HashPassw = Base64.getEncoder().encodeToString(digest);
		
		
		
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		Date birth=new Date();
		try {
			birth = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("data"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(request.getParameter("data"));
		
		String email= request.getParameter("email");
		
		
		
		int ruolo= 0;
		PrintWriter out= response.getWriter();
		ArrayList<String> value= new ArrayList<String>();
		value.add(email);
		value.add(newPassword);
		UtenteBean newUtente= new UtenteBean(email,HashPassw,nome,cognome,birth,ruolo);
		try {
			
			utenteModel.doSave(newUtente);
			UtenteBean client = utenteModel.doRetrieveByKey(value);
			request.getSession().setAttribute("auth", client);
			out.print("Utente");
		} catch (SQLException e) {
			System.out.println ("Errore nella signin: " + e.getMessage());
		}
		
		
	}

}
