<!DOCTYPE html>
<html lang="en">
<head>
    <title>Log in</title>
</head>
<body>
<h1>Login Page</h1><br/>
<br/>
<h4>${message}</h4>
<form type="hidden" method="post">
    id:
    <br/>
    <input type="text" name="user_id">
    <br/>
    name:
    <br/>
    <input type="text" name="user_name">
    <br/>
    password:
    <br/>
    <input type="text" name="user_password">
    <br/>
    <br/>
    <input type="submit" value="log in">
</form>
<br/>
<a href="/menu">Menu</a>
</body>
</html>