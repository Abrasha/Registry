<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp"%>
<h1>Search registry by date:</h1>
<div class="form-group">
    <form:form method="get" action="/search/by_date/res">
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <label>Date of registry:
            <input type="text" name="dateOfRegistry" value="<c:out value=" ${fmt}"/>"/>
        </label>
        <input type="submit" value="Go">
    </form:form>
</div>

<%@include file="include/footer.jsp" %>