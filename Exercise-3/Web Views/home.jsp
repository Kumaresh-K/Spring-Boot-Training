<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<form:form action="/banking/create_account" method="GET">
    <input type="submit" value="Create Account">
</form:form>
<form:form action="/banking/find_account" method="GET">
    <input type="submit" value="Find Account">
</form:form>
<form:form action="/banking/money_transfer" method="GET">
    <input type="submit" value="Transfer Money">
</form:form>