<%@include file="include/header.jsp" %>
<h1>Welcome!</h1>

<form:form method="post" action="/login" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="login"></form:label></td>
            <td><form:input path="login"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="password"></form:label></td>
            <td><form:password path="password"></form:password></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Log in">
            </td>
        </tr>
    </table>
</form:form>
<%@include file="include/footer.jsp" %>