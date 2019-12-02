<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>Menu</h1><br/>
<list>
    <li>
        <#if isUserLoggedIn == true>
            <a href="login_Logged.ftl">LogIn</a>
        <#else>
            <a href="login_NotLogged.ftl">LogIn</a>
        </#if>
    </li>
    <li>
        <a href="logout_Logged.ftl">LogOut</a>
    </li>
    <li>
        <a href="calc_Logged.ftl">Calc</a>
    </li>
    <li>
        <a href="history_Logged.ftl">History</a>
    </li>
</list>
</body>
</html>