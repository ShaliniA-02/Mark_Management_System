<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
</head>
<body>

<jsp:include page="sidebar.jsp"/>

<div class="main">

    <div class="topbar" style="display: flex; justify-content: space-between; align-items: center;">
        <h2>Above Marks Report</h2>
        <a href="reports.jsp" class="back-btn">&larr; Back</a>
    </div>

    <div class="card" style="max-width: 400px;">

        <h3>Filter Students Above Marks</h3>

        <form action="report" method="post">
            <input type="hidden" name="type" value="above">

            <label>Enter Marks</label><br><br>
            <input type="number" name="marks" min="0" max="100" required
                   style="width: 100%; padding: 8px; margin-bottom: 15px; box-sizing: border-box;">

            <button type="submit">Generate Report</button>
        </form>

    </div>

</div>

</body>
</html>