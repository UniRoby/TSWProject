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

import dao.OcchialeDao;
import model.*;

@WebServlet("/search")
public class Search extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private OcchialeDao modelOcchiale = new OcchialeDao();
	
	public void init() throws ServletException {
		super.init();
		modelOcchiale.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
	public Search() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		String brand = request.getParameter("brand");
		try {
			request.removeAttribute("occhiali");
			request.setAttribute("occhiali", modelOcchiale.doRetrieveByBrand(brand));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/shop.jsp");
		dispatcher.forward(request, response);
	}
}
