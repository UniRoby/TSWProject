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
import java.util.*;

import dao.*;
import model.*;

@WebServlet("/Profile")
public class ServletProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	private UtenteDao utenteDao= new UtenteDao();
	
	public void init() throws ServletException {
		super.init();		
		utenteDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	public ServletProfile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		if (request.getSession().getAttribute("auth") != null) {
			
			System.out.println("Sono nella Servlet profile ");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/profile_details.jsp");
			dispatcher.forward(request, response);
			return;			
		}
		else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}