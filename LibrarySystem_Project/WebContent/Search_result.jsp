
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

<h1 style="color:black;">Search Results</h1>

 <table width="700" border="1" style="margin-top:60px; margin-left:0px;">

             <tr>
                    <th>Book Id</th>
                    <th>Book Name</th>
                    <th>Price</th>                    
                </tr>


<%ArrayList<Searchdata> stq = (ArrayList<Searchdata>)request.getAttribute("data3");

        for(Searchdata s:stq){%>
                    <tr>
                <td><%=s.getBookid()%></td>
                <td><%=s.getBookname()%></td>
                <td><%=s.getPrice()%></td><br>
            </tr>
            <%}     %>

</table>
<br/><br/><br/>
<button onclick="window.location='Homepage.jsp'">Homepage</button>
</body>
</html>