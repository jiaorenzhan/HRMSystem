package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeDAO;
import javaBean.Employee;

/**
 * Servlet implementation class FindEmpById
 */
@WebServlet("/FindEmpById")
public class FindEmpById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindEmpById() {
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
		  String eid = request.getParameter("eid");
		  EmployeeDAO dao = new EmployeeDAO();
		Employee emp=  dao.findByName(Integer.parseInt(eid));
		request.setAttribute("cro", emp);
		 request.getRequestDispatcher("jsp/updateEmp.jsp").forward(request, response);
		  
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
