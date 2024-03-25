<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>

<%@ include file="../html/adminheader.html" %>
<c:choose>
<%--<c:when test="${isAdmin eq 'success' }">--%>
<c:when test="${sessionScope.isAdmin eq 'success'}">
<div class="box-container">
    <div class="box"><a href="${pageContext.request.contextPath}/admin/addMovie">Add Movie</a></div>
    <div class="box"><a href="${pageContext.request.contextPath}/admin/searchMovie">Search Movie</a></div>
    <div class="box"><a href="${pageContext.request.contextPath}/admin/updateMovie">Update Movie</a></div>
    <div class="box"><a href="${pageContext.request.contextPath}/admin/movieDeletePage">Delete Movie</a></div>
</div>
<div class="box-container">
    <div class="box1"><a href="${pageContext.request.contextPath}/casting/addCasting">Add Casting</a></div>
    <div class="box1"><a href="${pageContext.request.contextPath}/casting/searchCasting">Search Casting</a></div>
    <div class="box1"><a href="${pageContext.request.contextPath}/casting/updateCasting">Update Casting</a></div>
    <div class="box1"><a href="${pageContext.request.contextPath}/casting/deleteCasting">Delete Casting</a></div>
</div>
 <c:if test="${saveResult ne null}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">${saveResult }</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 4000);
    </script>
        </c:if>
        
        <c:if test="${updateResult ne null}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">Movie Updated Successfully</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 4000);
    </script>
        </c:if>
        
        <c:if test="${movieDeleteStatus ne null}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">Movie Deleted Successfully</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 4000);
    </script>
        </c:if>
        
        <c:if test="${castingDeleteStatus ne null}">
            <!--  <p style="color: red;">Invalid Username or Password</p>-->
             <div id="notification" class="notification-container">
        <span class="notification-text">Casting Deleted Successfully</span>
        <span class="notification-close" onclick="closeNotification()">×</span>
    </div>

    <script>
        function closeNotification() {
            var notification = document.getElementById('notification');
            notification.style.display = 'none';
        }
        setTimeout(function () {
            closeNotification();
        }, 4000);
    </script>
        </c:if>

</c:when>
<c:otherwise>
You are not authorized to view this page
</c:otherwise>
</c:choose>
</body>
</html>
<%@ include file="../html/adminfooter.html" %>