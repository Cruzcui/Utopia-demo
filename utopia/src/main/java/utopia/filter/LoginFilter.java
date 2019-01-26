package utopia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utopia.common.RequestHolder;

import utopia.model.TbUser;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		TbUser user = (TbUser) request.getSession().getAttribute("user");
		if (user == null) {
			String path = "/signin.jsp";
			response.sendRedirect(path);
			return;
		}
		
		//保存用户信息
		RequestHolder.add(user);
		RequestHolder.add(request);
		arg2.doFilter(arg0, arg1);
		return;
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
