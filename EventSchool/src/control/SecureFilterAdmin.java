package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

public class SecureFilterAdmin implements Filter{ 
	public void init(FilterConfig config) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)req).getSession();
		User usuario = (User)session.getAttribute("user");
		if(usuario!=null&&usuario.isLogged()&&usuario.getRole().equals(User.roleAdmin)){
			chain.doFilter(req, res);
			
		}else{
			req.setAttribute("msg","Voc� n�o est� logado no sistema!");
			RequestDispatcher view = req.getRequestDispatcher("../loginAdmin.jsp");
			view.forward(req, res);
		}
	}	 
	public void destroy() {
	}
}
