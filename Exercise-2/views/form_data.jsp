<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>form data</title>
</head>
<body>
    <h3><%= request.getAttribute("mykey") %> </h3>
    <h3><%= request.getAttribute("hello") %> </h3>
    <h3><%= session.getAttribute("myattr") %></h3>
</body>
</html>