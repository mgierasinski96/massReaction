<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/backgroundMapLoginRegistr.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/sideMenu.css">
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash&display=swap" rel="stylesheet">

    <style>

        #showTundraMap
        {
            position: absolute;
            background-image: url("/resources/maps/tundraMap.png");
            width: 800px;
            height: 600px;
            border:4px solid darkred;
            left: 50%;
            margin-left: -400px;
            top:2%;
        }

        #volcanoMonsters,#castleMonsters,#stonehengeMonsters,#hauntedHouseMonsters
        {
            position: absolute;
            width: 60px;
            height: 60px;
        }
        #volcanoMonsters:hover,#castleMonsters:hover,#stonehengeMonsters:hover,#hauntedHouseMonsters:hover
        {
            cursor: pointer;
        }
        #volcanoMonsters
        {
            bottom: 9%;
            left:49%
        }
        #castleMonsters
        {
            bottom: 57%;
            left:4%
        }
        #stonehengeMonsters
        {
            top:9%;
            right:24%;
        }
        #hauntedHouseMonsters
        {
            bottom:38%;
            right:17%;
        }

        #attackWindow
        {
            position: absolute;
            width: 380px;
            height: 280px;
            left:50%;
            margin-left: -190px;
            top:50%;
            margin-top:-140px;
            border:2px solid yellow;
            display: none;
        }

        .closeWindowIcon
        {
            position: absolute;
            top:0;
            right: 0;

        }
        .closeWindowIcon:hover
        {
            cursor: pointer;
        }
        #relativeContentOfAttackWindow
        {
            position: relative;
            width: 100%;
        height: 100%;
        }


    </style>
</head>
<body>
<script>window.jQuery || document.write('<script src="/resources/js/vendor/jquery-3.4.1.min.js"><\/script>')</script>
<script src="/resources/js/plugins.js"></script>
<script src="/resources/js/mapScript.js" async></script>
<!-- Add your site or application content here -->
<script src="/resources/js/vendor/modernizr-3.7.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://www.google-analytics.com/analytics.js" async></script>
<div id="container">
    <div id="sideMenu"  style="left:50%;margin-left: -660px"><%--zeby bylo w tym samym miejscu co mapa na innej stronie--%>
        <ul id="sideList">
            <li class="sideMenuLiTitle">Wyprawy</li>
            <li class="sideMenuLi" id="currentMap"><a href="/showMapTundra">Tundra</a></li>
            <li class="sideMenuLi"><a href="/showMapWinterDespair">Zimowa Rozpacz</a></li>
        </ul>
    </div>
    <div id="showTundraMap">
<div id="relativeContentOfMap" style="position: relative;width: 100%;height: 100%">

    <div id="attackWindow" class="attack"><div id="relativeContentOfAttackWindow"><img src="/resources/pageElements/closeWindowIcon.png" class="closeWindowIcon"> </div></div>

    <img id="volcanoMonsters" src="/resources/pageElements/attackMonsterClick.png">
    <img id="castleMonsters" src="/resources/pageElements/attackMonsterClick.png">
    <img id="stonehengeMonsters" src="/resources/pageElements/attackMonsterClick.png">
    <img id="hauntedHouseMonsters" src="/resources/pageElements/attackMonsterClick.png">




</div>

    </div>


</div>
</body>
</html>
