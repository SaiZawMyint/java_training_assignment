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
        <legend>Default Setting</legend>
              <form:select path="coursename">
                <form:option value="NONE">--SELECT SETTING--</form:option>
                <form:options items="${allCourses }"/>
              </form:select>
              <i class="err-txt"><form:errors path="coursename"
              cssClass="error" /></i><br>
              <small>If course name match by excel dosen't match in database, you can analyse it by set default setting.</small>
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