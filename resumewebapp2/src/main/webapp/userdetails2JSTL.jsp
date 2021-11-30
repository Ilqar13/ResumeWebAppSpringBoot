
<%@page import="files2.FileUtility"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Date"%>
<%@page import="com.company.entity1.Country"%>
<%@page import="com.company.entity1.Skill"%>
<%@page import="java.util.List"%>
<%@page import="com.company.entity1.UserSkill"%>
<%@page import="com.company.entity1.EmploymentHistory"%>
<%@page import="com.company.entity1.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head >
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="userdetails2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <title>UserDetails</title>
</head>
<body>
<script type="text/javascript" src="userdetails.js" defer></script>
<div class="container">
    <f:form action="userdetails" method="POST" modelAttribute="allUserdetail" enctype="multipart/form-data">
        <div class="main-body">
            <div class="row">
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <div id="profile-container">
                                    <image id="profileImage" name="userimage" src="${allUserdetail.userImageName}"/>
                                </div>
                                <input id="imageUpload" type="file"  name="profilePhoto" placeholder="Photo">
                                <div class="mt-3">
                                    <h4>${allUserdetail.fullName}</h4>
                                    <p class="text-secondary mb-1">Full Stack Developer</p>
                                    <p class="text-muted font-size-sm">${allUserdetail.address}</p>
                                </div>
                            </div>

                            <hr class="my-4">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-globe me-2 icon-inline"><circle cx="12" cy="12" r="10"></circle><line x1="2" y1="12" x2="22" y2="12"></line><path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path></svg>Website</h6>
                                    <span class="text-secondary">https://bootdey.com</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-github me-2 icon-inline"><path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path></svg>Github</h6>
                                    <span class="text-secondary">bootdey</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter me-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                                    <span class="text-secondary">@bootdey</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram me-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                                    <span class="text-secondary">bootdey</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                    <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook me-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                                    <span class="text-secondary">bootdey</span>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>


                <div class="col-lg-8">
                    <div class="card">
                        <f:hidden path="id"/>
                        <div class="card-body">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Full Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input  path="fullName" class="form-control"  placeholder="Name"/>
                                </div>

                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input  path="email" class="form-control"  placeholder="Email"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Phone</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input  path="phone" class="form-control" id="whatIamtyping" placeholder="Phone"/>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Address</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input  path="address" class="form-control"  placeholder="Address"/>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">BirthDate</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input  path="birthDate" class="form-control" id="whatIamtyping" placeholder="BirthDate"/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">BirthPlace</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:select path="birthPlace" class="browser-default custom-select">
                                        <c:forEach items="${countries}" var="c">
                                            <f:option value="${c.id}">${c.name}</f:option>
                                        </c:forEach>
                                    </f:select>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Nationality</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:select path="nationality" class="browser-default custom-select">
                                        <c:forEach items="${countries}" var="c">
                                            <f:option value="${c.id}">${c.nationality}</f:option>
                                        </c:forEach>
                                    </f:select>
                               </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <f:button type="submit" class="btn btn-primary">Save Changes</f:button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h5 class="d-flex align-items-center mb-3">About me</h5>

                                </div>
                                <div class="col-sm-12 text-secondary">
                                    <f:textarea path="profileDesc" class="form-control rounded-0" rows="15"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <f:form />
                    <div class="card">
                        <div class="card-body">
                            <h5 class="d-flex align-items-center mb-3">Employment History</h5>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Header</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input path="header" class="form-control" />
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Begin date</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input path="beginDate" class="form-control" />
                                    </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">End Date</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:input path="endDate" class="form-control" />
                                </div>

                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Job Description</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <f:textarea path="jobDescription" class="form-control rounded-0"/>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">

                            <div class="card">
                                <div class="card-body" id="alluserskills">
                                    <h5 class="d-flex align-items-center mb-3">Skills</h5>
                                    <div id="userskills">
                                        <c:set var="count" value="${0}"/>
                                       <c:forEach items="${userSkillList}" var="us">
                                           <c:set var="count" value="${count+1}"/>
                                           <div id="${count}" class="databaseSkill">
                                            <label for="userskill">${us.skill.name}</label>
                                            <input type="hidden" name="skillID" value="${us.skill.id}">
                                            <input type="text" name="percentofskill"  class="no-outline" onkeyup="alterPercent(document.getElementById(${count}))" value="${us.power}%">
                                            <button type="button" name="minus" onClick="minusSkill(document.getElementById(${count}))" class="btnmns">Minus</button>
                                            <div class="progress mb-3 " style="height: 5px">
                                                <div class="progress-bar bg-primary" role="progressbar" style="width: ${us.power}%"></div>
                                            </div>
                                        </div>
                                       </c:forEach>
                                    </div>
                                    <select class="browser-default custom-select col-sm-9" name="skills" id="skillsforadd">
                                                    <c:forEach items="${skills}" var="s">
                                                        <option name="${s.id}">${s.name}</option>
                                                             </c:forEach>
                                    </select><button type="button" name="add" value="Add" id="addbtn"  class="col-sm-3" onclick="addSkill()">Add</button>

                                </div>
                            </div>

                        </div>
                    </div>

                </div>

            </div>
        </div>
    </f:form>
</div>
</body>
</html>
