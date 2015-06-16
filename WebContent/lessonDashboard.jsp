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
          <a href="#"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Deactivate</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Summary</button></a>
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
		            <p>Name: ${tempLesson.getName()}</p>
		            <p>Author: ${tempLesson.getAuthor().getFirstName()} ${tempLesson.getAuthor().getLastName()}</p>
		            <p>Short Description: ${tempLesson.getShortDescription()}</p>
            	</div>
            	<div class="pull-right">
            		<p>Lead Lesson: ${tempLesson.getLeadLesson()}</p>
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
<%@ include file="includes/footer.jsp" %>
</body>
</html>