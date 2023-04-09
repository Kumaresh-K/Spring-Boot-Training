<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<form:form action="/banking/newuser" method="POST" modelAttribute="user">
    ID : <form:input path="userid"/><br>
    Name  : <form:input path="name"/><br>
    Amount : <form:input path="amount"/><br>
    <input type="submit" value="Add User">
</form:form>