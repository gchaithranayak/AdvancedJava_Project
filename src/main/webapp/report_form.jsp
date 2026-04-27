<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String type = request.getParameter("type");
%>

<!DOCTYPE html>
<html>
<head>
<title>Report Form</title>

<style>
body {
    font-family: 'Segoe UI', Arial;
    margin: 0;
    background: linear-gradient(to right, #5a0000, #f8f8f8);
}

/* Header */
.header {
    margin: 20px auto;
    max-width: 500px;
    padding: 20px;
    text-align: center;

    background: rgba(255, 255, 255, 0.25);
    backdrop-filter: blur(10px);
    border-radius: 20px;

    color: #5a0000;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

/* Form Box */
.form-box {
    background: rgba(255, 255, 255, 0.3);
    backdrop-filter: blur(10px);

    padding: 25px;
    width: 400px;
    margin: 30px auto;

    border-radius: 20px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
    text-align: center;
}

/* Inputs */
input {
    width: 90%;
    padding: 10px;
    margin: 10px;
    border-radius: 20px;
    border: 1px solid #ccc;
    outline: none;
}

/* Labels */
label {
    font-weight: bold;
    color: #5a0000;
}

/* Button */
button {
    width: 90%;
    padding: 10px;
    margin-top: 15px;

    background: linear-gradient(to right, #800000, #a00000);
    color: white;

    border: none;
    border-radius: 25px;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background: linear-gradient(to right, #a00000, #800000);
    transform: scale(1.05);
}

/* Back link */
a {
    display: block;
    text-align: center;
    margin-top: 20px;
    text-decoration: none;
    color: #800000;
    font-weight: bold;
}
</style>

</head>

<body>

<div class="header">
    <h2>📊 Generate Report</h2>
    <p>Enter report criteria</p>
</div>

<div class="form-box">

<form action="ReportServlet" method="post">
<input type="hidden" name="type" value="<%=type%>">

<% if("date".equals(type)) { %>

<label>From Date</label><br>
<input type="date" name="from" required><br>

<label>To Date</label><br>
<input type="date" name="to" required><br>

<% } else if("ailment".equals(type)) { %>

<input type="text" name="value" placeholder="Enter Ailment" required>

<% } else if("doctor".equals(type)) { %>

<input type="text" name="value" placeholder="Enter Doctor Name" required>

<% } %>

<button type="submit">Generate Report</button>

</form>

</div>

<a href="reports.jsp">⬅ Back</a>

</body>
</html>
