<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie</title>
<style>
.registration-box {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }

        .registration-content {
            background-color: #ffffff;
            border: 1px solid #dddddd;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        button {
            padding: 10px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
</style>
</head>
<%@include file="../html/adminheaderinside.html"%>

<div class="registration-box">
        <div class="registration-content">
            <h2>Registration</h2>
            <form:form action="${pageContext.request.contextPath}/admin/addMovie" method="post" modelAttribute="movie">
                <!--  <div class="form-group">
                    <label for="movieId">Movie ID:</label>
                    <form:input path="movieId" id="movieId" required="true"/>
                </div>-->

                <div class="form-group">
                    <label for="movieName">Movie Name:</label>
                    <form:input path="movieName" id="movieName" required="true"/>
                </div>

                <div class="form-group">
                    <label for="directorName">Director Name:</label>
                    <form:input path="directorName" id="directorName" required="true"/>
                </div>

                <div class="form-group">
                    <label for="releaseDate">Release Date:</label>
                    <form:input path="releaseDate" id="releaseDate" type="date" required="true"/>
                 <script>
                        var currentDate = new Date();
                        var day = currentDate.getDate();
                        var month = currentDate.getMonth() + 1; // Months are zero-based
                        var year = currentDate.getFullYear();
                        if (day < 10) { day = '0' + day; }
                        if (month < 10) { month = '0' + month; }
                        var today = year + '-' + month + '-' + day;
                        document.getElementById('releaseDate').setAttribute('min', today);
                    </script>
                </div>
                
                <%-- <div class="form-group">
                <c:forEach items="${castList}" var="item">
        <input type="checkbox" name="castList" value="${item.castingId}">
        ${item.actor}<br>
    </c:forEach>
    </div>
    <select name="selectedItems" multiple="multiple">
        <c:forEach items="${castList}" var="item">
            <option value="${item}">${item}</option>
        </c:forEach>
    </select>--%>
    
    <label for="selectedActor1">Select Actor 1:</label>
    <select name="selectedActor1" >
        <option value="empty">-- Select Actor 1 --</option>
        <c:forEach items="${castList}" var="actor">
            <option value="${actor.castingId}">${actor.actor}</option>
        </c:forEach>
    </select>
    <br>

    <label for="selectedActor2">Select Actor 2:</label>
    <select name="selectedActor2">
        <option value="empty">-- Select Actor 2 --</option>
        <c:forEach items="${castList}" var="actor">
            <option value="${actor.castingId}">${actor.actor}</option>
        </c:forEach>
    </select>

                <button type="submit">Save Movie</button>
            </form:form>
        </div>
    </div >
  

<%@include file="../html/adminfooter.html"%>