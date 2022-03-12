<nav class="navigation">
  <ul class="menu-ul clearfix">
    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/viewlists">Applicant
        List</a></li>
    <li>
      <form action="<%=request.getContextPath()%>/logout" method="POST">
        <input class="btn" type="submit" value="Logout" /> <input type="hidden"
          name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </li>
  </ul>
</nav>