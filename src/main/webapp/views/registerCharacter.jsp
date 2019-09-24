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
    <title>Title</title>
</head>
<style>
    #container {
        position: relative;
        border: 3px solid black;
    }

    #registerForm {
        border: 3px solid white;
        position: absolute;
        margin-top: 10px;
        height: 730px;
        width: 1320px;
        background-image: url("/resources/backgrounds/registerCharacterBackground.jpg");
        left: 50%;
        margin-left: -660px;

    }

    #contentOfRegisterForm {
        position: relative;
        width: 100%;
        height: 100%;
    }

    #stats {
        width: 42%;
        height: 62%;
        position: absolute;
        top: 15%;
        left: 8%;
    }

    #insideStats {
        position: relative;
        width: 100%;
        height: 100%;
    }

    #choseCharacter {
        position: absolute;
        top: 0%;
        left: 100%;
        width: 256px;
        height: 306px;
        border: 3px solid darkred;
        background: rgb(216, 218, 227);
        background: radial-gradient(circle, rgba(216, 218, 227, 0.927608543417367) 51%, rgba(198, 154, 107, 0) 93%);
    }

    input[type="text"], input[type="password"], textarea {

        background-color: yellow;

    }

    .statsInput {

        color: darkred;
        text-align: center;
        font-weight: bold;
        width: 60px;
        height: 40px;
        font-size: 35px;
        border: 1px solid darkred;
    }

    .nicknameInput, .emailInput, .passwordInput, .classInput {
        font-family: 'Berkshire Swash', cursive;
        font-weight: bold;
        color: darkred;
        height: 40px;
        font-size: 35px;
    }


    .statImage {
        border: 1px solid darkred;
    }

    .statInfo {
        font-family: 'Berkshire Swash', cursive;
        font-size: 25px;
        color: darkred;
    }

    .pointsLeft {
        font-family: 'Berkshire Swash', cursive;
        font-size: 35px;
        width: 50px;
        color: darkred;
        text-align: center;
    }

    .butn {
        position: absolute;
        bottom:0%;
        -webkit-border-radius: 28px;
        -moz-border-radius: 28px;
        border-radius: 28px;
        font-family: 'Berkshire Swash', cursive;
        color: darkred;
        font-size: 35px;
        background: yellow;
        padding: 10px 20px 10px 20px;
        border: solid darkred 4px;
        text-decoration: none;
    }

    .classInput {
        position: absolute;
        top: 325px;
        left: 100%;
        width: 256px;
        text-align: center;
    }

    .butn:hover {
        background: #fca63c;
        text-decoration: none;
        cursor: pointer;
    }

    #description {

        position: absolute;
        top: 15%;
        right: 3%;
        height: 365px;
        width: 350px;
        background-image: url("/resources/character/pergamin.png");
    }

    #insidePergamin {
        width: 100%;
        height: 100%;
        position: relative;
    }

    #shape18 {
        display: inline-block !important;
        width: 210px;
        height: 250px;
        transform: skew(-24deg);
        position: absolute;
        left: 17%;
        top: 19%;
        font-size: 16px;
        font-family: 'Berkshire Swash', cursive;
        color: darkred;
        text-align: left;

    }

    #rightArrow:hover, #leftArrow:hover {
        cursor: pointer;
        opacity: 0.6;
    }

    #increaseStrength:hover, #increaseWisdom:hover, #increaseHealth:hover, #decreaseStrength:hover, #decreaseWisdom:hover, #decreaseHealth:hover {
        cursor: pointer;
        transition: 0.4s;
        opacity: 0.5;
    }

    #imageHolder {
        width: 100%;
        height: 100%;
        position: relative;
    }

    .actual {
        position: absolute;
        width: 100%;
        height: 100%;
        transition: 1.2s;
        opacity: 1;
    }

    .next {
        width: 100%;
        height: 100%;
        position: absolute;
        transition: 1.2s;
        opacity: 0;
    }

    #statsTable
    {
        position: absolute;
        top:50%;
    }
    #statsCalculation
    {
        position: absolute;
        top:50%;
        left:50%;

    }



</style>
<body>
<script>window.jQuery || document.write('<script src="/resources/js/vendor/jquery-3.4.1.min.js"><\/script>')</script>
<script src="/resources/js/plugins.js"></script>
<!-- Add your site or application content here -->
<script src="/resources/js/registrationScript.js" async></script>
<script src="/resources/js/vendor/modernizr-3.7.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://www.google-analytics.com/analytics.js" async></script>
<div id="container">
    <div id="registerForm">
        <div id="contentOfRegisterForm">

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
                            <td><input class="statsInput" type="text" id="strengthStatValue" value="1%" style="width:100px" readonly /></td>
                        </tr>
                        <tr>
                            <td id="wisdomInfo" class="statInfo">Obrażenia</td>
                            <td><input type="text" class="statsInput" id="wisdomStatValue" value="25" style="width:100px" readonly/></td>
                        </tr>
                        <tr>
                            <td id="healthInfo" class="statInfo">Zdrowie</td>
                            <td><input type="text" class="statsInput" value="4.5" id="healthStatValue" style="width:100px" readonly/></td>
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
