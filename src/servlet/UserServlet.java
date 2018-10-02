package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import javaBean.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String uname= request.getParameter("uname");
        String psw = request.getParameter("psw");
         System.out.println(psw+"  "+uname);
         UserDAO dao = new UserDAO();
         User user= dao.find(uname);
         HttpSession session = request.getSession();
         session.setAttribute("user", uname);
      
         if(user==null){
        	 request.setAttribute("msg", "”√ªß√˚¥ÌŒÛ");
        	 request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
         }else{
        	 if(user.getPsw().equals(psw)){
        		 response.sendRedirect("jsp/index.jsp");
        	 }else{
        		 request.setAttribute("msg", "√‹¬Î¥ÌŒÛ£°");
        		 request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        	 }
         }
          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
