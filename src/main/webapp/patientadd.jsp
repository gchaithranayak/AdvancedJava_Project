<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Patient</title>

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

/* Form Container */
.form-box {
    background: rgba(255, 255, 255, 0.3);
    backdrop-filter: blur(10px);

    padding: 25px;
    width: 400px;
    margin: 30px auto;

    border-radius: 20px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

/* Inputs */
input, select {
    width: 90%;
    padding: 10px;
    margin: 10px;
    border-radius: 20px;
    border: 1px solid #ccc;
    outline: none;
}

/* Button */
input[type="submit"] {
    background: #800000;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 25px;
    font-weight: bold;
}

input[type="submit"]:hover {
    background: #a00000;
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
    <h2>➕ Add Patient</h2>
    <p>Enter patient details below</p>
</div>

<div class="form-box">

<form action="AddPatientServlet" method="post">

    <input type="text" name="name" placeholder="Patient Name" required>

    <input type="number" name="age" placeholder="Age" required>

    <select name="gender">
        <option value="">Select Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
    </select>

    <input type="date" name="date" required>

    <input type="text" name="ailment" placeholder="Ailment">

    <input type="text" name="doctor" placeholder="Assigned Doctor">

    <input type="submit" value="Add Patient">

</form>

</div>

<a href="index.jsp">⬅ Back to Home</a>

</body>
</html>
