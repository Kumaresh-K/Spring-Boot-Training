<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<form:form action="/banking/home" method="GET" modelAttribute="user">
    ID : ${user.userid} <br>
    Name : ${user.name} <br>
    Amount : ${user.amount} <br><br>
    <input type="submit" value="Go to Home">
</form:form>