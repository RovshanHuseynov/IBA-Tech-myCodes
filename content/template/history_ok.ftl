<!doctype html>
<html lang="en">
<head>
    <title>History</title>
</head>
<body>
<h1>History Page</h1>
<br/>
<h4>${message}</h4>
<br/>
<table border="0">
    <#list datas as data>
        <tr>
            <td>
                ${data}
            </td>
        </tr>
    </#list>
</table>
<br/>
<a href="/menu">Menu</a>
</body>
</html>