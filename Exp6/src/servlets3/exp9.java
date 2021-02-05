package servlets3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exp9
 */
@WebServlet("/exp9")
public class exp9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exp9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  String value=request.getParameter("website");
		  if(value.equals("google")) {
		   response.sendRedirect("https://www.google.com");
		  }
		  else if(value.equals("gmail")) {
		   response.sendRedirect("https://www.gmail.com");
		  }
		  else if(value.equals("facebook")) {
		   response.sendRedirect("https://www.facebook.com");
		  }
		  else if(value.equals("instagram")) {
		   response.sendRedirect("https://www.instagram.com");
		  }
		  else if(value.equals("myntra")) {
		   response.sendRedirect("https://www.myntra.com/");
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
