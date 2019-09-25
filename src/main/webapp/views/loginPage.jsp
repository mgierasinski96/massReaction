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

.btnLogin {
    text-decoration:none;
    font-family: 'Berkshire Swash', cursive;
    box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 3px 2px;
    o-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 3px 2px;
    -moz-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 3px 2px;
    -webkit-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 3px 2px;
    background:#baff30;
    background:-o-linear-gradient(90deg, #baff30, #ebda3d);
    background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #baff30), color-stop(1, #ebda3d) );
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#baff30', endColorstr='#ebda3d');
    background:-webkit-linear-gradient(#baff30, #ebda3d);
    background:-ms-linear-gradient(#baff30, #ebda3d);
    background:linear-gradient(#baff30, #ebda3d);
    text-indent:0px;
    line-height:45px;
    -moz-border-radius:0 25px 0 25px;
    -webkit-border-radius:0 25px 0 25px;
    border-radius:0 25px 0 25px;
    text-align:center;
    vertical-align:middle;
    display:inline-block;
    font-size:30px;
    color:darkred;
    width:250px;
    height:50px;
    padding:4px;
    text-shadow:#6daac2 2px 2px 0px;
    border-color:#659dab;
    border-width:2px;
    border-style:solid;
}

        .btnLogin:active {
            box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 0 2px;
            o-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 0 2px;
            -moz-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 0 2px;
            -webkit-box-shadow:inset #ffffff 0px 5px 8px -1px,#d6d6d6 1px 0 2px;
            position:relative;
            top:3px
        }

        .btnLogin:hover {
            background:#ebda3d;
            background:-o-linear-gradient(90deg, #ebda3d, #baff30);
            background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ebda3d), color-stop(1, #baff30) );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ebda3d', endColorstr='#baff30');
            background:-webkit-linear-gradient(#ebda3d, #baff30);
            background:-ms-linear-gradient(#ebda3d, #baff30);
            background:linear-gradient(#ebda3d, #baff30);
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
                    <td class="forButton" colspan="2"><input type="submit" class="btnLogin" value="Zaloguj"></td>
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
