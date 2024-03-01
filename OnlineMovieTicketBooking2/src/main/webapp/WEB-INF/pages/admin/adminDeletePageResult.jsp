<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Movie</title>
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
            <form:form action="${pageContext.request.contextPath}/admin/deleteMovieController" method="post" modelAttribute="movie">
                  <div class="form-group">
                    
                    <form:input path="movieId" id="movieId" required="true" type="hidden"/>
                </div>

                <div class="form-group">
                    <label for="movieName">Movie Name:</label>
                    <form:input path="movieName" id="movieName" required="true"  readonly="true"/>
                </div>

                <div class="form-group">
                    <label for="directorName">Director Name:</label>
                    <form:input path="directorName" id="directorName" required="true"  readonly="true"/>
                </div>

                <div class="form-group">
                    <label for="releaseDate">Release Date:</label>
                    <form:input path="releaseDate" id="releaseDate" type="date" required="true"  readonly="true"/>
                <%--  <script>
                        var currentDate = new Date();
                        var day = currentDate.getDate();
                        var month = currentDate.getMonth() + 1; // Months are zero-based
                        var year = currentDate.getFullYear();
                        if (day < 10) { day = '0' + day; }
                        if (month < 10) { month = '0' + month; }
                        var today = year + '-' + month + '-' + day;
                        document.getElementById('releaseDate').setAttribute('min', today);
                    </script>--%>
                </div>
                
               
    <div class="form-group">
    <label for="selectedActor1">Update Actor 1:</label>
    <select name="selectedActor1" >
        <option value="${ castingList.get(0).getCastingId()}">${ castingList.get(0).getActor()}</option>
        <%--<c:forEach items="${castList}" var="actor">
            <option value="${actor.castingId}" >${actor.actor}</option>
        </c:forEach> --%>
    </select>
    </div>
<div class="form-group">
    <label for="selectedActor2">Update Actor 2:</label>
    <select name="selectedActor2">
        <option value="${ castingList.get(1).getCastingId()}">${ castingList.get(1).getActor()}</option>
        <%-- <c:forEach items="${castList}" var="actor">
            <option value="${actor.castingId}">${actor.actor}</option>
        </c:forEach>--%>
    </select>
</div>
                <button type="submit">Delete Movie</button>
            </form:form>
        </div>
    </div >
  

<%@include file="../html/adminfooter.html"%>