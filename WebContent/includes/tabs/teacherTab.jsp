<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div role="tabpanel">

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Lesson Plans</a></li>
              <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Lessons</a></li>
              <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Students</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">ELL</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">IDP</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">etc</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
              <div role="tabpanel" class="tab-pane active" id="home">
                  <p>Lesson Plans</p>
              </div>
              <div role="tabpanel" class="tab-pane" id="profile">
                  <table class="table table-hover">
                  	<thead>
                  		<tr>
	                  		<th>#</th>
	                  		<th>Name</th>
	                  		<th>Short Description</th>
	                  		<th>Author</th>
                  		</tr>
                  	</thead>
                  	<tbody>
	                  	<c:forEach items="${allLessons}" var="lesson">
	                  		<tr>
	                  			<th scope="row">${lesson.getId() }</th>
	                  			<td>${lesson.getName() }</td>
	                  			<td>${lesson.getShortDescription() }</td>
	                  			<td>${lesson.getAuthor().getFirstName()} ${lesson.getAuthor().getLastName()}</td>
	                  		</tr>
	                  	</c:forEach>
                  	</tbody>
                  </table>
              </div>
              <div role="tabpanel" class="tab-pane" id="messages">
                  <p>messages</p>
              </div>
              <div role="tabpanel" class="tab-pane" id="settings">
                  <p>settings</p>
              </div>
            </div>
          </div>