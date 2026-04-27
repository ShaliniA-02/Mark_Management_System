<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">

    <div class="topbar" style="display: flex; justify-content: space-between; align-items: center;">
        <h2>Top N Students</h2>
        <a href="reports.jsp" class="back-btn">&larr; Back</a>
    </div>

    <div class="card" style="max-width: 400px;">

        <h3>Enter Number of Top Students</h3>

        <form action="report" method="post">
            <input type="hidden" name="type" value="top">

            <label>Number of Students:</label><br><br>
            <input type="number" name="n" min="1" required style="width: 100%; padding: 8px; margin-bottom: 15px; box-sizing: border-box;">

            <button type="submit">Generate Report</button>
        </form>

    </div>

</div>

</body>
</html>