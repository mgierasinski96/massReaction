<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/registrationAndLogin.css">
    <link href="https://fonts.googleapis.com/css?family=Berkshire+Swash&display=swap" rel="stylesheet">
    <title>Zaloguj się</title>

    <style>
        #backgroundOfLoginForm
        {
            height: 500px;
            width: 800px;
            position: absolute;
            background-image: url("/resources/backgrounds/loginBackground.png");
            left:50%;
            margin-left: -400px;
        }

        #relativeContentOfLoginForm
        {
            width: 100%;
            height: 100%;
            position: relative;

        }

        #contentOfLoginForm
        {   width: 60%;
            left:15%;
            position: absolute;
            bottom:0%;
            height: 45%;



        }

        .loginInput
        {
            font-family: 'Berkshire Swash', cursive;
            color: darkred;
            font-size: 27px;
            height: 30px;
            width:178px;

        }
        .loginInfo
        {
            height: 30px;
            color:darkred;
            font-family: 'Berkshire Swash', cursive;
            font-size: 27px;
            font-weight: bold;
            padding-top: 13px;
            padding-bottom: 13px;
        }



        .forButton
        {
            padding-left: 68px;
            height: 85px;

        }





    </style>




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
            <div id="backgroundOfLoginForm">
                <div id="relativeContentOfLoginForm">
                    <div id="contentOfLoginForm">
        <table id="loginTable" >
            <tr class="trPaddingBottom">
                <td class="loginInfo">Nazwa postaci:</td>
                <td><input type="text" class="loginInput"></td>
            </tr>
            <tr class="trPaddingBottom">
                <td class="loginInfo">Hasło:</td>
                <td><input type="password" class="loginInput"></td>
            </tr>
                <tr class="trPaddingBottom">
                    <td class="forButton" colspan="2"><input type="submit" class="btn3d" value="Zaloguj"></td>
                </tr>

        </table>
                    </div>

            </div>
            </div>




        </div>
    </div>
</div>


</body>
</html>
