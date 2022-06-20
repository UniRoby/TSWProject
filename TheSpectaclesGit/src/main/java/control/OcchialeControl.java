package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OcchialeDao;
import model.*;

/**
 * Servlet implementation class ProductControl
 */
 @WebServlet("/OcchialeControl")
public class OcchialeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// OcchialeModelDS usa il DataSource
	// OcchialeDao usa il DriverManager	
	static boolean isDataSource = true;
	
	static Model model;
	
	
	public OcchialeControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*String action = request.getParameter("action");

		try {
			if (action != null) {
				if (action.equalsIgnoreCase("read")) {
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
				} else if (action.equalsIgnoreCase("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				} else if (action.equalsIgnoreCase("insert")) {
					String name = request.getParameter("name");
					String description = request.getParameter("description");
					int price = Integer.parseInt(request.getParameter("price"));
					int quantity = Integer.parseInt(request.getParameter("quantity"));

					OcchialeBean bean = new OcchialeBean();
					bean.setName(name);
					bean.setDescription(description);
					bean.setPrice(price);
					bean.setQuantity(quantity);
					model.doSave(bean);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
         */
		String sort = request.getParameter("sort");
       model=  new OcchialeDao();
		try {
			request.removeAttribute("occhiali");
			request.setAttribute("occhiali", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
