<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Learning Management System - Login</title>
    <meta name="description" content="Learning Management System login System">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href='http://fonts.googleapis.com/css?family=Arvo:700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">

    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body>
    <div class="clearfix">
        <div id="log-container">
            <h1>LOGIN: </h1>
            <form id="login" class="clearfix" action="loginController" method="post">
                <label for="username">User Name: </label>
                <input type="text" name="username">
                <label for="password">Password: </label>
                <input type="password" name="password">
                <button type="submit" value="Submit" class="btn btn-primary pull-right">Submit</button>
            </form>
        </div>
    </div>
</body>