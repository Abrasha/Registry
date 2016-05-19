<%@include file="include/header.jsp" %>
<%@include file="include/admin_nav.jsp" %>
<h1 style="text-align: center;">Notary</h1>

<p><input name="AddNew" type="button" value="Add New"/></p>

<p style="text-align: center;"><span style="font-size:20px;">Search:</span></p>

<p><span style="font-size:16px;">Search by number in registry:  Number: <input maxlength="20"
                                                                               name="id"
                                                                               size="20"
                                                                               type="text"/><input
        name="SearchById" type="button" value="Search"/></span></p>

<p><span style="font-size:16px;">Search by series and number:  Series:  <input name="Series"
                                                                               size="10"
                                                                               type="text"/> Number:  <input
        name="Number" size="10" type="text"/></span> <input name="SearchBySeriesAndNumber"
                                                            type="button" value="Search"/></p>

<p>Search by date and number in action list: Date: <input name="date" type="date"/> Nuber in action
    list: <input maxlength="15" name="ActionListNumber" size="15" type="text"/> <input
            name="SearchByDateAndActionListNumber" type="button" value="Search"/></p>

<p>Search by principal: Initials: <input maxlength="50" name="principal" size="50" type="text"/><input
        name="SearchByPrincipalName" type="button" value="Search"/></p>

<p>Search by confidant: Initials: <input maxlength="50" name="confidant" size="50" type="text"/><input
        name="SearchByConfidantName" type="button" value="Search"/></p>


<p>Search by number of property: Number:<input maxlength="20" name="PropertyNumber" size="20" type="text"/><input
        name="SearchByPropertyNumber" type="button" value="Search"/></p>
<%@include file="include/footer.jsp" %>