<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">
<h2>Add Marks</h2>

<div class="form-box">
<form action="add" method="post">

Name:
<input type="text" name="name" required>

Subject:
<input type="text" name="subject" required>

Marks:
<input type="number" name="marks" min="0" max="100" required>

Date:
<input type="date" name="date" required>

<button type="submit">Add</button>

</form>

<p style="color:red;">${msg}</p>
</div>

</div>
</body>
</html>