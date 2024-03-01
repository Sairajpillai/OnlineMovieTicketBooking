<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Movie Ticket Booking</title>

<style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Arial', sans-serif;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      position: relative;
    }

    .blur-background {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      filter: blur(5px);
      z-index: -1;
    }

    .card {
      background: rgba(255, 255, 255, 0.8); /* Adjust alpha value for translucency */
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      text-align: center;
      z-index: 1;
    }

    .welcome-text {
      font-size: 36px;
      margin-bottom: 20px;
    }

    .action-buttons {
      display: flex;
      justify-content: center;
    }

    .action-button {
      background-color: #ff5252;
      color: white;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      border-radius: 5px;
      margin: 0 10px;
      text-decoration: none;
      font-size: 18px;
      transition: filter 0.3s;
    }

    .action-button:hover {
      filter: brightness(90%);
    }
  </style>
</head>
<body>

<img class="blur-background" src="${pageContext.request.contextPath}/img/homepage.jpg" alt="Background Image">

<div class="card">
  <h1 class="welcome-text">Welcome to Online Movie Ticket Booking</h1>
  <div class="action-buttons">
    <a href="/OMTS/admin/adminLogin" class="action-button">Login</a>
    <!-- <a href="register.html" class="action-button">Register</a>-->
  </div>
</div>

</body>
</html>