<html>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.util.*"%>
	<%!Connection con;
	Statement st;
	ResultSet rs;
	int no;
	String type, img, name, isbn, bname;
	int price, qty, amt, sum = 0;%>
	<%
 String uname = (String) session.getAttribute("user");
if (uname != null)
 {
%>
	<h3><%=uname%>'s cart Details.
	</h3>
	<br>
	<%
 Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3307/onlinestore";
con = DriverManager.getConnection(url, "root", "");
 st = con.createStatement();
PreparedStatement ps;
ps = con.prepareStatement("select name,price from books where isbn = ?");
 Hashtable list = (Hashtable) session.getAttribute("list");
 if (list != null)
 {
%>
	<center>
		<table border=2>
			<tr>
				<th>Book Name
				<th>Price
				<th>Quantity
				<th>Amount
			</tr>
			<%
 Enumeration e = list.keys();
 while (e.hasMoreElements()) { 
 String isbn = (String) e.nextElement();
 String q = (String) list.get(isbn);
 ps.setString(1, isbn);
 rs = ps.executeQuery();
 if (rs.next()) {
 bname = rs.getString(1);
 price = rs.getInt(2);
 qty = Integer.parseInt(q);
 amt = price * qty;
 sum = sum + amt;
 }
%>
			<tr>
				<td><%=bname%>
				<td align=right><%=price%>
				<td align=right><%=qty%>
				<td align=right><%=amt%>
			</tr>
			<%
 }
%>
			<tr>
				<td colspan=3><b>Total Amount :
						<td align=right><%=sum%>
			</tr>
		</table>
		<%
 }
else
 out.println("Now Your Cart is empty");
 }
else
out.println("First <a href=\"./login.html\">LOGIN</a> to your account for shopping");
%>
	
</body>
</html>
