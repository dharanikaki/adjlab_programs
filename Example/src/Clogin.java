

import javax.servlet.* ;
import javax.servlet.http.*;
import java.io.*;
public class Clogin extends HttpServlet
{
	String user,pas;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		user=req.getParameter("usr");
		pas=req.getParameter("pwd");
		Cookie[] c=req.getCookies();
		for(int i=0;i<c.length;i++)
		{
			if((c[i].getName().equals("usr1")&&c[i+1].getName().equals("pwd1"))|| c[i].getName().equals("usr2") &&c[i+1].getName().equals("pwd2"))||(c[i].getName().equals("usr3")&& c[i+1].getName().equals("pwd3"))||(c[i].getName().equals("usr4")&& c[i+1].getName().equals("pwd4") ))
{
	if((user.equals(c[i].getValue()) && pas.equals(c[i+1].getValue())) )
	{    
		//RequestDispatcher rd=req.getRequestDispatcher("/cart.html");
		rd.forward(req,res);
	}
	else
	{
		out.println("YOU ARE NOT AUTHORISED USER ");
		//res.sendRedirect("/cookdemo/cologin.html");
	}
}
		}
	}
}