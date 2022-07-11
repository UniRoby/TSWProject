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

@WebServlet("/CronologiaOrdini")
public class ServletOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static boolean isDataSource = true;
	
	//private static Model<OcchialeBean, DataSource> ordine = new OcchialeDao();
	private OrdineDao ordineDao = new OrdineDao();
	public void init() throws ServletException {
		super.init();
		ordineDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
	public ServletOrdine() {
		super();
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getSession().getAttribute("auth") != null) {
			UtenteBean bean= (UtenteBean) request.getSession().getAttribute("auth");
			
			
			try {
				
			   System.out.println("Sono nella Servlet Ordini\n");
			   System.out.println(bean);
			   
				request.setAttribute("ordini", ordineDao.doRetriveByUser(bean,null));
				 System.out.println("Ordine\n "+ ordineDao.doRetriveByUser(bean,null));
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/order.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
			
			
		}
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
