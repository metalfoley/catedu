<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<body>
<%@ include file="includes/wizardHeader.jsp" %>
<div class="container wizBody">
		
		<form class="form-horizontal row col-md-12" action="LessonPlanWizardTwo" method="post">
			<button class="btn btn-success">Add Lesson</button>
			
			<div class="form-group">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Description</th>
							<th>Subject</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lessons}" var="singleLesson">
							<tr>
								<td><input type="checkbox" name="lesson" value="${singleLesson.getId()}" /></td>
								<td>${singleLesson.getName()}</td>
								<td>${singleLesson.getShortDescription()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="pull-right">
				<button value="Cancel" class="btn btn-danger">Cancel</button>
				<button type="submit" value="Continue" class="btn btn-success">Continue</button>
			</div>
			<p><span class="glyphicon glyphicon-asterisk"></span> Required Field</p>
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
</body>
</html>