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
body { text-align:center; font-family:Arial; }
input { margin:10px; padding:8px; }
button { padding:10px; background:green; color:white; border:none; }
</style>
</head>

<body>

<h2>Enter Criteria</h2>

<form action="ReportServlet" method="post">
<input type="hidden" name="type" value="<%=type%>">

<% if("date".equals(type)) { %>

From: <input type="date" name="from" required><br>
To: <input type="date" name="to" required><br>

<% } else if("ailment".equals(type)) { %>

<input type="text" name="value" placeholder="Enter Ailment" required>

<% } else if("doctor".equals(type)) { %>

<input type="text" name="value" placeholder="Enter Doctor Name" required>

<% } %>

<br>
<button type="submit">Generate Report</button>

</form>

</body>
</html>