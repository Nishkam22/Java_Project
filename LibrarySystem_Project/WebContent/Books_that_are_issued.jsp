
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

<h1 style="color:black;">Issued Books</h1>

 <table width="700" border="1" style="margin-top:60px; margin-left:0px;">

             <tr>
                    <th>Customer Id</th>
                    <th>Book Name</th>                    
                </tr>


<%ArrayList<Issuebookdata> st = (ArrayList<Issuebookdata>)request.getAttribute("data2");

        for(Issuebookdata s:st){%>
                    <tr>
                <td><%=s.getCustid()%></td>
                <td><%=s.getBookname()%></td><br>
            </tr>
            <%}     %>

</table>

</body>
</html>