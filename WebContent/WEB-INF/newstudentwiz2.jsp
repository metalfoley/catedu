<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">
		<form class="form-horizontal row col-md-12" action="#" method="post">
			<fieldset>
				<legend align="right">Primary</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="guardfOne">
						<span class="glyphicon glyphicon-asterisk"></span> 
						Name:
					</label>
					<div class="col-sm-3">
						<input class="form-control" placeholder="Sam" type="text" name="guardfOne" value="" pattern="[a-zA-Z]{0,50}" required />
					</div>
					<div class="col-sm-3">
						<input class="form-control" placeholder="Stan" type="text" pattern="[a-zA-Z]{0,50}" value="" name="guardmOne" />
					</div>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="Smith" pattern="[a-zA-Z]{0,50}" value="" name="guardlOne" required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="address1">Address: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="555 A St." type="text" name="address1" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-7 col-sm-offset-2">
						<input class="form-control" type="text" placeholder="Atlanta" name="city1" />
					</div>
					<div class="col-sm-1">
						<input class="form-control" type="text" name="state1" placeholder="OR" pattern="[a-zA-Z]{2}" />
					</div>
					<div class="col-sm-2">
						<input class="form-control" type="text" name="zip1" placeholder="55555" pattern="(\d{5}([\-]\d{4})?)" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone1">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone1" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
					<label class="col-sm-2 control-label" for="email1">Email: </label>
					<div class="col-sm-4">
						<input class="form-control" placeholder="samsmith@xyz.com" type="email" name="email1" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="relationship1">Relationship To Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Mother" type="text" name="relationship1" />
					</div>
				</div>
			</fieldset>
			<fieldset>
				<legend align="right">Secondary</legend>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="guardfTwo">
						<span class="glyphicon glyphicon-asterisk"></span> 
						Name:
					</label>
					<div class="col-sm-3">
						<input class="form-control" placeholder="Sam" type="text" name="guardfTwo" value="" pattern="[a-zA-Z]{0,50}" required />
					</div>
					<div class="col-sm-3">
						<input class="form-control" placeholder="Stan" type="text" pattern="[a-zA-Z]{0,50}" value="" name="guardmTwo" />
					</div>
					<div class="col-sm-4">
						<input class="form-control" type="text" placeholder="Smith" pattern="[a-zA-Z]{0,50}" value="" name="guardlTwo" required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="address2">Address: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="555 A St." type="text" name="address2" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-7 col-sm-offset-2">
						<input class="form-control" type="text" placeholder="Atlanta" name="city2" />
					</div>
					<div class="col-sm-1">
						<input class="form-control" type="text" name="state2" placeholder="OR" pattern="[a-zA-Z]{2}" />
					</div>
					<div class="col-sm-2">
						<input class="form-control" type="text" name="zip2" placeholder="55555" pattern="(\d{5}([\-]\d{4})?)" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone2">Phone: </label>
					<div class="col-sm-4">
						<input class="form-control phone" placeholder="(555) 555-5555" type="tel" name="phone2" pattern="((\(\d{3}\) ?)|(\d{3}-))?\d{3}-\d{4}"/>
					</div>
					<label class="col-sm-2 control-label" for="email2">Email: </label>
					<div class="col-sm-4">
						<input class="form-control" placeholder="samsmith@xyz.com" type="email" name="email2" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="relationship2">Relationship To Student: </label>
					<div class="col-sm-10">
						<input class="form-control" placeholder="Father" type="text" name="relationship2"/>
					</div>
				</div>
				<div class="pull-right">
					<button value="Cancel" class="btn wizbtn btn-danger" onclick="history.back(-1)">Cancel</button>
					<button type="submit" value="Continue" class="btn wizbtn btn-success">Continue</button>
				</div>
			</fieldset>
		</form>
	</div>
	<script src="js/vendor/jquery-1.11.2.min.js"></script>
	<script src="js/vendor/mask.js"></script>
	<script type="text/javascript">jQuery(function($){$(".phone").mask("(999) 999-9999");});</script>
</body>
</html>