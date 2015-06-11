<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

    <div class="container-fluid clearfix">

      <div class="container pull-left" id="sidebar">
        <div class="row">
          <a href="lessonplanwizard"><button type="button" class="btn btn-primary">Create Lesson Plan</button></a>
          <a href="lessonwizard"><button type="button" class="btn btn-primary">Create Lesson</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Add Student</button></a>
        </div>
        <div class="row">
          <a href="#"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Deactivate</button></a>
          <a href="#"><button type="button" class="btn btn-primary">Suggest Move</button></a>
        </div>
      </div>

      <div class="container mainbody pull-right">

        <div class="row">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Summary</h3>
            </div>
            <div class="panel-body">
              Hello ${currentUser.getFirstName()}
            </div>
          </div>
        </div>

        <div class="row">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Inbox</h3>
            </div>
            <div class="panel-body">
              Panel content
            </div>
          </div>
        </div>

        <div class="row">

		   <jsp:include page="includes/tabs/${currentUser.getRole()}Tab.jsp"/>
        
        </div>

      </div>

    </div>
<c:set var="role" value="${currentUser.getRole()}"/>
<c:choose>
<c:when test="${role == 'Teacher'}" >
	<%@ include file="includes/modals/modal1.jsp" %>
</c:when>
</c:choose>
<%@ include file="includes/footer.jsp" %>
</body>
</html>