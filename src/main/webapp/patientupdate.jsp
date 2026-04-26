<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Patient</title>
<style>
body { font-family:Arial; background:#eef2f3; }
.container {
    display:flex; justify-content:center;
    margin-top:50px;
}
.box {
    padding:20px; background:white;
    border-radius:10px; width:400px;
}
input { width:100%; margin:10px 0; padding:8px; }
button {
    background:#f39c12; color:white;
    padding:10px; border:none; width:100%;
}
</style>
</head>

<body>

<div class="container">
<div class="box">
<h2>Update Patient</h2>

<form action="UpdatePatientServlet" method="post">
<input type="number" name="id" placeholder="Patient ID" required>
<input type="text" name="name" placeholder="New Name">
<input type="number" name="age" placeholder="New Age">
<input type="text" name="ailment" placeholder="New Ailment">
<input type="text" name="doctor" placeholder="New Doctor">

<button type="submit">Update</button>
</form>
</div>
</div>

</body>
</html>