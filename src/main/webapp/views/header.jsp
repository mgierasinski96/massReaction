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
            margin-left: 35%;
            width: 500px;
            height: 120px;
            background-image: url(/resources/backgrounds/logo.png);
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

    </style>
</head>
<body>
<div id="container">
    <div id="logo"></div>
    <div id="wikingHead"></div>
</div>

</body>
</html>
