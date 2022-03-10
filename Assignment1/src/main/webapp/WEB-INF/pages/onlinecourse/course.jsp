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
          <form:input path="id" value="${course.id }" hidden="hidden" />
          <form:input path="coursename" value="${course.coursename }"
            hidden="hidden" />
          <form:input path="schedule" value="${course.schedule }"
            hidden="hidden" />
          <form:input path="price" value="${course.price }"
            hidden="hidden" />
          <form:input path="date" value="${course.date }"
            hidden="hidden" />
          <div class="c-field">
            <div class="cur-img"></div>
            <div class="list-f">
              <h2>${course.coursename }</h2>
              <div class="lists">
                <div class="item">
                  <b>Schedule</b> : <span>${course.schedule }</span>
                </div>
                <div class="item">
                  <b>Price</b> : <span>${course.price }$</span>
                </div>
                <div class="item">
                  <b>Post date</b> : <span>${course.date }</span>
                </div>
                <div class="btn-f">
                  <input name="button" type="submit" class="btn submit"
                    value="Enroll" />
                </div>
              </div>
            </div>
          </div>
        </form:form></li>
    </c:forEach>
  </ul>
  <table>
    <tr>
      <th style="width: 120px;">Username</th>
      <th style="width: 200px;">Course name</th>
      <th style="width: 250px;">Schedule</th>
      <th style="width: 120px;">Prices</th>
      <th style="width: 120px;">Edit/Delete</th>
    </tr>
    <c:forEach items="${courseList }" var="course">
      <tr>
        <td>${course.username }</td>
        <td>${course.coursename }</td>
        <td>${course.schedule }</td>
        <td>${course.prices }$</td>
        <td><a
          href="${pageContext.request.contextPath}/form/edit/${course.userid }/${course.courseId}">Edit</a>
          / <a
          href="${pageContext.request.contextPath }/form/delete/${course.userid }/${course.courseId}">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>