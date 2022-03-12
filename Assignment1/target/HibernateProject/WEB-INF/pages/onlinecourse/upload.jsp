<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
        action="${pageContext.request.contextPath}/excel/upload?${_csrf.parameterName}=${_csrf.token}"
        modelAttribute="excelForm"  enctype="multipart/form-data">
        <fieldset>
          <%-- <form:input type="text" path="filename" class="inp"
            placeholder="Sheet Name"  />
          <i class="err-txt"><form:errors path="filename"
              cssClass="error" /></i> --%>
              <form:select path="coursename">
                <form:option value="NONE">--SELECT COURSE--</form:option>
                <form:options items="${allCourses }"/>
              </form:select>
              <i class="err-txt"><form:errors path="coursename"
              cssClass="error" /></i>
        </fieldset>
        <fieldset>
          <form:input type="file" path="excfile" class="inp"
            placeholder="Excel File" />
          <i class="err-txt"><form:errors path="excfile"
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