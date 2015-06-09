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
		<form class="form-horizontal row col-md-11" action="createlessonwizard" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">
					<span class="glyphicon glyphicon-asterisk"></span> 
					Name:
				</label>
				<div class="col-sm-10">
					<input class="form-control" type="text" name="name" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="shortdescription">Short Description: </label>
				<div class="col-sm-10">
					<textarea class="form-control" name="shortdescription"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="fulldescription">Full Description: </label>
				<div class="col-sm-10">
					<textarea class="form-control" name="fulldescription"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="subject">Advanced: </label>
				<div class="col-sm-10 checkbox">
      				<input type="checkbox">
				</div>
			</div>
			<div class="pull-right">
				<button value="Cancel" class="btn btn-danger">Cancel</button>
				<button type="submit" value="Continue" class="btn btn-success">Continue</button>
			</div>
			<p><span class="glyphicon glyphicon-asterisk"></span> Required Field</p>
		</form>
	</div>
</body>
</html>