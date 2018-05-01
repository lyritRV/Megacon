package megacon.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesteServlet3
 */
@WebServlet("/TesteServlet3")
public class TesteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        StringBuffer row = new StringBuffer("");
		row.append("[{\"id\":\"1\",\"description\":\"First appointment\",\"subject\":\"Test1\",\"start\":\"2018-11-23T09:00:00\",\"end\":\"2018-11-23T16:00:00\"}]");
		//row.append("{\"id\":\"2\",\"description\":\"Second appointment\",\"subject\":\"Test2\",\"start\":\"2018-11-24T09:00:00\",\"end\":\"2018-11-24T10:00:00\"},");
		//row.append("{\"id\":\"3\",\"description\":\"Second appointment\",\"subject\":\"Test3\",\"start\":\"2018-11-24T10:00:00\",\"end\":\"2018-11-24T11:00:00\"},");
		//row.append("{\"id\":\"4\",\"description\":\"Second appointment\",\"subject\":\"Test4\",\"start\":\"2018-11-24T11:00:00\",\"end\":\"2018-11-24T12:00:00\"}]");
		out.print(row.toString());
		//handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
