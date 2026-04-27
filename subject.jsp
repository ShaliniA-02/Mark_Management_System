<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">

    <div class="topbar" style="display: flex; justify-content: space-between; align-items: center;">
        <h2>Subject Report</h2>
        <a href="reports.jsp" class="back-btn">&larr; Back</a>
    </div>

    <div class="card" style="max-width: 400px;">

        <h3>Search by Subject</h3>

        <form action="report" method="post">
            <input type="hidden" name="type" value="subject">

            <label>Subject:</label><br><br>
            <input type="text" name="subject" required 
                   style="width: 100%; padding: 8px; margin-bottom: 15px; box-sizing: border-box;">

            <button type="submit">Generate Report</button>
        </form>

    </div>

</div>

</body>
</html>