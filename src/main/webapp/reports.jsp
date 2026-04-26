<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reports</title>
<style>
body { text-align:center; font-family:Arial; }
form {
    margin:15px;
}
button {
    padding:12px;
    width:250px;
    background:#8e44ad;
    color:white;
    border:none;
}
</style>
</head>

<body>

<h2>Reports</h2>

<form action="ReportCriteriaServlet" method="post">
    <input type="hidden" name="type" value="date">
    <button type="submit">Patients by Date</button>
</form>

<form action="ReportCriteriaServlet" method="post">
    <input type="hidden" name="type" value="ailment">
    <button type="submit">Patients by Ailment</button>
</form>

<form action="ReportCriteriaServlet" method="post">
    <input type="hidden" name="type" value="doctor">
    <button type="submit">Patients by Doctor</button>
</form>

</body>
</html>