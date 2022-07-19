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

@WebServlet("/Modifica")
public class ServletModificaAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OcchialeDao occhialeDao= new OcchialeDao();
	public void init() throws ServletException {
		super.init();
		occhialeDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
		
	}
	
	
    public ServletModificaAmministratore() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		String nome= request.getParameter("nome");
		String descrizione = request.getParameter("desc");
		int quantita = Integer.parseInt(request.getParameter("disp"));
		int prezzo= Integer.parseInt(request.getParameter("prezzo"));
		String id= request.getParameter("id");
		System.out.println("id  "+ id);
			
			OcchialeBean occhiale= new OcchialeBean();
			occhiale.setNameGlasses(nome);
			occhiale.setAvailability(quantita);
			occhiale.setPrice(prezzo);
			occhiale.setDescription(descrizione);
			occhiale.setIdGlasses(id);
			
			occhialeDao.doUpdate(occhiale);
		}
		catch (Exception e) {
			e.getMessage();
		}
		RequestDispatcher dis= request.getRequestDispatcher("/PageAmministratore.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
