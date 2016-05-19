<%@include file="include/header.jsp" %>
<h1 style="text-align: center;">Notary</h1>

<p><input name="AddNew" type="button" value="Add New"/></p>

<p style="text-align: center;"><span style="font-size:20px;">Search:</span></p>

<p><span style="font-size:16px;">Search by number in registry: &nbsp; &nbsp;Number: &nbsp;&nbsp;<input maxlength="20"
                                                                                                       name="id"
                                                                                                       size="20"
                                                                                                       type="text"/>&nbsp;&nbsp;<input
        name="SearchById" type="button" value="Search"/></span></p>

<p><span style="font-size:16px;">Search by series and number: &nbsp; &nbsp;Series: &nbsp; &nbsp;<input name="Series"
                                                                                                       size="10"
                                                                                                       type="text"/>&nbsp;&nbsp; &nbsp;Number: &nbsp; &nbsp;<input
        name="Number" size="10" type="text"/></span>&nbsp; &nbsp;&nbsp;<input name="SearchBySeriesAndNumber"
                                                                              type="button" value="Search"/></p>

<p>Search by date and nuber in action list: &nbsp;Date: <input name="date" type="date"/>&nbsp; &nbsp; Nuber in action
    list: <input maxlength="15" name="ActionListNumber" size="15" type="text"/>&nbsp; <input
            name="SearchByDateAndActionListNumber" type="button" value="Search"/>&nbsp;</p>

<p>Search by principal: Initials:&nbsp;<input maxlength="50" name="principal" size="50" type="text"/>&nbsp;<input
        name="SearchByPrincipalName" type="button" value="Search"/></p>

<p>Search by confidant: Initials:&nbsp;<input maxlength="50" name="confidant" size="50" type="text"/>&nbsp;<input
        name="SearchByConfidantName" type="button" value="Search"/></p>


<p>Search by number of property: &nbsp; &nbsp;Number:<input maxlength="20" name="PropertyNumber" size="20" type="text"/>&nbsp;&nbsp;&nbsp;<input
        name="SearchByPropertyNumber" type="button" value="Search"/></p>
<%@include file="include/footer.jsp" %>