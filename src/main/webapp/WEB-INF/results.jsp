<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Search results:</h1>

<table class="table">
    <caption>Search results:</caption>
    <thead>
    <tr>
        <th>Property number</th>
        <th>Series</th>
        <th>Date</th>
        <th>Notary</th>
        <th>Principal</th>
        <th>Confidants</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="reg" items="${result}">
        <tr>
            <td>${reg.property.serialNumber}</td>
            <td>${reg.series}</td>
            <td>${reg.date}</td>
            <td>${reg.notary.organisation}</td>
            <td>
                <a href="/people/${reg.principal.id}">${reg.principal.name}</a>
            </td>
            <td>
                <ol>
                    <c:forEach var="conf" items="${reg.confidants}">
                        <li>
                            <a href="/people/${conf.id}">${conf.name}</a>
                        </li>
                    </c:forEach>
                </ol>
            </td>
            <td>
                <a href="/registries/${reg.id}">Open</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="include/footer.jsp" %>