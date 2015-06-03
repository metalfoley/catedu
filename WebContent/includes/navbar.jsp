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
    	<a href="logout">Logout</a>
    	<c:if test="${currentUser.getRole() != null}">
    	<a href="mainDashboard">${currentUser.getFirstName()} ${currentUser.getLastName()} / ${currentUser.getRole()}</a>
    	</c:if>
    </div>
</nav>