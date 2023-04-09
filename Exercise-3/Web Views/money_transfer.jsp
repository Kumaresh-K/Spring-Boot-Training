<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<form:form action="/banking/money_transfer" method="POST" modelAttribute="transfer">
    Credit ID : <form:input path="creditID"/><br>
    Debit ID : <form:input path="debitID"/><br>
    Amount : <form:input path="amount"/><br>
    <input type="submit" value="Transfer Amount">
</form:form>