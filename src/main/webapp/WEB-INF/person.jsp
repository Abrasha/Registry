<%@include file="include/header.jsp" %>

<h1>Some details about person ${person.name}</h1>
<dl class="dl-horizontal">
    <dt>ID</dt>
    <dd>${person.id}</dd>
    <dt>Name</dt>
    <dd>${person.name}</dd>
    <dt>Person type</dt>
    <dd>${person.personType}</dd>
    <dt>Other</dt>
    <dd>${person.other}</dd>
</dl>
<%@include file="include/footer.jsp" %>