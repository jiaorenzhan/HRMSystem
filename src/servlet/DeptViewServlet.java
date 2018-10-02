package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartDAO;
import javaBean.Department;

/**
 * Servlet implementation class DeptViewServlet
 */
@WebServlet("/DeptViewServlet")
public class DeptViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptViewServlet() {
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
	       DepartDAO dao= new DepartDAO();
	        
            List<Department> c= new ArrayList<>();
               c=dao.find();
       request.setAttribute("cro", c);
     System.out.println(c.size());
     request.getRequestDispatcher("jsp/departShow.jsp").forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
