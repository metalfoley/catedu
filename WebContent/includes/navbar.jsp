<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
<!--   <div class="container"> -->
<!--     <div class="navbar-header"> -->
<!--       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> -->
<!--         <span class="sr-only">Toggle navigation</span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--         <span class="icon-bar"></span> -->
<!--       </button> -->
<!--       <a class="navbar-brand" href="/"> -->
<!--         <img src="img/lmslogo.jpg" alt="Catalyst Education Logo" /> -->
<!--       </a> -->
<!--       <img src="img/banner.jpg" alt="Catalyst Education Banner" /> -->
<!--     </div> -->
<!--     <div id="navbar" class="navbar-collapse collapse"> -->
<!--       <ul class="nav navbar-nav pull-right"> -->
<!--         <li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li> -->
<!--         <li><a href="logout">Log Out</a></li> -->
<!--       </ul> -->
<!--     </div>/.navbar-collapse -->
<!--   </div> -->
<!-- </nav> -->
<nav class="clearfix">
	<div class="navbar-brand pull-left">
    	<img src="img/lmslogo.jpg" alt="Catalyst Education Logo" />
    </div>
    <div class="pull-left">
    	<img src="img/banner.jpg" alt="Catalyst Education Banner" />
    </div>
    <div class="pull-right" id="navlinks">
    	<a href="logout">Logout</a>
    	<a href="mainDashboard">${firstName} ${lastName} / ${role}</a>
    </div>
</nav>