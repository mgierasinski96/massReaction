$(document).ready(function () {
    var decreaseStrength = document.getElementById("decreaseStrength");
    var increaseStrength = document.getElementById("increaseStrength");


    function decreaseValue(element)
    {
        let value=element.value;
        let points=document.getElementById("points");
        let pointsValue=points.value;
        if(value>0)
        {
            points.value = "" + (parseInt(pointsValue) + 1);
            element.value=value-1;
        }
    }

    function increaseValue(element)
    {
        let points=document.getElementById("points");
        let pointsValue=points.value;
        let value=element.value;
        if(pointsValue>0) {
            element.value = "" + (parseInt(value) + 1);
            points.value =pointsValue - 1;
        }

    }

    $("#decreaseStrength").click(function()
    {
        let strength=document.getElementById("strength");
        decreaseValue(strength);

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
        decreaseValue(wisdom);

    });

    $("#decreaseHealth").click(function()
    {
        let health=document.getElementById("health");
        decreaseValue(health);
    });

    $("#increaseHealth").click(function()
    {
        let health=document.getElementById("health");
        increaseValue(health);
    });
});
