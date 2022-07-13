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

@WebServlet("/EliminaProdAdmin")
public class ServletEliminaProdAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OcchialeDao occhialeDao= new OcchialeDao();
	public void init() throws ServletException {
		super.init();
		occhialeDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));	
	}
	
    public ServletEliminaProdAdmin() {
        super();
      
    }   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		
		
		try {
			
			
			occhialeDao.doDelete(id);
			RequestDispatcher dis= request.getRequestDispatcher("/PageAmministratore.jsp");
			dis.forward(request, response);
		}
		catch (SQLException e) {
			System.out.println ("Errore ServletEliminaProdAdmin: " + e.getMessage());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
