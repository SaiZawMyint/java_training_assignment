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
  <h2>${title}</h2>
  <c:if test="${systemMessage != null}">
    <div class="message-field">
      <p>${systemMessage}</p>
    </div>
  </c:if>
  <h5>
    <a href="${pageContext.request.contextPath }/home">Return To
      Courses Page</a>
  </h5>
</body>
</html>