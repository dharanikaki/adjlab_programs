<html>
<body>
	<%@ page import="java.sql.*"%>
	<%!Connection con;
	Statement st;
	ResultSet rs;
	int no;
	String q, name1, pwd1, email1, pass;%>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3307/onlinestore";
		con = DriverManager.getConnection(url, "root", "");
		st = con.createStatement();
		name1 = request.getParameter("namefld");
		pwd1 = request.getParameter("passfld");
		PreparedStatement ps;
		ps = con.prepareStatement("select pass from user1 where name=?");
		ps.setString(1, name1);
		rs = ps.executeQuery();
		rs.next();
		int r = rs.getRow();
		if (r > 0) {
			pass = rs.getString(1);
			if (pwd1.equals(pass)) {
				session.setAttribute("user1", name1);
				out.println(name1 + " !!!<h3>Welcome to our book store web portal.");
				out.println("You have successfully logged </h3>");
			} else
				out.println("<h3>Invalid Password.Please <a href='./index.html'>Login </a>again</h3>");
		} else
			out.println("<h3>Invalid User name.Please <a href='./index.html'>Login </a>again</h3>");
	%>

</html>
</body>
