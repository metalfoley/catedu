<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

    <div class="container-fluid clearfix">

      <div class="container pull-left" id="sidebar">
        <div class="row">
          <a href="lessonplanwizard?lpid=" + ${lp.getId()}><button type="button" class="btn btn-primary">Create Lesson</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Read Lesson</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Update Lesson</button></a>
        </div>
        <div class="row">
          <button type="button" class="btn btn-primary">Deactivate</button>
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#lessonSummaryModal">Summary</button>
        </div>
      </div>

      <div class="container mainbody pull-right">

        <div class="row">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Summary</h3>
            </div>
            <div class="panel-body">
            	<div class="pull-left">
		            <p><span class="personalSummary">Name: </span>${lp.getName()}</p>
		            <p><span class="personalSummary">Short Description: </span>${lp.getShortDescription()}</p>
            	</div>
            	<div class="pull-right">
            		<p><span class="personalSummary"># Lessons: </span>${lp.getLessons().size()}</p>
            		<p><span class="personalSummary">Major Subject: </span>${lp.getSubject()}</p>
            	</div>
            </div>
          </div>
        </div>
        
        <div class="row">
          <div class="panel panel-default">
	        <div class="panel-heading">
	        	<h3 class="panel-title">Lessons</h3>
	        </div>
			<div class="panel-body">
				<div class="pull-left">
					<c:forEach items="${lp.getLessons()}" var="lesson">
						<p><a href="lessondashboard?lid=${lesson.getId() }">${lesson.getName()}</a></p>
					</c:forEach>
				</div>
			</div>
		  </div>
		</div>

      </div>

    </div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>