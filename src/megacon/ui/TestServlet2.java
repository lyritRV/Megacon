package megacon.ui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

 
/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
        StringBuffer row = new StringBuffer("");
		row.append("[{\"id\":\"1\",\"description\":\"First appointment\",\"subject\":\"Test1\",\"calendar\":\"Room 1\",\"start\":\"2018-11-23T09:00:00\",\"end\":\"2018-11-23T16:00:00\"},");
		row.append("{\"id\":\"2\",\"description\":\"Second appointment\",\"subject\":\"Test2\",\"calendar\":\"Room 2\",\"start\":\"2018-11-24T09:00:00\",\"end\":\"2018-11-24T10:00:00\"},");
		row.append("{\"id\":\"3\",\"description\":\"Second appointment\",\"subject\":\"Test3\",\"calendar\":\"Room 3\",\"start\":\"2018-11-24T10:00:00\",\"end\":\"2018-11-24T11:00:00\"},");
		row.append("{\"id\":\"4\",\"description\":\"Second appointment\",\"subject\":\"Test4\",\"calendar\":\"Room 4\",\"start\":\"2018-11-24T11:00:00\",\"end\":\"2018-11-24T12:00:00\"},");
		row.append("{\"id\":\"5\",\"description\":\"Second appointment\",\"subject\":\"Test5\",\"calendar\":\"Room 5\",\"start\":\"2018-11-24T12:00:00\",\"end\":\"2018-11-24T13:00:00\"},");
		row.append("{\"id\":\"6\",\"description\":\"Second appointment\",\"subject\":\"Test6\",\"calendar\":\"Room 6\",\"start\":\"2018-11-24T13:00:00\",\"end\":\"2018-11-24T14:00:00\"},");
		row.append("{\"id\":\"7\",\"description\":\"Second appointment\",\"subject\":\"Test7\",\"calendar\":\"Room 7\",\"start\":\"2018-11-24T14:10:00\",\"end\":\"2018-11-24T14:50:00\"},");
		row.append("{\"id\":\"8\",\"description\":\"Second appointment\",\"subject\":\"Test8\",\"calendar\":\"Room 8\",\"start\":\"2018-11-24T15:00:00\",\"end\":\"2018-11-24T15:10:00\"},");
		row.append("{\"id\":\"9\",\"description\":\"Second appointment\",\"subject\":\"Test9\",\"calendar\":\"Room 9\",\"start\":\"2018-11-24T15:10:00\",\"end\":\"2018-11-24T15:40:00\"},");
		row.append("{\"id\":\"10\",\"description\":\"Second appointment\",\"subject\":\"Test10\",\"calendar\":\"Room 10\",\"start\":\"2018-11-24T15:40:00\",\"end\":\"2018-11-24T15:55:00\"},");
		row.append("{\"id\":\"11\",\"description\":\"Second appointment\",\"subject\":\"Test11\",\"calendar\":\"Room 11\",\"start\":\"2018-11-24T16:00:00\",\"end\":\"2018-11-24T16:20:00\"},");
		row.append("{\"id\":\"12\",\"description\":\"Second appointment\",\"subject\":\"Test12\",\"calendar\":\"Room 12\",\"start\":\"2018-11-24T16:20:00\",\"end\":\"2018-11-24T16:40:00\"},");
		row.append("{\"id\":\"13\",\"description\":\"Second appointment\",\"subject\":\"Test13\",\"calendar\":\"Room 13\",\"start\":\"2018-11-24T16:55:00\",\"end\":\"2018-11-24T17:00:00\"}]");
		out.print(row.toString());
		//handleRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//handleRequest(request, response);
		InputStream is = request.getInputStream();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buf = new byte[32];
        int r=0;
        while( r >= 0 ) {
            r = is.read(buf);
            if( r >= 0 ) os.write(buf, 0, r);
        }
        String s = new String(os.toByteArray(), "UTF-8");
        String decoded = URLDecoder.decode(s, "UTF-8");
        System.err.println(">>>>>>>>>>>>> DECODED: " + decoded);

        System.err.println("================================");

        Enumeration<String> e = request.getParameterNames();
        while( e.hasMoreElements() ) {
            String ss = (String) e.nextElement();
            System.err.println("    >>>>>>>>> " + ss);
        }

        System.err.println("================================");

        Map<String,String> map = makeQueryMap(s);
        System.err.println(map.get("id"));
        System.err.println(map.get("subject"));
        //////////////////////////////////////////////////////////////////
        //// HERE YOU CAN DO map.get("id") AND THE SENT VALUE WILL BE ////
        //// RETURNED AS EXPECTED WITH request.getParameter("id")     ////
        ///////////////jqxWidget08dae80ded4f/////////////////////////////////
        //////////////////////////////////////////////////////////////////
        System.err.println("================================");

        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().println("{'result':true}");
    }

    // Based on code from: http://www.coderanch.com/t/383310/java/java/parse-url-query-string-parameter
    private static Map<String, String> makeQueryMap(String query) throws UnsupportedEncodingException {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();
        for( String param : params ) {
            String[] split = param.split("=");
            map.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
        }
        return map;
    
	}
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		        PrintWriter out = response.getWriter();
		        response.setContentType("text/plain");
		        Enumeration<String> parameterNames = request.getParameterNames();
		        while (parameterNames.hasMoreElements()) {
		            String paramName = parameterNames.nextElement();
		            out.write(paramName);
		            out.write("n");
 
		            String[] paramValues = request.getParameterValues(paramName);
 
		            for (int i = 0; i < paramValues.length; i++) {
 
		                String paramValue = paramValues[i];
		 
		                out.write("t" + paramValue);
	 
		                out.write("n");
		 
		            }
		 
		        }
	 
		        out.close();
		
		    }

}
