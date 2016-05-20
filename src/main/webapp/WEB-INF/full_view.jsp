<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1>Registry details</h1>

<dl class="dl-horizontal">
    <dt>Number</dt>
    <dd>${reg.number}</dd>
    <dt>Number in action list</dt>
    <dd>${reg.numberInActionList}</dd>
    <dt>Series</dt>
    <dd>${reg.series}</dd>
    <dt>Date</dt>
    <dd>${reg.date}</dd>
    <dt>Irrevocability</dt>
    <dd>
        <c:if test="${empty reg.irrevocability}">
            none
        </c:if>
        <c:if test="${not empty reg.irrevocability}">
            ${reg.irrevocability}
        </c:if>
    </dd>
    <dt>Notary</dt>
    <dd>${reg.notary.organisation}</dd>
    <dt>Principal</dt>
    <dd>
        <a href="/people/${reg.principal.id}">${reg.principal.name}</a>
    </dd>
    <dt>Confidants</dt>
    <dd>
        <ol>
            <c:forEach var="conf" items="${reg.confidants}">
                <li>
                    <a href="/people/${conf.id}">${conf.name}</a>
                </li>
            </c:forEach>
        </ol>
    </dd>
    <dt>Property</dt>
    <dd>${reg.property.description}</dd>
    <dt>other</dt>
    <dd>${reg.other}</dd>
</dl>

<%@include file="include/footer.jsp" %>