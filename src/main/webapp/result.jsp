<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Auto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>Result</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>
<main>
    <section class="grid24">
    <h2>Zoekresultaat</h2>

    <c:choose>
        <c:when test="${auto !=null}">

            <p >Dit is de informatie die we vonden over de auto van het model ${param.input_model_zoek} :</p>
            <br>
            <div class="resultPage">
            <ul>
                <li>Merk: ${auto.merk}</li>
                <li>Model: ${auto.model}</li>
                <li>Aantal PK: ${auto.pk}</li>
                <li>Aantal spots: ${auto.aantalSpots}</li>
            </ul>
            </div>
        </c:when>
        <c:otherwise>
            <p class="resultPage">Helaas, we konden geen auto van het model ${param.input_model_zoek} vinden in de spotlijst. </p>
        </c:otherwise>

    </c:choose>
    </section>
    <br>
</main>


<footer id="footer1">

    <p>Webontwikkeling 2 - @Atr Carspotting - &copy; 2021-2022
    </p>
</footer>
</body>
</html>
