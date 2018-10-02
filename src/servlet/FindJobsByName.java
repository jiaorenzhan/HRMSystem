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
 * Servlet implementation class FindJobsByName
 */
@WebServlet("/FindJobsByName")
public class FindJobsByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindJobsByName() {
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
		String id= request.getParameter("jid");
		JobsDAO dao =new JobsDAO();
	Jobs job=	dao.findByName(id);
	System.out.println(job.getJname()+"  ");
		request.setAttribute("a",job);
		 request.getRequestDispatcher("jsp/UpdateJobs.jsp").forward(request, response);
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
