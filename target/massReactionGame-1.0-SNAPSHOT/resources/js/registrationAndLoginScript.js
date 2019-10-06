$(document).ready(function () {

    function roundToPlaces(value,places)
    {
        multiplier=Math.pow(10,places);
        return Math.round(value*multiplier)/multiplier;
    }

    function decreaseValue(element)
    {
        let value=element.value;
        let points=document.getElementById("points");
        let pointsValue=points.value;
        if(value>0) {
            points.value = "" + (parseInt(pointsValue) + 1);
            element.value = value - 1;
            calculateStats();
        }

    }

    function increaseValue(element)
    {
        let points=document.getElementById("points");
        let pointsValue=points.value;
        let value=element.value;
        if(pointsValue>0) {
            element.value = "" + (parseInt(value) + 1);
            points.value = pointsValue - 1;
            calculateStats();
        }


    }

    function calculateStats()
    {
        if(document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej")
        {
            document.getElementById("strengthInfo").innerText="Blok";
            document.getElementById("wisdomInfo").innerText="Obrażenia";
            document.getElementById("strengthStatValue").value= ""+roundToPlaces( document.getElementById("strength").value/2,2)+"%";
            document.getElementById("wisdomStatValue").value= ""+roundToPlaces(document.getElementById("wisdom").value *2.5,2);
            document.getElementById("healthStatValue").value= ""+roundToPlaces(document.getElementById("health").value * 1.5,2);



        }
        else
        {
            document.getElementById("strengthInfo").innerText="Obrażenia";
            document.getElementById("wisdomInfo").innerText="Odporność";
            document.getElementById("strengthStatValue").value= ""+roundToPlaces(document.getElementById("strength").value * 1.7,2);
            document.getElementById("wisdomStatValue").value= ""+roundToPlaces(document.getElementById("wisdom").value*0.5,2)+"%";
            document.getElementById("healthStatValue").value= ""+roundToPlaces(document.getElementById("health").value * 2.3,2);


        }
    }

    $("#decreaseStrength").click(function()
    {
        let strength=document.getElementById("strength");
        if((document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej"&&strength.value>2)||(document.getElementById("currentClass").innerText.toLowerCase()=="wojownik"&&strength.value>8)) {
            decreaseValue(strength);
        }

    });

    $("#increaseStrength").click(function()
    {
        let strength=document.getElementById("strength");
        increaseValue(strength);

    });

    $("#increaseWisdom").click(function()
    {
        let wisdom=document.getElementById("wisdom");
        increaseValue(wisdom);

    });
    $("#decreaseWisdom").click(function()
    {

        let wisdom=document.getElementById("wisdom");
        if((document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej"&&wisdom.value>10)||(document.getElementById("currentClass").innerText.toLowerCase()=="wojownik"&&wisdom.value>2))
        decreaseValue(wisdom);

    });

    $("#decreaseHealth").click(function()
    {
        let health=document.getElementById("health");
        if((document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej"&&health.value>3)||(document.getElementById("currentClass").innerText.toLowerCase()=="wojownik"&&health.value>5))
        decreaseValue(health);
    });

    $("#increaseHealth").click(function()
    {
        let health=document.getElementById("health");
        increaseValue(health);
    });

    $("#rightArrow").click(function()
    {

        if(document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej")
        {   document.getElementById("wizard").className="next";
            document.getElementById("warrior").className="actual";
            document.getElementById("points").value=10;
            document.getElementById("strength").value=8;
            document.getElementById("wisdom").value=2;
            document.getElementById("health").value=5;
            document.getElementById("currentClass").innerText="Wojownik";
            document.getElementById("shape18").innerText="Wojownik to miłośnik powieści fantasy, a w szczególności książek i opowiadań o Conanie Barbarzyńcy. Wzorem swego idola wyzbył się nadmiaru inteligencji i szkolił się w używaniu broni ciężkich. Idealna klasa dla dresiarzy."
            calculateStats();
        }
        else
        {
               document.getElementById("warrior").className="next";
                document.getElementById("wizard").className="actual";
            document.getElementById("points").value=10;
            document.getElementById("strength").value=2;
            document.getElementById("wisdom").value=10;
            document.getElementById("health").value=3;
            document.getElementById("currentClass").innerText="Czarodziej";
            document.getElementById("shape18").innerText="Czarodzieje to ludzie bądź kosmici o dziwnych umiejętnościach. Chodzą w szmatowatych sukienkach koloru czerwonego, rzadziej niebieskiego. Mieszkają zwykle w stodołach. Za młodu dostawali tęgie cięgi od kolegów, przez co byli zmuszeni nauczyć się magii."
            calculateStats();
        }



    });

    $("#leftArrow").click(function()
    {

        if(document.getElementById("currentClass").innerText.toLowerCase()=="czarodziej")
        {
            document.getElementById("wizard").className="next";
            document.getElementById("warrior").className="actual";
            document.getElementById("points").value=10;
            document.getElementById("strength").value=8;
            document.getElementById("wisdom").value=2;
            document.getElementById("health").value=5;
            document.getElementById("currentClass").innerText="Wojownik";
            document.getElementById("shape18").innerText="Wojownik to miłośnik powieści fantasy, a w szczególności książek i opowiadań o Conanie Barbarzyńcy. Wzorem swego idola wyzbył się nadmiaru inteligencji i szkolił się w używaniu broni ciężkich. Idealna klasa dla dresiarzy."
            calculateStats();

        }
        else
        {   document.getElementById("warrior").className="next";
            document.getElementById("wizard").className="actual";
            document.getElementById("points").value=10;
            document.getElementById("strength").value=2;
            document.getElementById("wisdom").value=10;
            document.getElementById("health").value=3;
            document.getElementById("currentClass").innerText="Czarodziej";
            document.getElementById("shape18").innerText="Czarodzieje to ludzie bądź kosmici o dziwnych umiejętnościach. Chodzą w szmatowatych sukienkach koloru czerwonego, rzadziej niebieskiego. Mieszkają zwykle w stodołach. Za młodu dostawali tęgie cięgi od kolegów, przez co byli zmuszeni nauczyć się magii."
            calculateStats();
        }




    });

});
