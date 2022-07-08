package control;


import java.util.Date;
import java.util.UUID;
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

import dao.*;
import model.*;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static boolean isDataSource = true;
	private OrdineDao ordineDao= new OrdineDao();
	private OcchialeDao oDao= new OcchialeDao();
	private IndirizziDao indDao= new IndirizziDao();
	OcchialeOrdineDao occhialeDao = new OcchialeOrdineDao();
	
	public void init() throws ServletException {
		super.init();
		ordineDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		oDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		occhialeDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		indDao.setDB((DataSource) getServletContext().getAttribute("DataSource"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String ind= (String) request.getParameter("sameadr");
		System.out.println("Checkout address: "+request.getParameter("sameadr"));
		System.out.println("Checkout cardNumber: "+request.getParameter("cardnumber"));
		
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		
		if (request.getSession().getAttribute("auth") != null) {
			UtenteBean bean= (UtenteBean) request.getSession().getAttribute("auth");
			if (cart != null) {
				OrdineBean ordine = createOrder(request);
				ArrayList<OcchialeOrdineBean> occhialiOrdine = createProducts(
					cart,
					ordine.getIdOrder()
				);
				try {
					
					ordineDao.doSave(ordine);
					request.getSession().setAttribute("address",indDao.search(bean.getEmail(), ind));
					
					
					for (OcchialeOrdineBean o : occhialiOrdine) {
						occhialeDao.doSave(o);
						
						oDao.decreaseAvailability(o.getProdotto()); // controllare perchè toglie tutte le quantità
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				cart.delete();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confirmation.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private OrdineBean createOrder(HttpServletRequest request) {
		OrdineBean ordine = new OrdineBean();
		ordine.setDate(new Date());
		ordine.setStato("preso in carico");
		ordine.setIdOrder(UUID.randomUUID());
		ordine.setEmail(((UtenteBean) request.getSession().getAttribute("auth")).getEmail());
		return ordine;
	}

	private ArrayList<OcchialeOrdineBean> createProducts(Carrello cart, UUID idOrdine) {
		ArrayList<OcchialeOrdineBean> result = new ArrayList<>();
		ArrayList<OcchialeBean> car = cart.getCarrello();
		for (int i= 0; i < car.size(); i++) {
			
			OcchialeOrdineBean bean = new OcchialeOrdineBean();
			bean.setProdotto(car.get(i));
			bean.setPrezzoEffettivo(car.get(i).getPrice());
			bean.setQuantita(car.get(i).getQuantity());
			bean.setIdOrdine(idOrdine);
			result.add(bean);
		}
		return result;
	}
}
