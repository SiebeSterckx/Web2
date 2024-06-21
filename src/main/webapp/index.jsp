<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>Index</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>



<main>

    <section class="grid24">
        <h2>Welkom op mijn spotlijst</h2>
        <p>Beste bezoekers, mijn naam is Arnaud Terrie. Ik ben geboren in 2002 en mijn hobby is carspotten. Op deze website kan je een overzicht zien van welke supercars ik al allemaal heb kunnen spotten. Deze lijst wordt steeds up-to-date gehouden. Je kan ook steeds zelf jouw gespotte auto's toevoegen aan de spotlijst door <a href="voeg%20toe.jsp"><strong>dit formulier</strong></a> in te vullen.</p>
        <br>
        <br>
        <br>
        <p>Momenteel meest gespot: ${meestgespotte}</p>
        <br>
        <p>${laatstAangepast}</p>
        <br>
        <c:if test="${!empty sessionScope.laatstVerwijderdeAuto}">
            <form method="POST" action="Servlet" >
                <input type="hidden" name="command" value="addMetVerwijderSession">
            <button type="submit" class="verwijderenOngedaan">Verwijderen ongedaan maken</button>
            </form>
        </c:if>

    </section>
    <br>



</main>



<footer id="footer1">

    <p>Webontwikkeling 2 - @Atr Carspotting - &copy; 2021-2022
    </p>
</footer>

</body>
</html>