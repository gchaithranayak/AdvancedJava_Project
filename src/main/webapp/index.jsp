<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Management System</title>

<style>
body {
    font-family: Arial;
    background: #f0f8ff;
    text-align: center;
}

h1 {
    color: #2c3e50;
}

.container {
    margin-top: 50px;
}

a {
    display: block;
    margin: 10px;
    padding: 12px;
    width: 250px;
    background: #3498db;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    margin-left: auto;
    margin-right: auto;
}

a:hover {
    background: #2980b9;
}

.msg {
    font-size: 18px;
    margin: 20px;
}
</style>

</head>
<body>

<h1>🏥 Hospital Management System</h1>

<!-- MESSAGE DISPLAY -->
<%
String msg = request.getParameter("msg");

if ("success".equals(msg)) {
%>
    <div class="msg" style="color:green;">Patient Added Successfully</div>
<%
} else if ("fail".equals(msg)) {
%>
    <div class="msg" style="color:red;">Insert Failed (Check ID / Duplicate)</div>
<%
} else if ("error".equals(msg)) {
%>
    <div class="msg" style="color:red;">Something went wrong!</div>
<%
}
%>

<div class="container">

    <a href="patientadd.jsp">Add Patient</a>
    <a href="patientupdate.jsp">Update Patient</a>
    <a href="patientdelete.jsp">Delete Patient</a>
    <a href="DisplayPatientsServlet">View Patients</a>
    <a href="reports.jsp">Reports</a>

</div>

</body>
</html>