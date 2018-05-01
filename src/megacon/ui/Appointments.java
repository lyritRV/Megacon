package megacon.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Appointments
 */
@WebServlet("/Appointments")
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointments() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        StringBuffer row = new StringBuffer("");
		row.append("[{\"id\":\"id1\",\"description\":\"First appointment\",\"subject\":\"Test1\",\"start\":\"2018-11-23T09:00:00\",\"end\":\"2018-11-23T16:00:00\"},");
		row.append("{\"id\":\"id2\",\"description\":\"Second appointment\",\"subject\":\"Test2\",\"start\":\"2018-11-24T09:00:00\",\"end\":\"2018-11-24T16:00:00\"}]");
		out.print(row.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuffer row = new StringBuffer("");
		row.append("[{\"id\":\"id1\",\"description\":\"First appointment\",\"subject\":\"Test1\",\"start\":\"2018-11-23T09:00:00\",\"end\":\"2018-11-23T16:00:00\"},");
		row.append("{\"id\":\"id2\",\"description\":\"Second appointment\",\"subject\":\"Test2\",\"start\":\"2018-11-24T09:00:00\",\"end\":\"2018-11-24T16:00:00\"}]");
		out.print(row.toString());
	}

}
