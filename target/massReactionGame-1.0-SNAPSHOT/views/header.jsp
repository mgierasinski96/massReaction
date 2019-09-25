<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 22.09.2019
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash&display=swap" rel="stylesheet">
    <style>
        #container
        {
            width: 100%;
            height: 100%;
            position: relative;
        }
        #logo
        {
            position:absolute;
            margin-top: 10px;
            margin-left: -250px;
            left:50%;
            width: 500px;
            height: 120px;
        }

        #logo:hover

        {
           opacity: 0.7;
        }
        #wikingHead
        {
            position: absolute;
            margin-top: 5px;
            margin-left: 2%;
            width: 130px;
            height: 130px;
            background-image: url(/resources/backgrounds/wikingHead.png);
        }


        .textContent
        {
            font-family: 'Berkshire Swash', cursive;
            font-size: 40px;
            position: absolute;
            margin-top: 70px;
            margin-left: 73%;
            font-style: italic;


        }

        .textContent ul
        {
            text-decoration: none;
            list-style: none;
        }
        .textContent li
        {
            position: relative;
            text-decoration: none;
            list-style: none;
            float: left;

        }
        .textContent li a
        {
            padding: 10px;
            text-decoration: none;
            background: -webkit-linear-gradient(yellow, red);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            display: inline-block;
            float: left;

        }
        .textContent li a:hover
        {
            opacity:0.7;
        }

    </style>
</head>
<body>
<div id="container">
    <div id="logo"><a href="/.html"><img src="/resources/backgrounds/logo.png"></a></div>
    <div id="wikingHead"></div>
    <ul class="textContent">
        <li><a href="/loginForm">Zaloguj</a></li>
        <li><a href="/register">Zarejestruj</a></li>
    </ul>
    <%--<div class="textContent">This is new font</div>--%>
</div>

</body>
</html>
