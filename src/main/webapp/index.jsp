<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Userliste</title>
</head>
<body>
<h1>Alle Benutzer</h1>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Subscription</th><th>Aktiv</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td><a href="users?id=${u.userId}">${u.userId}</a></td>
            <td>${u.firstName} ${u.lastName}</td>
            <td>${u.email}</td>
            <td>${u.subscriptionType}</td>
            <td><c:choose>
                <c:when test="${u.active}">Ja</c:when>
                <c:otherwise>Nein</c:otherwise>
            </c:choose></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
