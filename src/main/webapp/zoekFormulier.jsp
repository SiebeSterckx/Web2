<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>Zoeken</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>

<main>


    <section class="grid24">
        <c:if test="${not empty errors2}">
            <div id="error" class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors2}" var="error2">
                        <li>${error2}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <br>

        <div  class="formulier">

            <h2>Vind een auto</h2>

            <p>Vul het model van de auto dat je wil zoeken hieronder in:</p>
            <form action="Servlet" novalidate>
                <input type="hidden" name="command" value="zoek">

                <div class="column">
                    <label for="Model"><strong>Model:</strong></label>
                    <input class="inputformulier" type="text" id="Model" name="input_model_zoek" value="" required>

                </div>

                <div>
                    <input id="submit" type="submit" value="Verzenden" >
                </div>

            </form>
        </div>
    </section>
    <br>
</main>



<footer id="footer1">

    <p>Webontwikkeling 2 - @Atr Carspotting - &copy; 2021-2022
    </p>
</footer>
</body>
</html>
