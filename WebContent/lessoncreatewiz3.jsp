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
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson1">Lesson 1</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson2">Lesson 2</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson3">Lesson 3</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson4">Lesson 4</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson5">Lesson 5</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson6">Lesson 6</label>
			  <label class="wizard3-4"><input name="leadLesson" type="radio" value="lesson7">Lesson 7</label>
			</div>
			
			<div class="pull-right">
				<button value="Cancel" class="btn btn-danger">Cancel</button>
				<button type="submit" value="Continue" class="btn btn-success">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>