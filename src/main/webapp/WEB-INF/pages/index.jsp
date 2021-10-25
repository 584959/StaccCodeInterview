<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>KYC</title>
    </head>
    <body>
        <h1><%= "Know Your Customer" %>
        </h1>
        <br/>
        <form action="home" method="post">
            <input type="text" name="name" placeholder="Search by name, category" id="name"/>
            <input type="submit" value="Search" />
        </form>
        <p style="color:red;">${errorMessage}</p>
    </body>
</html>