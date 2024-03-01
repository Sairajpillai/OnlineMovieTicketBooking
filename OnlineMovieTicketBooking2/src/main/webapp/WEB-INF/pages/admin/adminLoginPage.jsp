<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url('${pageContext.request.contextPath}/img/homepage.jpg') center/cover no-repeat;
            overflow: hidden;
            backdrop-filter: blur(10px);
        }

        .card {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
            position: relative;
        }

        .card::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: linear-gradient(rgba(255,255,255,0), rgba(255,255,255,0.8));
            z-index: -1;
            border-radius: 8px;
        }

        img {
            width: 100px;
            border-radius: 50%;
            margin-bottom: 15px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #3498db;
            color: #fff;
            padding: 10px;
            border: none;
            width: 100%;
            border-radius: 4px;
            cursor: pointer;
        }
       .notification-container {
    position: fixed;
    top: 20%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #f44336;
    color: white;
    padding: 15px;
    border-radius: 5px;
    display: block;
    z-index: 1000;
}

.notification-close {
    cursor: pointer;
    position: absolute;
    top: 5px;
    right: 10px;
    font-size: 20px;
    font-weight: bold;
}


        
        
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body><!--  
<div class="blur-container"></div>
 <div class="card">
        <img src="${pageContext.request.contextPath}/img/homepage.jpg" alt="User Image">
        <form method="post">
            <input type="text" placeholder="Loginid" name="loginid" required>
            <input type="password" placeholder="Password" name="password" required>
            <button type="submit"  onclick="submitLoginForm()">Login</button>
        </form>
    </div>
    
    

<script>
    function submitLoginForm() {
        var loginId = $('#loginid').val();
        var password = $('#password').val();

        var loginData = {
            loginId: loginId,
            password: password
        };

        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/admin/login',
            contentType: 'application/json',
            data: JSON.stringify(adminLogin),
            success: function(response) {
                console.log(response);
                // Handle the response as needed
            },
            error: function(error) {
                console.error(error);
                // Handle errors
            }
        });
    }
</script>-->
<div class="blur-container"></div>
 <div class="card">
 <img src="${pageContext.request.contextPath}/img/homepage.jpg" alt="User Image">
        <form:form action="${pageContext.request.contextPath}/admin/adminLogin" method="post" modelAttribute="adminLogin">
            <form:input path="loginId" placeholder="Username" required="true"/>
            <form:input path="password" placeholder="Password" type="password" required="true"/>
            <button type="submit">Login</button>
             <c:if test="${isAdmin eq 'failure'}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">Invalid Username or Password</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 3000);
    </script>
        </c:if>
        
        <c:if test="${isAdmin eq 'sessionExpired'}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">Session Expired Login in Again</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 3000);
    </script>
        </c:if>
        </form:form>
    </div>
    
   
    
</body>
</html>