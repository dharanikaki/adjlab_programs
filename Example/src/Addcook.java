

import javax.servlet.* ;
import javax.servlet.http.*;
import java.io.*;
public class Addcook extends HttpServlet
{
	String user,pas;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Cookie c1=new Cookie("usr1","suni");
		Cookie p1=new Cookie("pwd1","ani");
		Cookie c2=new Cookie("usr2","abc");
		Cookie p2=new Cookie("pwd2","123");
		Cookie c3=new Cookie("usr3","def");
		Cookie p3=new Cookie("pwd3","456");
		Cookie c4=new Cookie("usr4","mno");
		Cookie p4=new Cookie("pwd4","789");
		res.addCookie(c1);
		res.addCookie(p1);
		res.addCookie(c2);
		res.addCookie(p2);
		res.addCookie(c3);
		res.addCookie(p3);
		res.addCookie(c4);
		res.addCookie(p4);
		out.println("COOKIE ADDED");
	}
}