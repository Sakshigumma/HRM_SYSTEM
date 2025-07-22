<%-- 
    Document   : submit_availability
    Created on : 20 Jul, 2025, 7:39:00 PM
    Author     : hp
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%
    if (session.getAttribute("user_id") == null) {
        response.sendRedirect("index.html");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Submit Availability</title>
    <style>
       body {
            background-image: url('dash.jpg');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .wrapper {
            max-width: 700px;
            margin: 50px auto;
            background: #080808c8;
            padding: 25px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.529);
            border: 2px solid rgb(6, 6, 6);
        }
        h2, h3 {
            margin-bottom: 20px;
            color: #fdfdfd;
        }
        label {
            display: block;
            margin-top: 12px;
            font-weight: 500;
            color: #fefefe;
        }
        input[type="date"],
        input[type="time"],
        button {
            width: 45%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15px;
        }
        .checkbox-group {
            margin-top: 10px;
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
        }
        .checkbox-group label {
            display: flex;
            align-items: center;
            gap: 6px;
            font-weight: normal;
            cursor: pointer;
        }
        button {
            margin-top: 20px;
            background-color: #3498db;
            color: #fff;
            border: none;
            cursor: pointer;
            width: 200px;
            box-shadow: 5px 5px 5px rgb(59, 0, 251);
        }
        button:hover {
            background-color: #2980b9;
        }
        hr {
            margin: 40px 0 30px;
            border: 0;
            border-top: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <h2 style="text-align: center;">Weekly Availability Form</h2>
        <form action="submit_availability_action.jsp" method="post">
            <label for="week_start">Week Start Date:</label>
            <input type="date" name="week_start" id="week_start" required>

            <h3 style="color: white;">Select Days You're Available:</h3>
            <div class="checkbox-group">
                <label><input type="checkbox" name="mon"> Monday</label>
                <label><input type="checkbox" name="tue"> Tuesday</label>
                <label><input type="checkbox" name="wed"> Wednesday</label>
                <label><input type="checkbox" name="thu"> Thursday</label>
            </div>

            <button type="submit">Save Availability</button>
        </form>

        <hr>

        <h2>Log Your Working Hours</h2>
        <form action="LogTimeServlet" method="post">
            <label for="loginDate">Date:</label>
            <input type="date" name="loginDate" id="loginDate" required>

            <label for="loginTime">Login Time:</label>
            <input type="time" name="loginTime" id="loginTime" required>

            <label for="logoutTime">Logout Time:</label>
            <input type="time" name="logoutTime" id="logoutTime" required>

            <br>
            <button type="submit">Log Hours</button>
        </form>
    </div>
</body>
</html>
