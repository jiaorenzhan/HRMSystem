package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Login
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res= (HttpServletResponse) response;
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String res_url = req.getRequestURI();
		String ctxPath = req.getContextPath();
		String url = res_url.substring(ctxPath.length());
		if( url.contains("login.jsp")||url.contains("register.jsp")||url.contains("UserServlet")||url.contains("RegisterServlet")){
			chain.doFilter(request, response);
		}
		else{
			if(session.getAttribute("user")!=null){
				chain.doFilter(request, response);
			}else {
				out.println("您没有登录，请先登录！3秒后回到登录页面。");
				res.setHeader("refresh", "3;url=" + ctxPath + "/jsp/login.jsp");
				return;
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
