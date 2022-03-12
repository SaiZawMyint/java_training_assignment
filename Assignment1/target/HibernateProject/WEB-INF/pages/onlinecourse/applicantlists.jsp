<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
      <th style="width: 200px;">Course name</th>
      <th style="width: 120px;">Username</th>
      <th style="width: 250px;">Email</th>
      <th style="width: 120px;">Phone Number</th>
      <th style="width: 120px;">Address</th>
      <th style="width: 120px;">Edit/Delete</th>
    </tr>
    <c:forEach items="${courseList }" var="course">
      <tr>
        <td>${course.coursename }</td>
        <td>${course.username }</td>
        <td>${course.email }</td>
        <td>${course.phone }</td>
        <td>${course.address }</td>
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