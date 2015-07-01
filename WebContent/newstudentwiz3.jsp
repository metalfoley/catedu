<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">
		<form class="form-horizontal row col-md-12" action="#" method="post">
			<fieldset>
				<legend align="right">First Emergency Contact</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecname1">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="ecname1" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecrelationship1">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="ecrelationship1" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone1">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone1" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend align="right">Second Emergency Contact</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecname2">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="ecname2" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecrelationship2">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="ecrelationship2" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone2">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone2" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend align="right">Third Emergency Contact</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecname3">
						Parent/Legal Guardian:
					</label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Sam Smith" type="text" name="ecname3" pattern="[a-zA-Z]{0,100}" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="ecrelationship3">Relationship to Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="ecrelationship3" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone3">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone3" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
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