<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Patient</title>
<style>
body { background:#fff3f3; font-family:Arial; text-align:center; }
.box {
    margin:100px auto; width:300px;
    background:white; padding:20px;
    border-radius:10px;
    box-shadow:0 0 10px red;
}
input { width:100%; padding:8px; margin:10px 0; }
button {
    background:red; color:white;
    padding:10px; border:none; width:100%;
}
</style>
</head>

<body>

<div class="box">
<h2>⚠ Delete Patient</h2>

<form action="DeletePatientServlet" method="post">
<input type="number" name="id" placeholder="Enter Patient ID" required>
<button type="submit">Delete</button>
</form>
</div>

</body>
</html>