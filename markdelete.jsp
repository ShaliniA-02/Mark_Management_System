<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">
<h2>Delete Student</h2>

<div class="form-box">
<form action="delete" method="post">

ID:
<input type="number" name="id" required>

<button>Delete</button>

</form>

<p style="color:red;">${msg}</p>

</div>
</div>

</body>
</html>