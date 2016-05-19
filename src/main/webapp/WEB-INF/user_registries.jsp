<%@include file="include/header.jsp" %>
<h1>The registries of user: ${user.login}</h1>
<table class="table">
    <caption>Registries associated with you</caption>
    <tr>
        <th>ID</th>
        <th>Number</th>
        <th>Date</th>
    </tr>
    <c:forEach var="reg" items="${regs}">
        <tr>
            <td>${reg.id}</td>
            <td>${reg.number}</td>
            <td>${reg.date}</td>
            <td>
                <ol>
                    <c:forEach var="conf" items="${reg.confidants}">
                        <li>
                            <a href="/people/${conf.id}">${conf.name}</a>
                        </li>
                    </c:forEach>
                </ol>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="include/footer.jsp" %>