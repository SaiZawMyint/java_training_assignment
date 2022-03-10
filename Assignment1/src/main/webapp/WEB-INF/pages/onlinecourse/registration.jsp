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
        action="${pageContext.request.contextPath}/form"
        modelAttribute="infromationForm">
        <form:input path="id" hidden="hidden" />
        <form:input path="courseId" value="${informationForm.courseId }"
          hidden="hidden" />
        <fieldset>
          <form:input type="text" path="username" class="inp"
            placeholder="Username" />
          <i class="err-txt"><form:errors path="username"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="text" path="email" class="inp"
            placeholder="Email Address" />
          <i class="err-txt"><form:errors path="email"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="Number" path="phone" class="inp"
            placeholder="Phone Number" />
          <i class="err-txt"><form:errors path="phone"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="text" path="address" class="inp"
            placeholder="Address" />
          <i class="err-txt"><form:errors path="address"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <button type="submit" class="btn">Submit</button>
        </fieldset>

      </form:form>
    </div>
  </div>
</body>
</html>