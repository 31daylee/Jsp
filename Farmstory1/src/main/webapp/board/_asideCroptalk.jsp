<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String cate = request.getParameter("cate");

%>
<div id="sub">
	<div class="bg">
		<img src="/Farmstory1/images/sub_top_tit3.png" alt="CROP TALK">
	</div>
	<section class="croptalk">
		<aside>
			<img src="/Farmstory1/images/sub_aside_cate3_tit.png" alt="팜스토리소개">
			<ol class="lnb">
				<li class="<%= cate.equals("story")? "on":""%>"><a href="/Farmstory1/board/list.jsp?group=Croptalk&cate=story">농작물이야기</a></li>
				<li class="<%= cate.equals("grow")? "on":""%>"><a href="/Farmstory1/board/list.jsp?group=Croptalk&cate=grow">텃밭가꾸기</a></li>
				<li class="<%= cate.equals("school")? "on":""%>"><a href="/Farmstory1/board/list.jsp?group=Croptalk&cate=school">귀농학교</a></li>
			</ol>
		</aside>
		<article class="content">
			<nav>
				<img src="/Farmstory1/images/sub_nav_tit_cate3_<%=cate %>.png" alt="농작물이야기">
				<p>
					HOME > 팜스토리소개 > 
					<% if(cate.equals("story")){ %>
					<strong>농작물이야기</strong>
					<%}else if(cate.equals("grow")){ %>
					<strong>텃밭가꾸기</strong>
					<%}else if (cate.equals("school")){ %>
					<strong>귀농학교</strong>
					<% } %>>
				</p>
			</nav>
			<!-- 컨텐츠 시작-->
