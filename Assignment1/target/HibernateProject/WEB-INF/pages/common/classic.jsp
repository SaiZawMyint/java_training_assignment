<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"/></title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'>
</head>
<body>
  <div class="wrapper">
    <section class="header-sec">
      <div class="container clearfix">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
      </div>
    </section>
    <section class="content-sec">
      <div class="container"><tiles:insertAttribute name="body" /></div>
    </section>
    <section class="footer-sec">
      <div class="container"><tiles:insertAttribute name="footer" /></div>
    </section>
  </div>
</body>
</html>