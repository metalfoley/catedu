<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">

		<form class="row col-md-11" action="lessonwizardfive" method="post">
			<div class="form-group col-md-11 col-md-offset-1 noHide">
				<label class="col-sm-1 control-label" for="name">Subject: </label>
				<div class="col-sm-5">
					<select class="form-control" id="coreClass">
						<option value="" selected="selected" disabled>Please Select a Subject</option>
						<c:forEach items="${classes}" var="singleClass">
							<option value="${singleClass.getId()}">${singleClass.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<!-- use for each loop based on core standards table. update value with the corest name -->
			<c:forEach items="${classes}" var="singleClass">
				<div class="checkbox form-group col-md-9 col-md-offset-2 hidden" id="${singleClass}">
				  <c:forEach items="${coreStandards}" var="coreStandard">
				  	<label class="wizard3-4"><input type="checkbox" name="${singleClass}" value="${coreStandard}">${coreStandard}</label>
				  </c:forEach>
				</div>
			</c:forEach>
			
			<div class="pull-right noHide">
				<a href="lessondashboard?lid=${lesson.getId() }"><button value="Cancel" class="btn wizbtn btn-danger">Cancel</button></a>
				<button type="submit" value="Continue" class="btn wizbtn btn-success">Continue</button>
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
</body>
</html>