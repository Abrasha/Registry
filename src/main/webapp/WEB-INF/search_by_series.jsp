<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Search registry by series:</h1>
<div class="form-group">
    <form:form method="get" action="/search/by_series/res" cssclass="form-control">
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <input type="text" name="series">
        <input type="submit" value="Go">
    </form:form>
</div>
<%@include file="include/footer.jsp" %>