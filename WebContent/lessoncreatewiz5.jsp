<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">
		<c:if test="${error}">
			<p id="wizError">ERROR ERROR ERROR ERROR ERROR ERROR ERRROR</p>
		</c:if>
		<form class="row col-md-12" action="lessonwizardfinal" method="post">
			<div class="form-group container col-sm-11 col-sm-offset-1">
				
				<div class="row lessonFive">
					<label class="col-sm-2 control-label" for="assessInfo">Assessment Type: </label>
					<div class="col-sm-7">
					<select name="assessments" class="form-control">
						<option value="" selected="selected" disabled>Please Select An Assessment</option>
						<c:forEach items="${assessments}" var="assessment">
							<option value="${assessment.value}">${assessment.key}</option>
						</c:forEach>
					</select>
				</div>
				</div>
				
				<div class="row lessonFive">
					<label class="col-sm-2 control-label" for="assessInfo">Assessment Link: </label>
					<div class="col-sm-10">
						<input type="file" name="file" class="filestyle" data-size="sm" data-icon="false" data-buttonText="Find Assessment" data-buttonBefore="true" data-buttonName="btn-primary" accept=".pdf">
					</div>
				</div>
				
				<div class="row">
					<label class="col-sm-2 control-label" for="assessInfo">Assessment Information: </label>
					<div class="col-sm-10">
						<textarea class="form-control" rows="8" name="assessInfo"></textarea>
					</div>
				</div>
				
			</div>
			<div class="pull-right">
				<a href="lessondashboard"><button value="Cancel" class="btn btn-danger">Cancel</button></a>
				<button type="submit" value="Finish" class="btn btn-success">Finish</button>
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp" %>
	<script type="text/javascript" src="js/vendor/filestyle.min.js"></script>
</body>
</html>