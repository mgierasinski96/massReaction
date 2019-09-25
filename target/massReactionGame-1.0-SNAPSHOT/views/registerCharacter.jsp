<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 23.09.2019
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div id="stats">
                <div id="insideStats">
                    <table>
                        <tr>
                            <td><span class="nicknameInput">Nazwa postaci:</span></td>
                            <td><input class="nicknameInput" type="text" size="15" maxlength="15"
                                       placeholder="Wpisz nazwę..." name="nickname"></td>
                        </tr>
                        <tr>
                            <td><span class="emailInput">Adres email:</span></td>
                            <td><input class="emailInput" type="text" size="15" maxlength="20" placeholder="Email..."
                                       name="email"></td>
                        </tr>
                        <tr>
                            <td><span class="passwordInput">Hasło:</span></td>
                            <td><input class="passwordInput" type="password" size="15" placeholder="****" maxlength="20"
                                       name="password"></td>
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
                            <td><input class="statsInput" type="text" value="2" id="strength" readonly/></td>
                            <td><img class="statImage" id="increaseStrength" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                        <tr>
                            <td class="statInfo">Mądrość</td>
                            <td><img class="statImage" id="decreaseWisdom" src="../resources/character/minusStats.png">
                            </td>
                            <td><input class="statsInput" type="text" value="10" id="wisdom" readonly/></td>
                            <td><img class="statImage" id="increaseWisdom" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                        <tr>
                            <td class="statInfo">Zdrowie</td>
                            <td><img class="statImage" id="decreaseHealth" src="../resources/character/minusStats.png">
                            </td>
                            <td><input class="statsInput" type="text" value="3" id="health" readonly/></td>
                            <td><img class="statImage" id="increaseHealth" src="../resources/character/plusStats.png">
                            </td>
                        </tr>
                    </table>
                    <table id="statsCalculation" border="1px">
                        <tr>
                            <td id="strengthInfo" class="statInfo">Blok</td>
                            <td><input class="statsInput" type="text" id="strengthStatValue" value="1%"
                                       style="width:100px" readonly/></td>
                        </tr>
                        <tr>
                            <td id="wisdomInfo" class="statInfo">Obrażenia</td>
                            <td><input type="text" class="statsInput" id="wisdomStatValue" value="25"
                                       style="width:100px" readonly/></td>
                        </tr>
                        <tr>
                            <td id="healthInfo" class="statInfo">Zdrowie</td>
                            <td><input type="text" class="statsInput" value="4.5" id="healthStatValue"
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
                    <input type="submit" class="butn" value="Zarejestruj">


                </div>

            </div><!-- stats -->

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
