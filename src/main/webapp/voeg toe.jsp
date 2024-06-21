<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head >
    <title>Voeg Toe</title>
    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>
<main>


    <section class="grid24">

        <c:if test="${not empty errors}">
            <div id="error" class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <br>

        <div  class="formulier">



            <h2>Vul onderstaande velden in om een auto aan de spotlijst toe te voegen</h2>
            <form method="POST" action="Servlet?command=add" novalidate>


                <div class="column">
                    <label for="Merk"><strong>Merk:</strong></label>
                    <input class="inputformulier" type="text" id="Merk" name="input_merk" value="${merkPreviousValue}" required>
                    <br>

                    <label for="Model"><strong>Model:</strong></label>
                    <input class="inputformulier" type="text" id="Model" name="input_model" value="${modelPreviousValue}" required>
                    <br>

                    <label for="Pk"><strong>PK:</strong></label>
                    <input class="inputformulier" type="number" id="Pk" name="input_pk" value="${pkPreviousValue}">
                    <br>

                    <label for="Aantal"><strong>Aantal keer gespot:</strong></label>
                    <input class="inputformulier" type="number" id="Aantal" name="input_spots" value="${spotsPreviousValue}" required>

                </div>

                <div>
                    <input id="submit" type="submit" value="Verzenden">
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