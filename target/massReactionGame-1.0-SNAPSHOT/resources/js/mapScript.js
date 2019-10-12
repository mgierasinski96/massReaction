$(document).ready(function () {

    function currentMap() {
        let element=document.getElementById("currentMap");
        element.style.background="green";
    }
    currentMap();


    $("#snowmanMonsters").click(
        function (evt) {
            let attackWindow=document.getElementById("attackWindow");
            // attackWindow.innerText="to jest info o balwanie";
            $(attackWindow).show(250);

        });

    $("#castleMonsters").click(
        function (evt) {

        });

    $("#stonehengeMonsters").click(
        function (evt) {

        });
    $("#iceCastleMonsters").click(
        function (evt) {

        });
    $("#iceZombieMonsters").click(
        function (evt) {

        });
    $("#yetiMonsters").click(
        function (evt) {

        });
    $("#hauntedHouseMonsters").click(
        function (evt) {


        });


    $("#volcanoMonsters").click(
        function (evt) {

        })  ;


    $(".closeWindowIcon").click(function (evt) {

        $(this).closest(".attack").hide(200);

    });

});