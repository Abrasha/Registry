<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>

<h1>Search registry by date:</h1>
<div class="form-group">
    <form:form method="get" action="/search/by_date/res">
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <label>Date of registry:
            <input id="dateee" type="text" name="dateOfRegistry" value="<c:out value="${fmt}"/>"
                   placeholder="dd.MM.yyyy" pattern="\d\d\.\d\d\.\d{4}" required/>
        </label>
        <input type="submit" value="Go">
    </form:form>
</div>

<%@include file="include/footer.jsp" %>