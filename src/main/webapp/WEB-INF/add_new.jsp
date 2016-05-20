<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Add new registry:</h1>
<div class="form-group">
    <form:form method="post" action="/registries" modelAttribute="registry">
        <input name="number" placeholder="number...">
        <input name="numberInActionList" placeholder="number in action list..."><br>
        <input name="series" placeholder="series..."><br>
        <fmt:formatDate pattern="dd.MM.yyyy" var="fmt" value=""/>
        <label>Irrevocability:
            <input type="text" name="irrevocabilty" value="<c:out value="${fmt}"/>"/>
        </label><br>
        <label>Principal:
            <form:select path="principalName" multiple="false">
                <c:forEach var="i" items="${people}">
                    <form:option value="${i.name}" label="${i.name}"/>
                </c:forEach>
            </form:select>
        </label><br>
        <label>Confs:
            <form:select path="confs" multiple="true">
                <c:forEach var="i" items="${people}">
                    <form:option value="${i.name}" label="${i.name}"/>
                </c:forEach>
            </form:select>
        </label><br>
        <label>Notary:
            <form:select path="notaryId">
                <c:forEach var="i" items="${notaries}">
                    <form:option value="${i.id}" label="${i.organisation}"/>
                </c:forEach>
            </form:select>
        </label><br>
        <label>Property:
            <form:select path="propertyRegNumber">
                <c:forEach var="i" items="${properties}">
                    <form:option value="${i.registrationNumber}" label="${i.description}"/>
                </c:forEach>
            </form:select>
        </label><br>

        <input name="other" placeholder="description..."><br>
        <input type="submit" value="Add"><br>
    </form:form>
</div>

<%@include file="include/footer.jsp" %>