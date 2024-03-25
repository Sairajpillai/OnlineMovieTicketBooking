<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Casting Search Results</title>
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
        
        .container {
            text-align: center;
        }

        h2, h3 {
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
        tbody tr:nth-child(even) {
            background-color: #D3D3D3; /* Light grey color for even rows */
        }
</style>
</head>
<%@include file="../html/adminheaderinside.html"%>
<div class="container">
<%-- <c:forEach var="movie" items="${moviesList}">
    <h3>${movie.movie.movieName}</h3>

    <table>
        <thead>
            <tr>
                <th>Actor</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="casting" items="${movie.casting}">
                <tr>
                    <td>${casting.actor}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:forEach>--%>

    

<c:forEach var="casting" items="${castingList}">
    <table>
        <thead>
            <tr>
                <th>Casting Name</th>
                <th>Created Date</th>
                <th>Created By</th>
                
            </tr>
        </thead>
        <tbody>
        <tr><td>${casting.actor}</td>
        <td>${casting.createdDate}</td>
        <td>${casting.admin.adminName}</td>
        
        
       
                </tr>
        </tbody>
    </table>
</c:forEach>

</div>

<%@include file="../html/adminfooter.html"%>