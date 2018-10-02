package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class UpdateDeptServlet
 */
@WebServlet("/UpdateDeptServlet")
public class UpdateDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeptServlet() {
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
		  String did = request.getParameter("department_id");
		  String dname= request.getParameter("department_name");
		  String adress = request.getParameter("location_name");
		  Department depart =new Department();
		  depart.setDid(Integer.parseInt(did));
		  depart.setDname(dname);
		  depart.setAddress(adress);
	     DepartDAO dao = new DepartDAO();
	      dao.updateDepartment(depart);
	      System.out.println(did+"  "+"1");
	       request.getRequestDispatcher("/DeptViewServlet").forward(request, response);
	     
	       //   response.sendRedirect("/DeptViewServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
