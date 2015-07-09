<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

    <div class="container-fluid clearfix">

      <div class="container pull-left" id="sidebar">
        <div class="row">
          <a href="#"><button type="button" class="btn btn-primary">Lesson Plan</button></a>
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
		            <p><span class="personalSummary">Name: </span>${lesson.getName()}</p>
		            <p><span class="personalSummary">Author: </span>${lesson.getAuthor().getFirstName()} ${lesson.getAuthor().getLastName()}</p>
		            <p><span class="personalSummary">Short Description: </span>${lesson.getShortDescription()}</p>
            	</div>
            	<div class="pull-right">
            		<p>
            			<span class="personalSummary">Lead Lesson: </span>
            				<a href="lessondashboard?lid=${lesson.getLeadID()}">${lesson.getLeadLesson()}</a>
            		</p>
            	</div>
            </div>
          </div>
        </div>
        
        <div role="tabpanel">

           <!-- Nav tabs -->
           <ul class="nav nav-tabs" role="tablist">
             <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Lesson Plans</a></li>
           </ul>

           <!-- Tab panes -->
           <div class="tab-content">
             <div role="tabpanel" class="tab-pane active" id="home">
                 <p>Home</p>
             </div>
           </div>
         </div>

      </div>

    </div>
    <%@ include file="includes/modals/lessonSummaryModal.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>