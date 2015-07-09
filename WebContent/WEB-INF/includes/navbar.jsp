<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="clearfix">
	<div class="navbar-brand pull-left">
    	<img src="img/lmslogo.jpg" alt="Catalyst Education Logo" />
    </div>
    <div class="pull-left" id="banner">
    	<img src="img/banner.jpg" alt="Catalyst Education Banner" />
    </div>
    <div class="pull-right" id="navlinks">
    	<c:if test="${currentUser.getRole() != null}">
    	<p><a href="logout">Logout</a></p>
    	<p><a href="home">${currentUser.getFirstName()} ${currentUser.getLastName()} / ${currentUser.getRole()}</a></p>
    	</c:if>
    </div>
</nav>