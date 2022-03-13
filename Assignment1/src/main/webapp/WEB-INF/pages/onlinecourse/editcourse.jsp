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
  <div class="reg-field">
    <div class="form-inner">
      <h2>${title}</h2>
      <c:if test="${systemMessage != null}">
        <div class="message-field">
          <p>${systemMessage}</p>
        </div>
      </c:if>
      <form:form method="Post"
        action="${pageContext.request.contextPath}/edit/course/form"
        modelAttribute="courseForm">
        <form:input path="id" value="${courseForm.id }" hidden="hidden" />
        <fieldset>
          <form:input type="text" path="coursename" class="inp"
            placeholder="Course Name" value="${courseFrom.coursename }" />
          <i class="err-txt"><form:errors path="coursename"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="text" path="schedule" class="inp"
            placeholder="Schedule" value="${courseFrom.schedule }" />
          <i class="err-txt"><form:errors path="schedule"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="Number" path="price" class="inp"
            placeholder="Prices" value="${courseFrom.coursename }" />
          <i class="err-txt"><form:errors path="price"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <a href="${pageContext.request.contextPath}/home"
            class="btn ed">Back</a>
          <button name="button" type="submit" class="btn submit">Submit</button>
        </fieldset>
      </form:form>
    </div>
  </div>
</body>
</html>