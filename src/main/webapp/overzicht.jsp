<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Auto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>Overzicht</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>



<main>


    <section class="grid24">

        <h2 id="lijstH2">Hier een overzicht van alle gespotte auto's.</h2>

        <div>

            <table  id="lijst">
                <thead>
                <tr>
                    <th>Merk</th>
                    <th>Model</th>
                    <th>PK</th>
                    <th>Aantal spots</th>
                    <th>Update</th>
                    <th>Verwijder</th>
                </tr>
                </thead>




               <tbody>
<c:choose>
    <c:when test="${!empty geefautos}">
                <c:forEach var="auto" items="${geefautos}">
                    <tr>
                        <td>${auto.merk}
                        </td>
                        <td>${auto.model}
                        </td>
                        <td>${auto.pk}
                        </td>
                        <td>${auto.aantalSpots}
                        </td>
                        <td><a href="Servlet?command=updateConfirmPage&id=${auto.id}">Update</a></td>
                        <td><a href="Servlet?command=removeConfirmPage&id=${auto.id}">Verwijder</a></td>
                    </tr>
                </c:forEach>
    </c:when>
    <c:otherwise>

        <td></td>
        <td></td>
        <td></td>
        <td id="nietsTeZien"><p>  Hier is niets te zien. </p></td>

    </c:otherwise>

</c:choose>
                </tbody>

            </table>
        </div>
        <br>
        <br>
        <p>Momenteel meest gespot: ${meestgespotte}</p>


    </section>
    <br>



</main>



<footer id="footer1">

    <p>Webontwikkeling 2 - @Atr Carspotting - &copy; 2021-2022</p>
</footer>
</body>
</html>

