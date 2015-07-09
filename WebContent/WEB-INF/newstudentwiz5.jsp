<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp" %>
<body>
	<%@ include file="includes/wizardHeader.jsp" %>
	<div class="container wizBody">
		<form class="form-horizontal row col-md-12" action="#" method="post">
			<div id="addstudent5" class="form-group">
				<label class="col-sm-1 control-label" for="grade">Grade: </label>
				<div class="col-sm-4">
					<select class="form-control" name="grade">
						<option value="" selected disabled>Please Select A Grade</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
				</div>
				<label class="col-sm-1 control-label" for="ell">ELL:
					<input id="ellCheck" type="checkbox" name="ell" />
				</label>
				<label class="col-sm-1 control-label" for="language">Language: </label>
				<div class="col-sm-5">
					<select class="form-control" id="langselect" name="language" disabled>
						<option value="" selected disabled>Please Select A Language</option>
						<option value="spanish">Spanish</option>
						<option value="german">German</option>
						<option value="russian">Russian</option>
						<option value="mandarin">Mandarin</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-1 control-label" for="notes">Notes: </label>
				<div class="col-sm-11">
					<textarea class="form-control" rows="6" name="notes"></textarea>
				</div>
			</div>

		</form>
	</div>
	<script src="js/vendor/jquery-1.11.2.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>