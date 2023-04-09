<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<form:form action="/banking/find_account" method="POST" modelAttribute="user">
    ID : <form:input path="userid"/><br>
    <input type="submit" value="Find User">
</form:form>