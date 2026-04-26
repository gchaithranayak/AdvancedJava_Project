<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.dao.HospitalDAO,com.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient List</title>
<style>
table {
    width:90%; margin:30px auto;
    border-collapse:collapse;
}
th, td {
    padding:10px; border:1px solid #ccc;
    text-align:center;
}
th { background:#3498db; color:white; }
</style>
</head>

<body>

<h2 style="text-align:center;">Patient Records</h2>

<table>
<tr>
<th>ID</th><th>Name</th><th>Age</th>
<th>Gender</th><th>Date</th>
<th>Ailment</th><th>Doctor</th>
</tr>

<%
HospitalDAO dao = new HospitalDAO();
List<Patient> list = dao.getAllPatients();

for(Patient p : list){
%>

<tr>
<td><%=p.getPatientID()%></td>
<td><%=p.getPatientName()%></td>
<td><%=p.getAge()%></td>
<td><%=p.getGender()%></td>
<td><%=p.getAdmissionDate()%></td>
<td><%=p.getAilment()%></td>
<td><%=p.getAssignedDoctor()%></td>
</tr>

<% } %>
