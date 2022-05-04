<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
Login Please.
<form name="login"<%-- action="/login/submit?${_csrf.parameterName}=${_csrf.token}"--%> method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input id="userId" name="username" placeholder="id" type="text" />
    <input id="password" name="password" placeholder="password" type="password" />
    <button id="login" name="login" type="submit">login!</button>
</form>
</body>
</html>