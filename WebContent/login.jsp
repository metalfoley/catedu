<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>
    <div class="clearfix">
    	<div class="container">
	        <div id="log-container">
	            <h1>LOGIN: </h1>
	            <form id="login" class="clearfix" action="home" method="post">
	                <label for="username">User Name: </label>
	                <input type="text" name="username">
	                <label for="password">Password: </label>
	                <input type="password" id="password" name="password">
	                <label for="showPassword">Check to show Password: </label>
	                <input class="pull-right" name="showPassword" id="showPass" type="checkbox"> 
	                <button type="submit" value="Submit" class="btn btn-primary pull-right">Submit</button>
	            </form>
	            
	            <c:if test="${error}">
			        <div class="loginError">
			        	<p>Sorry, we didn't recognize that username and password combination. Please double-check and try again</p>
			        </div>
	       		</c:if>
	            
	        </div>
        </div>
    </div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>