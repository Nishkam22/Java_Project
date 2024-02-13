<html>
<head>

<link rel="stylesheet" href="style.css">

</head>



<style>
body {background-color: black;}

</style>
<body>


<script src="main.js"></script>

<h1 style="color:gray;">Home Page</h1>

<div class="home-section">
<div class="row justify-content-between">

<form action="allbooks" method="post">
	
	<input type="submit" value="All Books" style="height:35px; width:100px">
</form>

<form action="issuedbooks" method="post">
	
	<input type="submit" value="Issued Books" style="height:35px; width:100px">
</form>


<button onclick="window.location='returnbook.jsp'" style="height:35px; width:100px">Return Book</button>


<button onclick="window.location='Searchbook.jsp'" style="height:35px; width:100px">Search book</button>



<button onclick="window.location='issuebook.jsp'" style="height:35px; width:100px">Issue book</button>


<button onclick="window.location='addbook.jsp'" style="height:35px; width:100px">Add book</button>

<form action="userslink" method="post">
	
	<input type="submit" value="Users" style="height:35px; width:100px">
</form>
</div>
</div>
</body>
</html>