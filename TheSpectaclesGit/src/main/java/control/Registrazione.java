package control;

import java.io.IOException;
import java.sql.Date;
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


@WebServlet("/registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Model<UtenteBean, DataSource> modelUtente = new UtenteBeanDao();
	

	public void init() throws ServletException {
		super.init();
		modelUtente.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}

	public Registrazione() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("/errore.jsp?error=403"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errorsFound = new ArrayList<>();
		
		String pass = request.getParameter("pass");
		Integer role = 0;
		String firstName = request.getParameter("nome");
		String lastName = request.getParameter("cognome");
		Date birthday = null;
		String email = request.getParameter("email");

		
		if (pass == null || !Pattern.compile("[A-Z]").matcher(pass).find()
				|| !Pattern.compile("[0-9]").matcher(pass).find() || pass.isBlank())
			errorsFound.add("pass");
		try {
			role = (Integer.parseInt(request.getParameter("role")));
			if (role < 1 || role > 3)
				errorsFound.add("role");
		} catch (NumberFormatException | NullPointerException e) {
			errorsFound.add("role");
		}
		if (firstName == null || Pattern.compile("[^A-Za-zÀ-ÖØ-öø-ÿ ]").matcher(firstName).find()
				|| firstName.isBlank())
			errorsFound.add("firstName");
		if (lastName == null || Pattern.compile("[^A-Za-zÀ-ÖØ-öø-ÿ ]").matcher(lastName).find() || lastName.isBlank())
			errorsFound.add("lastName");
		try {
			birthday = Date.valueOf(request.getParameter("birthday"));
			if (birthday == null || birthday.compareTo(new java.util.Date()) > 0)
				errorsFound.add("birthday");
		} catch (IllegalArgumentException e) {
			errorsFound.add("birthday");
		}
		
		if (email == null
				|| !Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$").matcher(email).find()
				|| email.isEmpty())
			errorsFound.add("email");

		UtenteBean utenteBean = new UtenteBean();
		utenteBean.setPass(pass);
		utenteBean.setRole(role);
		utenteBean.setEmail(email);
		utenteBean.setFirstName(firstName);
		utenteBean.setLastName(lastName);
		utenteBean.setBirthday(birthday);
		
		if (errorsFound.size() > 0) {
			request.setAttribute("errorsFound", errorsFound);
			request.setAttribute("utenteBean", utenteBean);
			response.setStatus(422);
			getServletContext().getRequestDispatcher(response.encodeURL("/registrazione.jsp")).forward(request,
					response);
		} else {
			try {
				modelUtente.doSave(utenteBean);
				
				HttpSession session = request.getSession();
				List<UtenteBean> accounts = (List<UtenteBean>) session.getAttribute("accounts");
				if (accounts == null)
					accounts = new ArrayList<>();
				else if (accounts.contains(utenteBean)) {
					response.sendRedirect(response.encodeRedirectURL("errore.jsp?error=409"));
					return;
				}
				accounts.add(utenteBean);
				session.setAttribute("accounts", accounts);
				session.setAttribute("utenteBean", utenteBean);
				switch (utenteBean.getRole()) {
				case 0:
					response.sendRedirect(response.encodeRedirectURL("/paziente.jsp"));
					break;
				case 1:
					response.sendRedirect(response.encodeRedirectURL("/admin.jsp"));
					break;
				
				}
			} catch (SQLException e) {
				int errorCode = e.getErrorCode();
				switch (errorCode) {
				case 1062:
					errorsFound.add("user");
					request.setAttribute("errorsFound", errorsFound);
					request.setAttribute("utenteBean", utenteBean);
					response.setStatus(409);
					getServletContext().getRequestDispatcher(response.encodeURL("/registrazione.jsp")).forward(request,
							response);
					break;

				default:
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					response.sendRedirect(response.encodeRedirectURL("/errore?error=500.jsp"));

				}
			}
		}

	}
}
