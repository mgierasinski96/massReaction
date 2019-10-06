$(document).ready(function () {

    const pointCostList = document.querySelectorAll('.listOfPoints li');


    $("#increaseHealth").click(function (event) {
        mouseClickSound();

        var n = document.getElementById("userHPs").innerText;
        let userGold = parseInt(document.getElementById("userGold").innerText);
        let healthCost = parseInt(document.getElementById("hpCost").innerText);

        if (userGold >= healthCost) {
            let newUserGold = userGold - healthCost;
            document.getElementById("userGold").innerText = "" + newUserGold;
            let newHealthValue = (parseInt(n) + 1);
            document.getElementById("userHPs").innerText = "" + newHealthValue;
            document.getElementById("hpCost").innerText = pointCostList[newHealthValue - 1].textContent;
            calculateStats();
            $.post("/trainHp", {
                newUserGold: newUserGold,
                newHealthValue: newHealthValue,
            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).complete(function () {
            });
        } else
            alert("Brak złota");

    });


    $("#increaseWisdom").click(function (event) {
        mouseClickSound();
        event.stopImmediatePropagation();
        var w = document.getElementById("userWisdom").innerText;
        let userGold = parseInt(document.getElementById("userGold").innerText);
        let wisdomCost = parseInt(document.getElementById("wisdomCost").innerText);
        if (userGold >= wisdomCost) {
            let newUserGold = userGold - wisdomCost;
            document.getElementById("userGold").innerText = "" + newUserGold;
            let newWisdomValue = (parseInt(w) + 1);
            document.getElementById("userWisdom").innerText = "" + newWisdomValue;
            document.getElementById("wisdomCost").innerText = pointCostList[newWisdomValue - 1].textContent;
            calculateStats();
            $.post("/trainWisdom", {
                newUserGold: newUserGold,
                newWisdomValue: newWisdomValue,

            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).complete(function () {
            });
        } else
            alert("Brak złota");


    });

    $("#increaseStrength").click(function (event) {
        mouseClickSound();
        let userGold = parseInt(document.getElementById("userGold").innerText);
        let strengthCost = parseInt(document.getElementById("strengthCost").innerText);
        if (userGold >= strengthCost) {
            let newUserGold = userGold - strengthCost;
            var s = document.getElementById("userStrength").innerText;
            document.getElementById("userGold").innerText = "" + newUserGold;
            let newStrengthValue = (parseInt(s) + 1);
            document.getElementById("userStrength").innerText = "" + newStrengthValue;
            document.getElementById("strengthCost").innerText = pointCostList[newStrengthValue - 1].textContent;
            calculateStats();
            $.post("/trainStrength", {
                newUserGold: newUserGold,
                newStrengthValue: newStrengthValue,

            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).complete(function () {
            });
        } else
            alert("Brak złota");


    });


    function roundToPlaces(value, places) {
        multiplier = Math.pow(10, places);
        var calc = Math.round(value * multiplier) / multiplier;
        if (calc - parseInt(calc) == 0) {
            return calc + ".0";
        }
        return calc;
    }

    function calculateStats() {
        if (document.getElementById("userClass").innerText.toLowerCase() == "czarodziej") {

            let dodgeCalc = parseFloat(document.getElementById("dodgeCalc").innerText);
            let dmgCalc = parseFloat(document.getElementById("dmgCalc").innerText);
            let hpCalc = parseFloat(document.getElementById("hpCalc").innerText);

            document.getElementById("strengthStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userStrength").innerText) * dodgeCalc, 2);
            document.getElementById("wisdomStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) * dmgCalc, 2);
            document.getElementById("healthStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc, 2);


        } else {
            let dodgeCalc = parseFloat(document.getElementById("dodgeCalc").innerText);
            let dmgCalc = parseFloat(document.getElementById("dmgCalc").innerText);
            let hpCalc = parseFloat(document.getElementById("hpCalc").innerText);

            document.getElementById("strengthStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userStrength").innerText) * dmgCalc, 2);
            document.getElementById("wisdomStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) * dodgeCalc, 2);
            document.getElementById("healthStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc, 2);

        }
    }

    function mouseClickSound() {
        document.getElementById('mouseClick').play();
    }


});


