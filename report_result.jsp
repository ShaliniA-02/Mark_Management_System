<%@ page import="java.util.*,com.model.StudentMark" %>

<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>
<!DOCTYPE html>
<html>
<head>
    <title>Report Result</title>
</head>
<body>

<h2>Report Results</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Exam Date</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>) request.getAttribute("data");

if(list != null){
    for(StudentMark s : list){
%>
<tr>
    <td><%=s.getStudentID()%></td>
    <td><%=s.getStudentName()%></td>
    <td><%=s.getSubject()%></td>
    <td><%=s.getMarks()%></td>
    <td><%=s.getExamDate()%></td>
</tr>
<%
    }
}
%>

</table>

</body>
</html>