<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>

<style>
body {
    font-family: Arial;
    background: #eaf2f8;
    text-align: center;
}

h2 {
    color: #2c3e50;
}

form {
    background: white;
    padding: 20px;
    width: 350px;
    margin: auto;
    border-radius: 10px;
    box-shadow: 0px 0px 10px gray;
}

input, select {
    width: 90%;
    padding: 8px;
    margin: 8px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

input[type="submit"] {
    background: #2ecc71;
    color: white;
    border: none;
    cursor: pointer;
}

input[type="submit"]:hover {
    background: #27ae60;
}

a {
    display: block;
    margin-top: 20px;
    text-decoration: none;
    color: #2980b9;
}
</style>

</head>
<body>

<h2>Add Patient</h2>

<form action="AddPatientServlet" method="post">

    <input type="number" name="id" placeholder="Patient ID" required>

    <input type="text" name="name" placeholder="Patient Name" required>

    <input type="number" name="age" placeholder="Age" required>

    <select name="gender">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select>

    <input type="date" name="date" required>

    <input type="text" name="ailment" placeholder="Ailment">

    <input type="text" name="doctor" placeholder="Assigned Doctor">

    <input type="submit" value="Add Patient">

</form>

<a href="index.jsp">⬅ Back to Home</a>

</body>
</html>