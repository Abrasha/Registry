<%@include file="include/header.jsp" %>

<h1>Error occurred</h1>

Failed URL: ${url}
Exception:  ${exception.message}
<c:forEach items="${exception.stackTrace}" var="ste">
    ${ste}
</c:forEach>
<%@include file="include/footer.jsp" %>