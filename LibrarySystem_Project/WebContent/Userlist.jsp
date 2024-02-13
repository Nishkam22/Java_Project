
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

<h1 style="color:black;">All Users</h1>

 <table width="700" border="5" style="margin-top:-160px; margin-left:0px;">

             <tr>
                   
                    <th>name</th>
                    <th>address</th>
                    <th>password</th>
                    <th>age</th>
                    <th>custid</th>
                </tr>


<%ArrayList<User_data> stm = (ArrayList<User_data>)request.getAttribute("data6");

        for(User_data s:stm){%>
                    <tr>
               
                <td><%=s.getName()%></td>
                <td><%=s.getAddress()%></td>
                <td><%=s.getPassword()%></td>
                <td><%=s.getAge()%></td>
                <td><%=s.getCustid()%></td><br>
            </tr>
            <%}     %>

</table>

</body>
</html>