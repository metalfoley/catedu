<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/navbar.jsp" %>

    <div class="container-fluid clearfix">

      <div class="container pull-left" id="sidebar">
        <div class="row">
          <button type="button" class="btn btn-primary">Button 1</button>
          <button type="button" class="btn btn-primary">Button 2</button>
          <button type="button" class="btn btn-primary">Button 3</button>
          <button type="button" class="btn btn-primary">Button 4</button>
          <button type="button" class="btn btn-primary">Button 5</button>
          <button type="button" class="btn btn-primary">Button 6</button>
        </div>
        <div class="row">
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Button 1</button>
          <button type="button" class="btn btn-primary">Button 2</button>
          <button type="button" class="btn btn-primary">Button 3</button>
          <button type="button" class="btn btn-primary">Button 4</button>
          <button type="button" class="btn btn-primary">Button 5</button>
          <button type="button" class="btn btn-primary">Button 6</button>
        </div>
      </div>

      <div class="container mainbody pull-right">

        <div class="row">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Summary</h3>
            </div>
            <div class="panel-body">
              Hello ${firstName}
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

		  <jsp:include page="includes/tabs/${role}Tab.jsp" />
        
        </div>

      </div>

    </div>
<c:set var="role" value="${role}"/>
<c:choose>
<c:when test="${role == 'teacher'}" >
	<%@ include file="includes/modals/modal1.jsp" %>
</c:when>
</c:choose>
<%@ include file="includes/footer.jsp" %> 