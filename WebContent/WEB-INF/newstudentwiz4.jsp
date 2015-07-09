<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">
	<h4 class="pull-left">Persons Authorized to Pick Up Student From School</h4>
		<form class="form-horizontal row col-md-12" action="#" method="post">
			<fieldset>
				<legend align="right">Person One</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authname1">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="authname1" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authrelationship1">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="authrelationship1" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authphone1">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="authphone1" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend align="right">Person Two</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authname2">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="authname2" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authrelationship2">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="authrelationship2" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authphone2">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="authphone2" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend align="right">Person Three</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authname3">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="authname3" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authrelationship3">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="authrelationship3" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="authphone3">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="authphone3" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<script src="js/vendor/jquery-1.11.2.min.js"></script>
	<script src="js/vendor/mask.js"></script>
	<script type="text/javascript">jQuery(function($){$(".phone").mask("(999) 999-9999");});</script>
</body>
</html>