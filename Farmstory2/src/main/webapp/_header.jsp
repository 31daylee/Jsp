<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리</title>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <link rel="stylesheet" href="/Farmstory2/css/style.css"/>
    <link rel="stylesheet" href="/Farmstory2/user/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>    

</head>
<body>
    <div id="container">
        <header>
            <a href="/Farmstory2/" class="logo"><img src="/Farmstory2/images/logo.png" alt="로고"/></a>
            <p>
                <a href="/Farmstory2/index.do">HOME |</a>
                <c:if test="${empty sessUser }">
                	<a href="/Farmstory2/user/login.do">로그인 |</a>
                	<a href="/Farmstory2/user/terms.do">회원가입 |</a>
                </c:if>
                 <c:if test="${not empty sessUser }">
                <a href="/Farmstory2/user/myPage.do">${sessUser.nick }님 마이페이지 |</a>
                <a href="/Farmstory2/user/logout.do">로그아웃 |</a>
                	<c:if test="${sessUser.role ne 'USER' }">
                	<a href="/Farmstory2/admin/index.do">관리자 |</a>
                	</c:if>
                	</c:if>
                <a href="/Farmstory2/board/list.do?group=Community&cate=qna">고객센터</a>
            </p>
            <img src="/Farmstory2/images/head_txt_img.png" alt="3만원 이상 무료배송"/>
            
            <ul class="gnb">
                <li><a href="/Farmstory2/introduction/hello.do">팜스토리소개</a></li>
                <li><a href="/Farmstory2/market/list.do"><img src="/Farmstory2/images/head_menu_badge.png" alt="30%"/>장보기</a></li>
            	<li><a href="/Farmstory2/board/list.do?group=Croptalk&cate=story">농작물이야기</a></li>
                <li><a href="/Farmstory2/board/list.do?group=Event&cate=event">이벤트</a></li>
                <li><a href="/Farmstory2/board/list.do?group=Community&cate=notice">커뮤니티</a></li>
            </ul>
        </header>