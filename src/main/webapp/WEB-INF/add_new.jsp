<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Search registry by date:</h1>
<div class="form-group">
    <form:form method="post" action="/registries" modelAttribute="newReg">
        <input name="number" placeholder="number...">
        <input name="numberInActionList" placeholder="number in action list...">
        <input name="series" placeholder="series...">
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <label>Irrevocability:
            <input type="text" name="irrevocabilty" value="<c:out value="${fmt}"/>"/>
        </label>
        <form:select path="principal" items="${people}" itemValue="id" itemLabel="name">
        </form:select>
        <input name="notaryIDN" placeholder="notary idn...">
        <%--<form:select path="confs" itemValue="">--%>
        <%--<form:option value="NONE"> --SELECT--</form:option>--%>
        <%--<form:options items="${people}" itemLabel="name"></form:options>--%>
        <%--</form:select>--%>
        <input name="propertyRegNumber" placeholder="property reg number...">

        <%--<form:select path="property">--%>
        <%--<form:option value="NONE"> --SELECT--</form:option>--%>
        <%--<form:options items="${properties}"></form:options>--%>
        <%--</form:select>--%>
        <input name="other" placeholder="description...">
        <input type="submit" value="Add">
    </form:form>
</div>

<%@include file="include/footer.jsp" %>