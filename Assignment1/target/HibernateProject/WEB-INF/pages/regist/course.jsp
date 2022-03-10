<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${title }</h2>
  <ul class="express-list clearfix">
    <c:forEach items="${courseForm }" var="course">
      <li class="course-li"><form:form method="Post"
          action="${pageContext.request.contextPath}/applicant"
          modelAttribute="applicantForm">

          <form:input path="id" value="${course.id }"
            hidden="hidden" />
          <button type="submit">
            <h2>${course.coursename }</h2>
            <div class="lists">
              <div class="item">
                <b>Schedule</b> : <span>${course.schedule }</span>
              </div>
              <div class="item">
                <b>Price</b> : <span>${course.price }</span>
              </div>
              <div class="item">
                <b>Post date</b> : <span>${course.date }</span>
              </div>
            </div>
          </button>
        </form:form></li>
    </c:forEach>
    <li class="course-li add">
      <form:form>
        <button class="">Add New</button>
      </form:form>
    </li>
  </ul>
  <table class="course-tb-list" style="width: 500px">
    <tr>
      <th>Id</th>
      <th>Username</th>
      <th>Course</th>
      <th>Schedule</th>
      <th>Prices</th>
      <th>Edit/Delete</th>
    </tr>
    <c:forEach items="${registratedList}" var="registrated">
      <tr>
        <td width="60" align="center">${registrated.courseId}</td>
        <td width="60" align="center">${registrated.username}</td>
        <td width="150" align="center">${registrated.coursename}</td>
        <td width="150" align="center">${registrated.schedule}</td>
        <td width="150" align="center">${registrated.prices}</td>
        <td width="150" align="center"><a
          href="${pageContext.request.contextPath}/edit/${course.courseId}">Edit</a>/
          <a
          href="${pageContext.request.contextPath}/delete/${course.courseId}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>