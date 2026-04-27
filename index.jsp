<%@ page import="com.dao.MarkDAO" %>
<%@ page import="com.dao.MarkDAO" %>
<%
    MarkDAO dao = new MarkDAO();
    int totalStudents = dao.getTotalStudents();
    int totalSubjects = dao.getTotalSubjects();
    double avgMarks = dao.getAverageMarks();
    int topMarks = dao.getTopMarks();
%>

<html>
<head>
<link rel="stylesheet" href="style.css">
<title>Dashboard</title>
</head>

<body>

<div class="sidebar">
    <h2>Student Mark System</h2>
    <div class="menu">
        <a href="index.jsp" class="active">Dashboard</a>
        <a href="markadd.jsp">Add Marks</a>
        <a href="markdisplay">View Marks</a>
        <a href="markupdate.jsp">Update Marks</a>
        <a href="markdelete.jsp">Delete Marks</a>
        <a href="reports.jsp">Reports</a>
    </div>
</div>

<div class="main">
    <h1>Dashboard</h1>
    <p>Welcome to Student Mark Management System</p>

    <div class="cards">
        <div class="card">
            <h3>Total Students</h3>
            <h1><%= totalStudents %></h1>
        </div>

        <div class="card">
            <h3>Total Subjects</h3>
            <h1><%= totalSubjects %></h1>
        </div>

        <div class="card">
            <h3>Average Marks</h3>
            <h1><%= String.format("%.1f", avgMarks) %></h1>
        </div>

        <div class="card">
            <h3>Highest Marks</h3>
            <h1><%= topMarks %></h1>
        </div>
    </div>
</div>

</body>
</html>