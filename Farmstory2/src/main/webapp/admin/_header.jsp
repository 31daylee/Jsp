<%@page import="kr.co.farmstory2.dto.UserDTO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	UserDTO sessUser = (UserDTO)session.getAttribute("sessUser");

	if(sessUser == null){
		response.sendRedirect("/Farmstory2/user/login.jsp?success=101");
		return;
	}

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="./css/style.css">
    <style></style>
</head>

<body>
    <div id="container">
        <header>
            <a href="./index.do" class="logo"><img src="./images/admin_logo.jpg" alt="로고"/></a>
            <p>
                <a href="/Farmstory2/">HOME |</a>
                <a href="/Farmstory2/user/logout.do">로그아웃 |</a>
                <a href="/Farmstory2/admin/index.do">고객센터</a>
            </p>
        </header>