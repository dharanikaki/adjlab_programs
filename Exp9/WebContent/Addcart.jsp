<%@ page import="java.util.*"%>
<%!Hashtable blist;%>
<%
	String user = (String) session.getAttribute("user");
	if (user != null) {
		blist = (Hashtable) session.getAttribute("list");
		if (blist == null) {
			blist = new Hashtable();
			blist.put(request.getParameter("isbn"), request.getParameter("quantity"));
			session.setAttribute("list", blist);
		} else {
			blist.put(request.getParameter("isbn"), request.getParameter("quantity"));
			session.setAttribute("list", blist);
		}
%>
<h3>
	The selected book is added successfully to your cart.If you want to
	continue to shop...<br> Please <a href="./catalog.jsp">click
		here ..</a>
	<%
		} else
			out.println("<h3>First Login to Book Store</h3>");
	%>