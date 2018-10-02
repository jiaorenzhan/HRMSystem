package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartDAO;
import DAO.EmployeeDAO;
import DAO.JobsDAO;
import javaBean.Department;
import javaBean.Employee;
import javaBean.Jobs;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
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
	        String id= request.getParameter("eid");
	        System.out.println(id+"  "+"1");
	        String empname= request.getParameter("empname");
	        String mail = request.getParameter("email");
	        String phone= request.getParameter("phone_number");
	        String date= request.getParameter("hire_date");
	        String jid = request.getParameter("job_id"); 
	        String wage = request.getParameter("salary");
	        String departid = request.getParameter("department_id");
	  Employee emp = new  Employee();
	   emp.setEid(Integer.parseInt(id));
	      emp.setEname(empname);
	      emp.setEmail(mail);

	      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	      try {
			emp.setEdate(format.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      emp.setTel(phone);
	      emp.setWage(Integer.parseInt(wage));
	      
	     JobsDAO dao = new JobsDAO();
	     
	    Jobs job= dao.findByName(jid);
	     emp.setJob(job.getJname());
	     DepartDAO dao1 =new DepartDAO();
	      Department depart = dao1.findByName(departid);
	      emp.setDepart(depart.getDname());
	      EmployeeDAO  dao3=  new    EmployeeDAO();
	      dao3.insert(emp);
	         System.out.println(id+"  "+"1");
	         
	         request.getRequestDispatcher("/EmpViewServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
