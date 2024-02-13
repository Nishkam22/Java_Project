
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="dao.*"%>
<html>
<head>

<link rel="stylesheet" href="style.css">

</head>
<style>
body {background-color: powderblue;}

</style>
<body>

<h1 style="color:black;">All Books</h1>

 <table width="700" border="3" style="margin-top:-160px; margin-left:0px;">

             <tr>
                    <th>Book Id</th>
                    <th>Book Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>


<%ArrayList<Allbookdata> std = (ArrayList<Allbookdata>)request.getAttribute("data");

        for(Allbookdata s:std){%>
                    <tr>
                <td><%=s.getBookid()%></td>
                <td><%=s.getBookname()%></td>
                <td><%=s.getPrice()%></td>
                <td><%=s.getQuantity()%></td><br>
            </tr>
            <%}     %>

</table>

</body>
</html>