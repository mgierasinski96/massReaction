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
    #container{
        position: relative;
    }

    #registerForm
    {
        position: absolute;
        margin-top: 10px;
        height: 730px;
        width: 1320px;
        background-image: url("/resources/backgrounds/registerCharacterBackground.jpg");
        left: 50%;
        margin-left: -660px;

    }
    #contentOfRegisterForm{
        position: relative;
        width: 100%;
        height: 100%;
    }

    #stats
    {
        position: absolute;
        top: 20%;
        left:30%;
    }
    input[type="text"], textarea {

        background-color : yellow;

    }
    .statsInput
    {

        color: darkred;
        text-align: center;
        font-weight: bold;
        width: 60px;
        height:40px;
        font-size: 35px;
        border:1px solid darkred;
    }
    .nicknameInput,.emailInput
    {
        font-family: 'Berkshire Swash', cursive;
        font-weight: bold;
        color: darkred;
        height:40px;
        font-size: 35px;
    }


    .statImage
    {
        border: 1px solid darkred;
    }

    .statInfo
    {
        font-family: 'Berkshire Swash', cursive;
        font-size: 25px;
        color:darkred;
    }
    .pointsLeft
    {
        font-family: 'Berkshire Swash', cursive;
        font-size: 35px;
        width:50px;
        color:darkred;
        text-align: center;
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
            <table>
                <tr>
           <td> <span class="nicknameInput">Nazwa postaci:</span></td>
            <td><input class="nicknameInput" type="text"  size="15" maxlength="15" placeholder="Wpisz nazwę..." name="nickname"></td>
                </tr>
                <tr>
                    <td>  <span class="emailInput">Adres email:</span></td>
                    <td> <input class="emailInput" type="text"  size="15" maxlength="20" placeholder="Email..." name="email"></td>
                </tr>
            </table>
            <div>
            <span class="pointsLeft">Pozostałe punkty:</span>
            <input class ="pointsLeft" type="text" value="10" id="points" readonly/>
            </div>
            <table id="statsTable" border="1px">
                <tr>
                    <td class="statInfo">Siła</td>
           <td> <img class="statImage" id="decreaseStrength" src="../resources/character/minusStats.png"></td>
                    <td><input class ="statsInput" type="text" value="5" id="strength" readonly/> </td>
                    <td> <img class="statImage" id="increaseStrength" src="../resources/character/plusStats.png"></td>
                </tr>
                <tr>
                    <td class="statInfo">Mądrość</td>
                    <td> <img class="statImage" id="decreaseWisdom" src="../resources/character/minusStats.png"></td>
                    <td><input class ="statsInput" type="text" value="5" id="wisdom" readonly/> </td>
                    <td> <img class="statImage" id="increaseWisdom" src="../resources/character/plusStats.png"></td>
                </tr>
                <tr>
                    <td class="statInfo">Zdrowie</td>
                    <td> <img class="statImage" id="decreaseHealth" src="../resources/character/minusStats.png"></td>
                    <td><input class ="statsInput" type="text" value="5" id="health" readonly/> </td>
                    <td> <img class="statImage" id="increaseHealth" src="../resources/character/plusStats.png"></td>
                </tr>
            </table>
        </div>
        </div>
    </div>


</div>
</body>
</html>
