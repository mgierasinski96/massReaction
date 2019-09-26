<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/registrationAndLogin.css">
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash&display=swap" rel="stylesheet">
    <title>Zarejestruj nową postać!</title>
</head>

<body>
<script>window.jQuery || document.write('<script src="/resources/js/vendor/jquery-3.4.1.min.js"><\/script>')</script>
<script src="/resources/js/plugins.js"></script>
<!-- Add your site or application content here -->
<script src="/resources/js/registrationAndLoginScript.js" async></script>
<script src="/resources/js/vendor/modernizr-3.7.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://www.google-analytics.com/analytics.js" async></script>
<div id="container">
    <div id="backgroundMap">
        <div id="relativeContentOfPage">
<form:form method="post" action="addAppUser.html" modelAttribute="appUser">
    <form:hidden path="userId"/>
            <div id="stats">
                <div id="insideStats">
                    <table>
                        <tr>
                            <td><span class="nicknameInput">Nazwa postaci:</span></td>
                            <td><form:input class="nicknameInput" type="text" size="15" maxlength="15"
                                       placeholder="Wpisz nazwę..." name="nickname" path="login"/></td>
                        </tr>
                        <tr>
                            <td><span class="emailInput">Adres email:</span></td>
                            <td><form:input path="email" class="emailInput" type="text" size="15" maxlength="20" placeholder="Email..."
                                       name="email"/></td>
                        </tr>
                        <tr>
                            <td><span class="passwordInput">Hasło:</span></td>
                            <td><form:input path="password" class="passwordInput" type="password" size="15" placeholder="****" maxlength="20"
                                       name="password"/></td>
                        </tr>

                    </table>
                    <div>
                        <span class="pointsLeft">Pozostałe punkty:</span>
                        <input class="pointsLeft" type="text" value="10" id="points" readonly/>
                    </div>
                    <table id="statsTable" border="1px">
                        <tr>
                            <td class="statInfo">Siła</td>
                            <td><img class="statImage" id="decreaseStrength"
                                     src="../resources/character/minusStats.png"></td>
                            <td><input name="userStrength" class="statsInput" type="text" value="2" id="strength" readonly/></td>
                            <td><img class="statImage" id="increaseStrength" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                        <tr>
                            <td class="statInfo">Mądrość</td>
                            <td><img class="statImage" id="decreaseWisdom" src="../resources/character/minusStats.png">
                            </td>
                            <td><input name="userWisdom" class="statsInput" type="text" value="10" id="wisdom" readonly/></td>
                            <td><img class="statImage" id="increaseWisdom" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                        <tr>
                            <td class="statInfo">Zdrowie</td>
                            <td><img class="statImage" id="decreaseHealth" src="../resources/character/minusStats.png">
                            </td>
                            <td><input name="userHP" class="statsInput" type="text" value="3" id="health" readonly/></td>
                            <td><img class="statImage" id="increaseHealth" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                    </table>
                    <table id="statsCalculation" border="1px">
                        <tr>
                            <td id="strengthInfo" class="statInfo">Blok</td>
                            <td><input name="strengthValueCalc" class="statsInput" type="text" id="strengthStatValue" value="1%"
                                       style="width:100px" readonly/></td>
                        </tr>
                        <tr>
                            <td id="wisdomInfo" class="statInfo">Obrażenia</td>
                            <td><input name="wisdomValueCalc" type="text" class="statsInput" id="wisdomStatValue" value="25"
                                       style="width:100px" readonly/></td>
                        </tr>
                        <tr>
                            <td id="healthInfo" class="statInfo">Zdrowie</td>
                            <td><input name="userTotalHP" type="text" class="statsInput" value="4.5" id="healthStatValue"
                                       style="width:100px" readonly/></td>
                        </tr>


                    </table>
                    <div id="choseCharacter">
                        <div id="imageHolder">
                            <img src="../resources/character/warrior.png" id="warrior" class="next" alt="character">
                            <img src="../resources/character/wizard.png" id="wizard" class="actual" alt="character">
                        </div>
                    </div>
                    <div class="classInput"><img src="/resources/character/leftArrow.png" id="leftArrow"><span
                            id="currentClass">Czarodziej</span><img src="/resources/character/rightArrow.png"
                                                                    id="rightArrow"></div>
                    <div id="divForRegisterButton">
                    <input type="submit" class="btn3d" value="Zarejestruj">
                    </div>


                </div>

            </div><!-- stats -->
</form:form>

            <div id="description">
                <div id="insidePergamin">
                    <div id="shape18">
                        Czarodzieje to ludzie bądź kosmici o dziwnych umiejętnościach.
                        Chodzą w szmatowatych sukienkach koloru czerwonego, rzadziej niebieskiego.
                        Mieszkają zwykle w stodołach. Za młodu dostawali tęgie cięgi od kolegów,
                        przez co byli zmuszeni nauczyć się magii.
                    </div>
                </div>

            </div>
        </div>
    </div>


</div>
</body>
</html>
