<%@ page import="domain.model.Auto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="Stijl.css">
    <link href="https://fonts.googleapis.com/css2?family=Karla&family=Lora:wght@700&display=swap" rel="stylesheet">


    <title>deleteBevestiging</title>
    <link rel="shortcut icon" type="image/png" href="favicon-32x32.png"/>
</head>
<body>
<header>
    <h1>Atr Carspotting</h1>
    <jsp:include page="nav.jsp"/>
</header>

<main>
    <section class="grid24" >
    <h2>Bevestiging</h2>
        <p>Ben je zeker dat je wilt verwijderen?</p>
        <br>

        <div id="verwijderen2">
    <form action="Servlet?command=remove&id=${requestScope.id}" method="post" novalidate>

        <p><input id="verwijderen" type="submit" value="Ja" class="verwijderen"></p>
    </form>
    <form action="Servlet?command=overzicht" method="post" novalidate>
        <p><input id="nietVerwijderen" type="submit" value="Nee" class="verwijderen"></p>
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
