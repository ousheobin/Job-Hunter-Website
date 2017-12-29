package cn.gcu.edu.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		if(request.getSession().getAttribute("isLogin")!=null) {
			String type = (String) request.getSession().getAttribute("type");
			if(type != null && !type.isEmpty()) {
				if(type.equals("user")) {
					chain.doFilter(request, response);
				}else {
					response.sendRedirect("index.html");
				}
			}else {
				response.sendRedirect("login.html");
			}
		}else {
			response.sendRedirect("login.html");
		}
	}

	@Override
	public void destroy() {
		
	}

}
