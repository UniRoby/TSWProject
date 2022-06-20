package control;


import java.io.IOException;
import java.sql.SQLException;
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

import model.*;

@WebServlet("/accesso")
public class Accesso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Model<UtenteBean, DataSource> utenteModel = new UtenteBeanDao();
	

	public void init() throws ServletException {
		super.init();
		utenteModel.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}

	public Accesso() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("errore.jsp?error=403"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mode = request.getParameter("mode");

		if (mode != null && mode.equals("userExists")) {
			response.setContentType("text/plain");
			String email = request.getParameter("email");
			if (email == null || email.isBlank())
				response.getWriter().print("true");
			else {
				try {
					UtenteBean bean = utenteModel.doRetrieveByKey(email);
					if (bean.getEmail() == null)
						response.getWriter().print("false");
					else
						response.getWriter().print("true");

				} catch (SQLException e) {
					request.setAttribute("error", "Si è verificato un errore, riprova");
					getServletContext().getRequestDispatcher(response.encodeURL("/errore.jsp")).forward(request,
							response);
				}
			}
		} else {
			List<String> errorsFound = new ArrayList<>();
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			if (email == null
					|| !Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$").matcher(email).find()
					|| email.isEmpty())
				errorsFound.add("email");
			if (pass == null || !Pattern.compile("[A-Z]").matcher(pass).find()
					|| !Pattern.compile("[0-9]").matcher(pass).find() || pass.isBlank())
				errorsFound.add("pass");

			UtenteBean utenteBean = new UtenteBean();
			utenteBean.setEmail(email);
			utenteBean.setPass(pass);

			if (errorsFound.size() > 0) {
				request.setAttribute("errorsFound", errorsFound);
				request.setAttribute("utenteBean", utenteBean);
				response.setStatus(422);
				getServletContext().getRequestDispatcher(response.encodeURL("/accesso.jsp")).forward(request, response);
			} else {
				try {
					UtenteBean beanUser = utenteModel.doRetrieveByKey(email);
					if (beanUser.getEmail() == null) {
						errorsFound.add("email");
						request.setAttribute("errorsFound", errorsFound);
						request.setAttribute("utenteBean", utenteBean);
						response.setStatus(422);
						getServletContext().getRequestDispatcher(response.encodeURL("/accesso.jsp")).forward(request,
								response);
					} else if (beanUser.getPass() == null || !beanUser.getPass().equals(pass)) {
						errorsFound.add("pass");
						request.setAttribute("errorsFound", errorsFound);
						request.setAttribute("utenteBean", utenteBean);
						response.setStatus(422);
						getServletContext().getRequestDispatcher(response.encodeURL("/accesso.jsp")).forward(request,
								response);
					} else {
						HttpSession session = request.getSession();
						List<UtenteBean> accounts = (List<UtenteBean>) session.getAttribute("accounts");
						if (accounts == null)
							accounts = new ArrayList<>();
						else if (accounts.contains(beanUser)) {
							response.sendRedirect(response.encodeRedirectURL("errore.jsp?error=409"));
							return;
						}
						accounts.add(beanUser);
						UtenteBean oldAcc = (UtenteBean) session.getAttribute("utenteBean");
						
						session.setAttribute("accounts", accounts);
						session.setAttribute("utenteBean", beanUser);
						switch (beanUser.getRole()) {
						case 0:
							response.sendRedirect(response.encodeRedirectURL("utente.jsp"));
							break;
						case 1:
							response.sendRedirect(response.encodeRedirectURL("admin.jsp"));
							break;
						
						}
					}
				} catch (SQLException e) {
					response.sendRedirect(response.encodeRedirectURL("errore.jsp?error=500"));
				}
			}
		}

	}
}
