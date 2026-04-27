<%@ page import="java.util.*,com.model.StudentMark" %>
<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">
<h2>All Students</h2>

<table>
<tr>
<th>ID</th><th>Name</th><th>Subject</th><th>Marks</th><th>Date</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>) request.getAttribute("data");
for(StudentMark s : list){
%>

<tr>
<td><%=s.getStudentID()%></td>
<td><%=s.getStudentName()%></td>
<td><%=s.getSubject()%></td>
<td><%=s.getMarks()%></td>
<td><%=s.getExamDate()%></td>
</tr>

<% } %>

</table>
</div>

</body>
</html>