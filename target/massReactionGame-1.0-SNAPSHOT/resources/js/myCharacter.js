$(document).ready(function () {

    const pointCostList = document.querySelectorAll('.listOfPoints li');

    var items = document.getElementsByClassName("item");
    const itemHolders=document.getElementsByClassName("itemHolder");
    const bagSlots=document.getElementsByClassName("bagSlot");

//TODO FIX THAT ONE ITEM CAN BE DROPPED ON ANOTHER IF SLOT IS NOT EMPTY

    for (var i = 0; i < items.length; i++)
    {
        items[i].setAttribute("id", "item" + i);
        items[i].addEventListener('dragstart', dragStartHandler );
        items[i].addEventListener('dragend', dragEnd );
    };


    for(const slot of bagSlots) // przeciaganie do slotow w plecaku
    {
        slot.addEventListener('dragover',dragOver);
        slot.addEventListener('dragEnter',dragEnter);
        slot.addEventListener('dragLeave',dragLeave);
        slot.addEventListener('drop',dragDropBag);

    }
    for(const holder of itemHolders) //przeciagnaie na postac
    {
        holder.addEventListener('dragover',dragOver);
        holder.addEventListener('dragEnter',dragEnter);
        holder.addEventListener('dragLeave',dragLeave);
        holder.addEventListener('drop',dragDrop);

    }

    function dragStartHandler(e)
    {
        e.dataTransfer.setData("text/plain", this.id);
        setTimeout(()=> this.className="invisible",0);
    };


    function dragEnd(e)

    {
        this.className="item";
    };


    function dragOver(e)
    {
e.preventDefault();
    }
    function dragEnter(e)
    {
        e.preventDefault();

    }
    function dragLeave(e)
    {
        e.preventDefault();
    }
    function dragDrop(e)
    {
        e.preventDefault();
        var data = e.dataTransfer.getData("text");
        this.append(document.getElementById(data));
        $(this).children(':last').css({//150x200
                "position":"absolute",
                "left":"75px",
                "top":"100px",
                 "margin-left":"-47.5px",
            "margin-top":"-47.5px",
            }
        );
        e.dataTransfer.clearData();
    }


    function dragDropBag(e) {
        e.preventDefault();
        var data = e.dataTransfer.getData("text");


        if($(this).children().length==0)
        {
        this.append(document.getElementById(data));
        $(this).children(':last').css({
                "position": "absolute",
                "left": "0px",
                "top": "0px",
                "margin-left": "0px",
                "margin-top": "0px",
            }
        );
        }
        e.dataTransfer.clearData();
    }







    $(".item").hover(
        function (evt) {

        $(this).css({
            "background":"darkgray",
            "cursor":"move"
            }
        );

            $(this).children("div").show(30);

    },function (evt) {
            $(this).css(
                {
                    "background": "#d6d6d6",
                    "cursor": "default"
                })

            $(this).children("div").hide(30);
        }
    );




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

    function mouseClickSound() {
        document.getElementById('mouseClick').play();
    }




});


