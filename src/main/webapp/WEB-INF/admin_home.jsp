<%@include file="include/header.jsp" %>

<%@include file="include/admin_nav.jsp"%>
<div>
    <h1>Admin home</h1>
    <p>${user.login}</p>
    <p>${user.password}</p>
    <p>${user.id}</p>
</div>
<%@include file="include/footer.jsp" %>