package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.LoginDAO;

import models.User;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet(name = "loginUser", urlPatterns = { "/loginUser" })
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String passwd = request.getParameter("password");
		
		User user = new User();
		user.setLogin(name);
		user.setPasswd(passwd);
		
		user = LoginDAO.loginUser(user);
		
		if(user != null && user.isLogged()){
			request.getSession().setAttribute("user", user);
			RequestDispatcher view = request.getRequestDispatcher("/user/indexUser.jsp");
			view.forward(request, response);
		}
		else{
			request.setAttribute("msg","Usu�rio ou senha inv�lido");
			RequestDispatcher view = request.getRequestDispatcher("loginUser.jsp");
			view.forward(request, response);
		}
	}

}
