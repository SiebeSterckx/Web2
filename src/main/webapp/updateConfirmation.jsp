<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Auto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>updateBevestiging</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>

<main>

    <section class="grid24" >
        <c:if test="${not empty errors3}">
            <div id="error" class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors3}" var="error3">
                        <li>${error3}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <br>
        <div  class="formulier">



            <h2>Vul onderstaand veld in om het aantal keren dat u deze auto heeft gespot aan te passen.</h2>
            <form method="POST" action="Servlet?command=update&id=${id}" novalidate>

                <div class="column">

                    <label for="Aantal"><strong>Aantal keer gespot:</strong></label>
                    <input class="inputformulier" type="number" id="Aantal" name="input_spots" value="${updateAutoSpots}" required>

                </div>
                    <input id="submit" type="submit" value="Update">

            </form>

        </div>

        </section>
    <div id="grid24annuleer">
    <form  action="Servlet?command=overzicht" method="post" novalidate>
        <p><input id="annuleer" type="submit" value="Annuleer" class="update"></p>
    </form>
    </div>
    <br>


</main>



<footer id="footer1">

    <p>Webontwikkeling 2 - @Atr Carspotting - &copy; 2021-2022
    </p>
</footer>
</body>
</html>
