package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import javaBean.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	        request.setCharacterEncoding("utf-8");
	        String uname= request.getParameter("uname");
	        String psw = request.getParameter("psw");
	         System.out.println(psw+"  "+uname);
	         UserDAO dao = new UserDAO();
	         User user= new User();
	         user.setUname(uname);
	         user.setPsw(psw);
	         if(user==null) {
	        	 request.setAttribute("msg", "用户名或密码不能为空");
	         }
	         else{
	        	  if(uname!=null&&psw!=null){
	 	        	 dao.insert(user);
	 	        	 response.sendRedirect("jsp/login.jsp");
	 	         }
	        	  else   if(uname==null){
	        	 request.setAttribute("msg", "用户名不能为空");
	         }
	        	  else if(psw==null) {
	        	 request.setAttribute("msg", "密码不能为空");
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
