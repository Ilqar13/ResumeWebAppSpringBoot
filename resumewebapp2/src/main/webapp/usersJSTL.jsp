

<%@page import="java.util.List"%>
<%@page import="com.company.entity1.User"%>
<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="UsersSearch/users.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="UsersSearch/users.js"></script>
    <title>JSP Page</title>
</head>

<body>

<div class="container mycontainer">

    <div class="col">
            <div class="form-group">
                <f:form action="usersearch" method="GET" modelAttribute="user">
                <label for="name">name:</label>
                <f:input  path="name" class="form-control" id="whatIamtyping" placeholder="Name"/>
                  <f:errors path="name"/>
                <div class="form-group">
                    <label for="surname">surname:</label>
                        <f:input path="surname" class="form-control" placeholder="Surname"/>
                       <f:errors path="surname"/>
                     </div>

                <f:button type="submit" class="btn btn-primary">Search</f:button>
            </div>
        </f:form>

    </div>
    <div class="col" >
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>nationality</th>
                <th></th>
            <tr/>
            <thead/>
            <tbody>
            <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${((check=(u.getNationality().getName()))==null)?"N/A":check}</td>
                <td style="width: 5px">

                    <button class=" btn-danger"  data-toggle="modal" data-target="#exampleModal" value="${u.id}" onClick="setValueToButton(this.value)">
                        <i class=" fas fa-trash-alt"> </i>
                    </button>

                </td>
                <td>
                    <form action="userdetails" method="GET">
                        <button class=" btn-secondary" type="submit" name="id" value="${u.id}">
                            <i class="fas fa-pen-square"></i>
                        </button>
                    </form>
                </td>
            <tr/>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are You sure?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form action="user-removal" method="POST">
                    <button class="btn btn-danger" type="submit" name="deletedID"  id="btndelete">Delete</button>
                    <sec:csrfInput />
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

