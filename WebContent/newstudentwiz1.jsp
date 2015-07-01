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
		<form class="form-horizontal row col-md-12" action="#" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="fname">
					<span class="glyphicon glyphicon-asterisk"></span> 
					Name:
				</label>
				<div class="col-sm-3">
					<input class="form-control" placeholder="Sam" type="text" name="fname" pattern="[a-zA-Z]{0,50}" required />
				</div>
				<div class="col-sm-3">
					<input class="form-control" placeholder="Stan" type="text" pattern="[a-zA-Z]{0,50}" name="mname" />
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="Smith" pattern="[a-zA-Z]{0,50}" name="lname" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="address">Address: </label>
				<div class="col-sm-10">
					<input class="form-control" placeholder="555 A St." type="text" name="address" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-7 col-sm-offset-2">
					<input class="form-control" type="text" placeholder="Atlanta" name="city" />
				</div>
				<div class="col-sm-1">
					<input class="form-control" type="text" name="state" placeholder="OR" pattern="[a-zA-Z]{2}" />
				</div>
				<div class="col-sm-2">
					<input class="form-control" type="text" name="zip" placeholder="55555" pattern="(\d{5}([\-]\d{4})?)" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="phone1">Phone1: </label>
				<div class="col-sm-10">
					<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone1" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="phone2">Phone2: </label>
				<div class="col-sm-10">
					<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone2" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
				</div>
			</div>
			<div class="pull-right">
				<button value="Cancel" class="btn wizbtn btn-danger" onclick="history.back(-1)">Cancel</button>
				<button type="submit" value="Continue" class="btn wizbtn btn-success">Continue</button>
			</div>
			<p class="required"><span class="glyphicon glyphicon-asterisk"></span> Required Field</p>
		</form>
	</div>
	<script src="js/vendor/jquery-1.11.2.min.js"></script>
	<script src="js/vendor/mask.js"></script>
	<script type="text/javascript">jQuery(function($){$(".phone").mask("(999) 999-9999");});</script>
</body>
</html>