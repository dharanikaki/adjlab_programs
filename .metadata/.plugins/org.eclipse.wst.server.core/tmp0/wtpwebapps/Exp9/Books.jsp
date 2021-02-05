<html>
<head>
<script language="javascript">
function getQuantity(isbn,index)
{
var q=prompt("Enter Quantity");
var link="./addcart.jsp?isbn="+isbn+"&quantity="+q;
document.links[index].href=link;
}
</script>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%!Connection con;
	Statement st;
	ResultSet rs;
	int no;
	String type, img, name, au, pub, pr;%>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3307/onlinestore";
		con = DriverManager.getConnection(url, "root", "");
		st = con.createStatement();
		type = request.getParameter("type");
		PreparedStatement ps;
		ps = con.prepareStatement("select * from books where type=?");
		ps.setString(1, type);
		rs = ps.executeQuery();
	%>
	<h3><%=type%>
		Books
	</h3>
	<br>
	<br>
	<br>
	<table border=2>
		<tr>
			<td>Book Image
			<td>Book Details
			<td>Price
			<td>Adding to Cart
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<%
				img = rs.getString(5);
			%>
			<td><img src=".\imgs\<%=img%>.JPG"> <%
 	name = rs.getString(1);
 		au = rs.getString(2);
 		pub = rs.getString(3);
 		pr = rs.getString(4);
 %>
			<td>Book Name:<b><%=name%></b><br> Author:<b><%=au%></b><br>
				Publication:<b><%=pub%></b>
			<td><b><%=pr%></b>
			<a href=# onClick=getQuantity></a>
			<img src="./imgs/cart.JPG"> <%
 }
%>
					</html>
</body>