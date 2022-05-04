<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
Register Please.
<form name="register" action="/login/register" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input id="user_id" name="username" placeholder="id" type="text" required="true" />
    <input id="email" name="email" placeholder="email" type="email" required="true" />
    <input id="password" name="password" placeholder="password" type="password" required="true" />
    <input id="password_confirm" name="password_confirm" placeholder="confirm password" type="password" required="true" />
    <button id="register" name="register" type="submit">Register!</button>
</form>
</body>
</html>