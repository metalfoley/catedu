<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">

		<form class="row col-md-11" action="lessonwizardfour" method="post">
			<p>Select Lead Lesson</p>
			
			<!-- use for each loop based on lessons table. update value with the lesson name -->
			<div class="radio form-group col-md-9 col-md-offset-2">
			  <c:forEach items="${lessons}" var="lesson">
			  	<label class="wizard3-4"><input name="leadLesson" type="radio" value="${lesson.getId()}">${lesson.getName()}</label>
			  </c:forEach>
			</div>
			
			<div class="pull-right">
				<a href="lessondashboard?lid=${lesson.getId() }"><button value="Cancel" class="btn wizbtn btn-danger">Cancel</button></a>
				<button type="submit" value="Continue" class="btn wizbtn btn-success">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>