<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/header.jsp" %>

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
          <button type="button" class="btn btn-primary">Button 1</button>
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
              Panel content
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

          <div role="tabpanel">

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
              <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
              <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
              <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
              <div role="tabpanel" class="tab-pane active" id="home">
                  <p>Home</p>
              </div>
              <div role="tabpanel" class="tab-pane" id="profile">
                  <p>profile</p>
              </div>
              <div role="tabpanel" class="tab-pane" id="messages">
                  <p>messages</p>
              </div>
              <div role="tabpanel" class="tab-pane" id="settings">
                  <p>settings</p>
              </div>
            </div>
          </div>
        
        </div>

      </div>

    </div>

<%@ include file="includes/footer.jsp" %> 