<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Casting Registration</title>
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
            <h2>Add Casting</h2>
            <form:form action="${pageContext.request.contextPath}/casting/addCasting" method="post" modelAttribute="casting">

                <div class="form-group">
                    <label for="actor">Casting Name:</label>
                    <form:input path="actor" id="actor" required="true"/>
                </div>

                <button type="submit">Save Casting</button>
            </form:form>
        </div>
    </div >


<%@include file="../html/adminfooter.html"%>