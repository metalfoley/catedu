<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">

		<form class="row col-md-11" action="lessonwizardfive" method="post">
			<div class="form-group col-md-11 col-md-offset-1">
				<label class="col-sm-1 control-label" for="name">Subject: </label>
				<div class="col-sm-5">
					<select class="form-control">
						<option value="" selected="selected" disabled>Please Select a Subject</option>
						<option>Science</option>
						<option>Math</option>
						<option>History</option>
					</select>
				</div>
			</div>
			
			<!-- use for each loop based on core standards table. update value with the corest name -->
			<div class="checkbox form-group col-md-9 col-md-offset-2">
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 1</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 2</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 3</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 4</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 5</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 6</label>
			  <label class="wizard3-4"><input type="checkbox" value="CoreStandard1">CoreStandard 7</label>
			</div>
			
			<div class="pull-right">
				<button value="Cancel" class="btn btn-danger">Cancel</button>
				<button type="submit" value="Continue" class="btn btn-success">Continue</button>
			</div>
		</form>
	</div>
</body>
</html>