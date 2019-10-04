$(document).ready(function () {

    const pointCostList = document.querySelectorAll('.listOfPoints li');


    $("#increaseHealth").click(function() {
        var n = document.getElementById("userHPs").innerText;
        let userGold = parseInt(document.getElementById("userGold").innerText);
        let healthCost = parseInt(document.getElementById("hpCost").innerText);

        if(userGold>=healthCost)
        {
            document.getElementById("userGold").innerText=""+(userGold-healthCost);
            let newValue=(parseInt(n) + 1);
            document.getElementById("userHPs").innerText = "" + newValue;
            document.getElementById("hpCost").innerText=pointCostList[newValue-1].textContent;
            calculateStats();

            const Url="http://localhost:8080/input";
            $.ajax({
                url: Url,
                type: 'POST',
                data: "paramH=" +n,

                success: function(data) {
                    // data to zwrócona odpowiedź serwera
                }});
        }

        return null;

    });




    $("#increaseWisdom").click(function(event) {
        event.stopImmediatePropagation();
        var w = document.getElementById("userWisdom").innerText;
        let userGold = parseInt(document.getElementById("userGold").innerText);
        let wisdomCost = parseInt(document.getElementById("wisdomCost").innerText);
        if(userGold>=wisdomCost) {
            document.getElementById("userGold").innerText=""+(userGold-wisdomCost);
            let newValue=(parseInt(w) + 1);
            document.getElementById("userWisdom").innerText = "" + newValue;
            document.getElementById("wisdomCost").innerText=pointCostList[newValue-1].textContent;
            calculateStats();
            var http = new XMLHttpRequest();
            http.open("POST", "http://localhost:8080/input", true);
            http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            var params = "paramW=" + w;
            http.send(params);
        }
        else
        {
            alert("Brak złota");
        }

    });

    $("#increaseStrength").one('click',function() {

        let userGold = parseInt(document.getElementById("userGold").innerText);
        let strengthCost = parseInt(document.getElementById("strengthCost").innerText);
        if(userGold>=strengthCost) {
            var s = document.getElementById("userStrength").innerText;
            document.getElementById("userGold").innerText=""+(userGold-strengthCost);
            let newValue=(parseInt(s) + 1);
            document.getElementById("userStrength").innerText = "" + newValue;
            document.getElementById("strengthCost").innerText=pointCostList[newValue-1].textContent;
            calculateStats();
            var http = new XMLHttpRequest();
            http.open("POST", "http://localhost:8080/input", true);
            http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            var params = "paramS=" + s;
            http.send(params);
        }
        else
        {
            alert("Brak złota");
        }

    });


    function roundToPlaces(value,places)
    {
        multiplier=Math.pow(10,places);
        return Math.round(value*multiplier)/multiplier;
    }

    function calculateStats()
    {
        if(document.getElementById("userClass").innerText.toLowerCase()=="czarodziej")
        {

            let dodgeCalc=parseFloat(document.getElementById("dodgeCalc").innerText);
            let dmgCalc=parseFloat(document.getElementById("dmgCalc").innerText);
            let hpCalc=parseFloat(document.getElementById("hpCalc").innerText);

            document.getElementById("strengthStatValue").innerText= ""+roundToPlaces( parseFloat(document.getElementById("userStrength").innerText)*dodgeCalc,2);
            document.getElementById("wisdomStatValue").innerText= ""+roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) *dmgCalc,2);
            document.getElementById("healthStatValue").innerText= ""+roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc,2);



        }
        else
        {
            let dodgeCalc=parseFloat(document.getElementById("dodgeCalc").innerText);
            let dmgCalc=parseFloat(document.getElementById("dmgCalc").innerText);
            let hpCalc=parseFloat(document.getElementById("hpCalc").innerText);

            document.getElementById("strengthStatValue").innerText= ""+roundToPlaces( parseFloat(document.getElementById("userStrength").innerText)*dmgCalc,2);
            document.getElementById("wisdomStatValue").innerText= ""+roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) *dodgeCalc,2);
            document.getElementById("healthStatValue").innerText= ""+roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc,2);

        }
    }




    });


