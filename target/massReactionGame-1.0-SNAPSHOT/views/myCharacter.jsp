<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/backgroundMapLoginRegistr.css">
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash&display=swap" rel="stylesheet">

    <title>MyCharacter</title>

    <style>

        #userName {
            font-size: 25px;
            font-family: 'Berkshire Swash', cursive;
            text-align: center;
            color: darkred;
        }

        #itemHolderTable {
            position: absolute;
            right: 0%;
            top: 8%;
        }

        #photoAndName {
            position: absolute;
            left: 18%;
            top: 2%;
        }

        #professionImage {
            border: 3px solid darkred;
            background: rgb(216, 218, 227);
            background: radial-gradient(circle, rgba(216, 218, 227, 0.927608543417367) 51%, rgba(198, 154, 107, 0) 93%);
        }

        #userName {
            background: yellow;
            border: 3px solid darkred;

        }

        #statsTable {
            position: absolute;
            left: 18%;
            top: 55%;
        }

        .statValue
        {
            color: darkred;
            text-align: center;
            font-weight: bold;
            width: 90px;
            height: 50px;
            font-size: 35px;
            border: 1px solid darkred;
            background: yellow;
        }

        #statsCalculation
        {
            position: absolute;
            top: 55%;
            left: 45%;
        }

        #wisdomCost,#strengthCost,#hpCost
        {
            font-size: 35px;
            font-family: 'Berkshire Swash', cursive;
            color:darkred;
            vertical-align: top;
        }
        #bagpack
        {
            position: absolute;
            top:2%;
            left:40%;
            background-image: url(/resources/backgrounds/bagBackground.png);
            border:6px solid darkred;
        }

        .bagSlot
        {
            border:2px solid goldenrod;
            width:100px;
            height: 100px;
        }

    </style>
</head>
<body>

<script>window.jQuery || document.write('<script src="/resources/js/vendor/jquery-3.4.1.min.js"><\/script>')</script>
<script src="/resources/js/plugins.js"></script>
<!-- Add your site or application content here -->
<script src="/resources/js/myCharacter.js" async></script>
<script src="/resources/js/vendor/modernizr-3.7.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://www.google-analytics.com/analytics.js" async></script>
<div id="container">
    <div id="backgroundMap">
        <div id="relativeContentOfPage">
            <div id="hiddenDivForJs" style="display: none">
                <audio id="mouseClick" src="../resources/audio/mouseClick.mp3" preload="auto"></audio>
<span id="userClass">${appUser.userProfession.professionName}</span>
                <span id="dodgeCalc">${appUser.userProfession.dodgeCalculation}</span>
                <span id="dmgCalc">${appUser.userProfession.dmgCalculation}</span>
                <span id="hpCalc">${appUser.userProfession.hpCalculation}</span>
                <ol class="listOfPoints">${listOfPointForJs}
<c:forEach items="${listOfPointForJs}" var="point">
                <li>${point.pointCost}</li>
</c:forEach>
                </ol>

            </div>
            <table id="itemHolderTable" cellpadding="5px">
                <tr>

                    <td colspan="2" style="position: relative"><img src="/resources/itemHolders/helmetHolder.png"
                                                                    draggable="false"
                                                                    style="position:absolute;right:0px;;top:0px;"></td>
                    <td><img src="/resources/itemHolders/necklaceHolder.png" draggable="false"></td>
                </tr>
                <tr>
                    <td><img src="/resources/itemHolders/weaponHolder.png" draggable="false"></td>
                    <td><img src="/resources/itemHolders/plateHolder.png" draggable="false"></td>
                    <td><img src="/resources/itemHolders/shieldHolder.png" draggable="false"></td>
                </tr>
                <tr>
                    <td><img src="/resources/itemHolders/gauntletHolder.png" draggable="false"></td>
                    <td><img src="/resources/itemHolders/bootsHolder.png" draggable="false"></td>
                    <td><img src="/resources/itemHolders/ringHolder.png" draggable="false"></td>
                </tr>

            </table>

            <table id="bagpack" border="1">
                <tr>
                    <td class="bagSlot">slot1</td>
                    <td class="bagSlot">slot2</td>
                    <td class="bagSlot">slot3</td>
                    <td class="bagSlot">slot3</td>
                </tr>
                <tr>
                    <td class="bagSlot">slot1</td>
                    <td class="bagSlot">slot2</td>
                    <td class="bagSlot">slot3</td>
                    <td class="bagSlot">slot3</td>
                </tr>


            </table>
            <table id="photoAndName">
                <tr>
                    <td id="professionImage"><img
                            src="getProfessionImage/<c:out value='${appUser.userProfession.professionId}'/>"></td>
                </tr>
                <tr>
                    <td id="userName">${appUser.login}
                    </td>
                </tr>
            </table>

            <table id="statsTable">
                <tr>
                    <td class="statInfo">Siła</td>
                    <td class="statValue" id="userStrength">${appUser.userStrength}</td>
                    <td><img class="statImage" id="increaseStrength" src="../resources/character/plusStats.png">
                    </td>
                    <td><img src="/resources/pageElements/goldIcon40x40.png"><span id="strengthCost">${strengthCost}</span></td>
                </tr>
                <tr>
                    <td class="statInfo">Mądrość</td>
                    <td class="statValue" id="userWisdom">${appUser.userWisdom}</td>
                    <td><img class="statImage" id="increaseWisdom" src="../resources/character/plusStats.png">
                    </td>
                    <td><img src="/resources/pageElements/goldIcon40x40.png"><span id="wisdomCost">${wisdomCost}</span></td>
                </tr>
                <tr>
                    <td class="statInfo">Zdrowie</td>
                    <td class="statValue" id="userHPs">${appUser.userHP}</td>
                    <td><form><img class="statImage" id="increaseHealth" src="../resources/character/plusStats.png">

                    </form>
                    </td>
                    <td><img src="/resources/pageElements/goldIcon40x40.png"><span id="hpCost">${hpCost}</span></td>
                </tr>
            </table>

            <table id="statsCalculation" border="1px">
                <tr>
                    <td class="statInfo"><c:if test="${appUser.userProfession.professionName=='Czarodziej'}">Unik</c:if>
                        <c:if test="${appUser.userProfession.professionName=='Wojownik'}">Obrażenia</c:if>
                    </td>

                    <td class="statValue">
                    <c:if test="${appUser.userProfession.professionName=='Czarodziej'}">
                        <span id="strengthStatValue">${appUser.userTotalDodge}</span>%</c:if>
                    <c:if test="${appUser.userProfession.professionName=='Wojownik'}">
                            <span id="strengthStatValue">${appUser.userTotalDmg}</span></c:if>
                </td>

                </tr>
                <tr>
                    <td class="statInfo"><c:if test="${appUser.userProfession.professionName=='Czarodziej'}">Obrażenia</c:if>
                        <c:if test="${appUser.userProfession.professionName=='Wojownik'}">Odporność</c:if>
                    </td>

                    <td class="statValue" >
                        <c:if test="${appUser.userProfession.professionName=='Czarodziej'}"><span id="wisdomStatValue">${appUser.userTotalDmg}</span></c:if>
                        <c:if test="${appUser.userProfession.professionName=='Wojownik'}"><span id="wisdomStatValue">${appUser.userTotalDodge}</span>%</c:if>
                    </td>
                </tr>
                <tr>
                    <td id="healthInfo" class="statInfo">Życie</td>
                    <td class="statValue" id="healthStatValue">
                        ${appUser.userTotalHP}
                    </td>
                </tr>


            </table>

        </div>
    </div>
</div>


</body>
</html>
