package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
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
	
		  String ename= request.getParameter("empname");
		  String email = request.getParameter("email");
		  String phone = request.getParameter("phone_number");
		  String  date = request.getParameter("hire_date");
		  String jobid = request.getParameter("job_id");
		  String departid = request.getParameter("department_id");
		  String eid = request.getParameter("employee_id");
		  
		 Employee emp  =new Employee();
		    emp.setEid(Integer.parseInt(eid));
		    emp.setEname(ename);
		    emp.setEmail(email);
		    emp.setTel(phone);	 
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    try {
				emp.setEdate(format.parse(date));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     JobsDAO dao1= new JobsDAO();
		     Jobs job= dao1.findByName(jobid);
		     
		     emp.setJob(job.getJname());
		     DepartDAO dao2 = new DepartDAO();
		     Department depart = dao2.findByName(departid);
		     
		    emp.setDepart(depart.getDname());
		    
	   EmployeeDAO dao = new  EmployeeDAO();
	      dao.updateEmployee(emp);
	      System.out.println(job+"  "+"1");
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
