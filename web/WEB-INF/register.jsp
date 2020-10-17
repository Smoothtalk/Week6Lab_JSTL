<%-- 
    Document   : register
    Created on : Oct 17, 2020, 2:00:02 PM
    Author     : 775653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="POST">        
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register">
        </form>
    </body>
</html>
