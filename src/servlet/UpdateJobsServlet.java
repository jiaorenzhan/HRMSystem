package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DepartDAO;
import DAO.JobsDAO;
import javaBean.Department;
import javaBean.Jobs;

/**
 * Servlet implementation class UpdateJobsServlet
 */
@WebServlet("/UpdateJobsServlet")
public class UpdateJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateJobsServlet() {
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
		  String jid = request.getParameter("job_id");
		  String jname= request.getParameter("job_title");
		  String min = request.getParameter("min_salary");
		  String max = request.getParameter("max_salary");
		  Jobs job =new Jobs();
		  job.setJid(jid);
		  job.setJname(jname);
		  job.setMinwage(Double.parseDouble(min));
		  job.setMaxwage(Double.parseDouble(max));
	     JobsDAO dao = new JobsDAO();
	      dao.updateJobs(job);
	      System.out.println(jname+"  "+"1");
	       request.getRequestDispatcher("/JobsViewServlet").forward(request, response);
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
