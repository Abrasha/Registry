<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Search registry by date:</h1>
<div class="form-group">
    <form:form method="post" action="/registries">
        <input name="number" placeholder="number...">
        <input name="numberInActionList" placeholder="number in action list...">
        <input name="series" placeholder="series...">
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <label>Irrevocability:
            <input type="text" name="irrevocabilty" value="<c:out value="${fmt}"/>"/>
        </label>
        <input name="principalIDN" placeholder="principal idn...">
        <input name="notaryIDN" placeholder="notary idn...">
        <input name="confIDNs" placeholder="idn1,idn2,idn3..">
        <input name="propertyRegNumber" placeholder="property reg number...">
        <input name="other" placeholder="description...">
        <input type="submit" value="Add">
    </form:form>
</div>

<%@include file="include/footer.jsp" %>