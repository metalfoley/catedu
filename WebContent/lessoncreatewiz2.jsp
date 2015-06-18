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
		<form class="row col-md-12" action="lessonwizardthree" method="post">
			<div class="form-group container col-sm-6 lessonTwo">
				<div class="row">
					<label class="col-sm-4 control-label" for="enhancements">Enhancements: </label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="5" name="enhancements"></textarea>
					</div>
				</div>
			</div>
			<div class="form-group container col-sm-6 lessonTwo">
				<div class="row">
					<label class="col-sm-4 control-label" for="extensions">Extensions: </label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="5" name="extensions"></textarea>
					</div>
				</div>
			</div>
			<div class="form-group container col-sm-6 lessonTwo">
				<div class="row">
					<label class="col-sm-4 control-label" for="details">Details: </label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="5" name="details"></textarea>
					</div>
				</div>
			</div>
			<div class="form-group container col-sm-6 lessonTwo">
				<div class="row">
					<label class="col-sm-4 control-label" for="materials">Materials: </label>
					<div class="col-sm-8">
						<textarea class="form-control" rows="5" name="materials"></textarea>
					</div>
				</div>
			</div>
			<div class="pull-right">
				<a href="lessondashboard"><button value="Cancel" class="btn wizbtn btn-danger">Cancel</button></a>
				<button type="submit" value="Continue" class="btn wizbtn btn-success">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>