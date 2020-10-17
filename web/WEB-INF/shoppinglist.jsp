<%-- 
    Document   : shoppinglist
    Created on : Oct 17, 2020, 2:00:12 PM
    Author     : 775653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p>
        <p><a href="?action=logout">Logout</a></p>
        
        <form action="ShoppingList" method="POST">
            <h2>Add Item</h2>
            <input type="test" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add"
        </form>
        
    </body>
</html>
