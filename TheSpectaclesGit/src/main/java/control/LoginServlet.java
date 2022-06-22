package control;

import java.io.IOException;
import java.io.PrintWriter;
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

import dao.*;
import model.*;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Model<UtenteBean, DataSource> utenteModel = new UtenteDao();
	

	public void init() throws ServletException {
		super.init();
		utenteModel.setDB((DataSource) getServletContext().getAttribute("DataSource"));
		
	}
	
	public LoginServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(response.encodeRedirectURL("/webapp/error.jsp"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mode = request.getParameter("mode");

		if (mode != null && mode.equals("userEmailEmailExists")) {
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
					getServletContext().getRequestDispatcher(response.encodeURL("/webapp/error.jsp")).forward(request,
							response);
				}
			}
		} else {
			List<String> errorsFound = new ArrayList<>();
			String userEmail = request.getParameter("email");
			String pass = request.getParameter("pass");

			if (userEmail == null || Pattern.compile("[^A-z0-9\\?\\.\\,\\-]").matcher(userEmail).find() || userEmail.isBlank())
				errorsFound.add("userEmail");
			if (pass == null || !Pattern.compile("[A-Z]").matcher(pass).find()
					|| !Pattern.compile("[0-9]").matcher(pass).find() || pass.isBlank())
				errorsFound.add("pass");

			UtenteBean utenteBean = new UtenteBean();
			utenteBean.setEmail(userEmail);
			utenteBean.setPass(pass);

			if (errorsFound.size() > 0) {
				request.setAttribute("errorsFound", errorsFound);
				request.setAttribute("utenteBean", utenteBean);
				response.setStatus(422);
				getServletContext().getRequestDispatcher(response.encodeURL("/login.jsp")).forward(request, response);
			} else {
				try {
					UtenteBean beanUser = utenteModel.doRetrieveByKey(userEmail);
					if (beanUser.getEmail() == null) {
						errorsFound.add("userEmail");
						request.setAttribute("errorsFound", errorsFound);
						request.setAttribute("utenteBean", utenteBean);
						response.setStatus(422);
						getServletContext().getRequestDispatcher(response.encodeURL("/login.jsp")).forward(request,
								response);
					} else if (beanUser.getPass() == null || !beanUser.getPass().equals(pass)) {
						errorsFound.add("pass");
						request.setAttribute("errorsFound", errorsFound);
						request.setAttribute("utenteBean", utenteBean);
						response.setStatus(422);
						getServletContext().getRequestDispatcher(response.encodeURL("/login.jsp")).forward(request,
								response);
					} else {
						HttpSession session = request.getSession();
						List<UtenteBean> accounts = (List<UtenteBean>) session.getAttribute("accounts");
						if (accounts == null)
							accounts = new ArrayList<>();
						else if (accounts.contains(beanUser)) {
							response.sendRedirect(response.encodeRedirectURL("/webapp/error.jsp"));
							return;
						}
						accounts.add(beanUser);
						/*UtenteBean oldAcc = (UtenteBean) session.getAttribute("utenteBean");
						if (oldAcc != null && oldAcc.getRole() == 1)
							session.removeAttribute("pazienteBean");
						if (beanUser.getRole() == 1) {
							session.setAttribute("pazienteBean", pazienteModel.doRetrieveByKey(beanUser.getEmail()));
						}
						session.setAttribute("accounts", accounts);
						session.setAttribute("utenteBean", beanUser);
						switch (beanUser.getRole()) {
						case -1:
							response.sendRedirect(response.encodeRedirectURL("/webapp/admin.jsp"));
							break;
						case 1:
							response.sendRedirect(response.encodeRedirectURL("/webapp/paziente.jsp"));
							break;
						
						}*/
					}
				} catch (SQLException e) {
					response.sendRedirect(response.encodeRedirectURL("/webapp/error.jsp"));
				}
			}
		}

	}
}
