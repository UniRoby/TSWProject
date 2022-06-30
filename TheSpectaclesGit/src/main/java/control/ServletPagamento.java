package control;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/Pagamento")
public class ServletPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date dat= new Date(System.currentTimeMillis());
		
		UtenteBean cerca= (UtenteBean) request.getSession().getAttribute("auth");
		
		String idUtente= cerca.getEmail();
		
		
		OrdineDao ord= new OrdineDao();
		
		UtenteDao dm= new UtenteDao();
		
		try {
			
		request.setAttribute("indirizzo", dm.cercaIndirizzo(idUtente));
		
		//ord.effettuaPagamento(idUtente, 2, dat, "La spedizione è gratuita");
		Carrello car= (Carrello) request.getSession().getAttribute("carrello");
		car.delete();
		request.getSession().setAttribute("carrello", car);
		}
		catch (SQLException e) {
			System.out.println ("Errore servletpagamento: " + e.getMessage());
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("/Confirmation.jsp");
		dis.forward(request, response);
	}
}