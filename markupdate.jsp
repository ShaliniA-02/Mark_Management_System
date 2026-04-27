<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">
<h2>Update Marks</h2>

<div class="form-box">
<form action="update" method="post">

ID:
<input type="number" name="id" required>

Name:
<input type="text" name="name">

Subject:
<input type="text" name="subject">

Marks:
<input type="number" name="marks" min="0" max="100">

Date:
<input type="date" name="date">

<button>Update</button>

</form>
</div>
</div>

</body>
</html>