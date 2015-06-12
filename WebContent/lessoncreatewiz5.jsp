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
		<form class="row col-md-12" action="lessonwizardend" method="post">
			<div class="form-group container col-sm-11 col-sm-offset-1">
				<div class="row">
					<label class="col-sm-4 control-label" for="assessInfo">Assessment Information: </label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="8" name="assessInfo"></textarea>
					</div>
				</div>
			</div>
			<div class="pull-right">
				<button value="Cancel" class="btn btn-danger">Cancel</button>
				<button type="submit" value="Finish" class="btn btn-success">Finish</button>
			</div>
		</form>
	</div>
</body>
</html>