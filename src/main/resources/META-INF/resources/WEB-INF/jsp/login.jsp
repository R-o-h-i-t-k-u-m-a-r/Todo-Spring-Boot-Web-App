<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Login Page</title>
</head>
<body>
    <h2>Custom Login Page</h2>
    <form method="post" action="/login">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>

    <c:if test="${param.error != null}">
        <p style="color: red;">Invalid username or password.</p>
    </c:if>

    <c:if test="${param.logout != null}">
        <p style="color: green;">You have been logged out.</p>
    </c:if>
</body>
</html>