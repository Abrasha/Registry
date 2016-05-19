<%@include file="include/header.jsp"%>
<h1 style="text-align: center;">Add New Attorney</h1>

<p style="text-align: center;">Series:<input maxlength="10" name="Series" size="10" type="text" />&nbsp; &nbsp; &nbsp; &nbsp;Number:<input maxlength="20" name="Number" size="20" type="text" />&nbsp; &nbsp;Number in Actions List:<input maxlength="20" name="ActionListNumber" size="20" type="text" /></p>

<p style="text-align: center;">Principals number:<input maxlength="20" name="Principal" size="20" type="text" /></p>

<p style="text-align: center;">Confidants numbers:<input maxlength="300" name="Confidants" size="75" type="text" /></p>

<p style="text-align: center;">Number of property:&nbsp;<input maxlength="20" name="Property" size="20" type="text" /></p>

<p style="text-align: center;">Irrevocability: <input name="irrevocability" type="date" /></p>

<p style="text-align: center;">Description:<textarea cols="100" name="Description" rows="10"></textarea></p>

<p style="text-align: center;"><input name="Insert" type="button" value="Add" /></p>

<%@include file="include/footer.jsp"%>
