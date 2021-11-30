<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="login.css" ;>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>JSP Page</title>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="fadeIn first">
            <i class="far fa-user"></i>
        </div>
        <form action="logout" method="POST">
             <input type="submit"  name="logout" class="fadeIn fourth" value="Log Out">
            <sec:csrfInput />
        </form>
    </div>
</div>
</body>
</html>

