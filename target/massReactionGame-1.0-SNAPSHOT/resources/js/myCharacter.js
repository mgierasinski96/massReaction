$(document).ready(function () {

    var pointCostList = document.querySelectorAll('.listOfPoints li');

    var totalStrengthFromItems=0;
    var totalWisdomFromItems=0;
    var totalHPfromItems=0;

    var totalDmgFromItems = 0;
    var totalDodgeFromItems = 0;
    var totalHealthFromItems = 0;

   calculateStatsWithEquippedItems();

   // alert("po odswiezeniu strony punktow "+totalHPfromItems);
   // alert("po odswiezeniu strony zycia "+totalHealthFromItems)

    var items = document.getElementsByClassName("item");
    var itemHolders = document.getElementsByClassName("itemHolder");
    var bagSlots = document.getElementsByClassName("bagSlot");
    var allItemsClasses = document.getElementsByClassName("itemClass");
    var allItemsTables = document.getElementsByClassName("itemInfo");
    var allItemDBid=document.getElementsByClassName("itemDBId");

//TODO

    //i dodawac lub odejmowac//wobec tego byc moze zajdzie potrzeba wywolania calculateStats juz na poczatku
    //zakladajac item nie moge updatowac wartosci sily madrosci i hp w bazie danych
    //a wartosc podstawa to wartosc z bazy danych a od itemow to calkowita - ta z bazy
    //czyli jedyny update jaki jest potrzebny do ten dmg,health,dodge, bo tylko one tutaj maja znaczenie


    for (var i = 0; i < items.length; i++) {
        allItemDBid[i].setAttribute("id","databaseId"+i);
        allItemsTables[i].setAttribute("id", "table" + i);
        allItemsClasses[i].setAttribute("id", "itemClass" + i);
        items[i].setAttribute("id", "item" + i);
        items[i].addEventListener('dragstart', dragStartHandler);
        items[i].addEventListener('dragend', dragEnd);
    };


    for (const slot of bagSlots) // przeciaganie do slotow w plecaku
    {
        slot.addEventListener('dragover', dragOver);
        slot.addEventListener('dragEnter', dragEnter);
        slot.addEventListener('dragLeave', dragLeave);
        slot.addEventListener('drop', dragDropBag);

    }
    for (const holder of itemHolders) //przeciagnaie na postac
    {
        holder.addEventListener('dragover', dragOver);
        holder.addEventListener('dragEnter', dragEnter);
        holder.addEventListener('dragLeave', dragLeave);
        holder.addEventListener('drop', dragDrop);
    }

    function dragStartHandler(e) {
        e.dataTransfer.setData("text/plain", this.id);
        setTimeout(() => this.className = "invisible", 0);
    };


    function dragEnd(e) {
        this.className = "item";
    };


    function dragOver(e) {
        e.preventDefault();
    }

    function dragEnter(e) {
        e.preventDefault();

    }

    function dragLeave(e) {
        e.preventDefault();
    }

    function dragDrop(e) {
        e.preventDefault();
        var data = e.dataTransfer.getData("text");
        let itemNumber = data.substring(4, 5);


        let element = document.getElementById(data);
        let itemClass = document.getElementById("itemClass" + itemNumber).innerText

        if ((itemClass + "Holder") == this.id) {

            this.append(element);
            $(this).children(':last').css({//150x200
                    "position": "absolute",
                    "left": "75px",
                    "top": "100px",
                    "margin-left": "-47.5px",
                    "margin-top": "-47.5px",
                }
            );


            let tBody = document.getElementById("table" + itemNumber).children;
            let tableRows = tBody[0].children;//not first two rows

            let itemDmg = 0;
            let itemHealth = 0;
            let itemDodge = 0;
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            for (let i = 2; i < tableRows.length; i++) {
                if ($(tableRows[i]).find("td:eq(0)").text() == "Obrażenia") {
                    itemDmg = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                } else if ($(tableRows[i]).find("td:eq(0)").text() == "Życie") {
                    itemHealth = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                } else if ($(tableRows[i]).find("td:eq(0)").text() == "Unik") {
                    itemDodge = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                } else if ($(tableRows[i]).find("td:eq(0)").text() == "Siła") {
                    itemStrength = parseInt($(tableRows[i]).find("td:eq(1)").text());
                } else if ($(tableRows[i]).find("td:eq(0)").text() == "Mądrość") {
                    itemWisdom = parseInt($(tableRows[i]).find("td:eq(1)").text());
                } else if ($(tableRows[i]).find("td:eq(0)").text() == "Zdrowie") {
                    itemHp = parseInt($(tableRows[i]).find("td:eq(1)").text());
                }
            }
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

            totalWisdomFromItems+=itemWisdom;
            totalStrengthFromItems+=itemStrength;
            totalHPfromItems+=itemHp;

            // alert("ta tarcza przy zakladaniu ma zycia "+itemHealth)
            totalDmgFromItems += itemDmg;
            totalDodgeFromItems += itemDodge;
            totalHealthFromItems += itemHealth;
            calculateStats();
            let eItemId=parseInt(document.getElementById("databaseId"+itemNumber).innerText);

            let newStrengthCalc=parseFloat(document.getElementById("strengthStatValue").innerText);
            let newWisdomCalc=parseFloat(document.getElementById("wisdomStatValue").innerText);
            let newHPCalc=parseFloat(document.getElementById("healthStatValue").innerText);

            $.post("/equipItem", {
                eItemId: eItemId,
                newStrengthCalc: newStrengthCalc,
                newWisdomCalc: newWisdomCalc,
                newHPCalc: newHPCalc,
            }, function (data) {

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).always(function () {
            });



        } else {
            alert("Nieprawidłowy przedmiot!");
        }

        //     alert(notes);

        e.dataTransfer.clearData();
    }


    function dragDropBag(e) {
        e.preventDefault();
        var data = e.dataTransfer.getData("text");

        let itemNumber = data.substring(4, 5);

        let element = document.getElementById(data);

        let fromHoldersToBag = false;

        if ($('#itemHolderTable').has(element).length) {
            fromHoldersToBag = true;
        }


        if ($(this).children().length == 0) {
            this.append(document.getElementById(data));
            $(this).children(':last').css({
                    "position": "absolute",
                    "left": "0px",
                    "top": "0px",
                    "margin-left": "0px",
                    "margin-top": "0px",
                }
            );


            let tBody = document.getElementById("table" + itemNumber).children;//get tbody from table


            let tableRows = tBody[0].children;//not first two rows //get all 2 rows


            if (fromHoldersToBag) {
                let itemDmg = 0;
                let itemHealth = 0;
                let itemDodge = 0;
                let itemWisdom = 0;
                let itemStrength = 0;
                let itemHp = 0;
                for (let i = 2; i < tableRows.length; i++) {
                    if ($(tableRows[i]).find("td:eq(0)").text() == "Obrażenia") {
                        itemDmg = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                    } else if ($(tableRows[i]).find("td:eq(0)").text() == "Życie") {
                        itemHealth = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                    } else if ($(tableRows[i]).find("td:eq(0)").text() == "Unik") {
                        itemDodge = parseFloat($(tableRows[i]).find("td:eq(1)").text());
                    } else if ($(tableRows[i]).find("td:eq(0)").text() == "Siła") {
                        itemStrength = parseInt($(tableRows[i]).find("td:eq(1)").text());
                    } else if ($(tableRows[i]).find("td:eq(0)").text() == "Mądrość") {
                        itemWisdom = parseInt($(tableRows[i]).find("td:eq(1)").text());
                    } else if ($(tableRows[i]).find("td:eq(0)").text() == "Zdrowie") {
                        itemHp = parseInt($(tableRows[i]).find("td:eq(1)").text());
                    }
                }
                document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) - itemStrength);
                document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) - itemWisdom);
                document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) - itemHp);

                totalWisdomFromItems-=itemWisdom;
                totalStrengthFromItems-=itemStrength;
                totalHPfromItems-=itemHp;

                totalDmgFromItems -= itemDmg;
                totalDodgeFromItems -= itemDodge;
                // alert("zdejmuje tarcze czyli odejmuje sobie zycia "+itemHealth)
                totalHealthFromItems -= itemHealth;


                calculateStats();

                let uItemId=parseInt(document.getElementById("databaseId"+itemNumber).innerText);

                let newStrengthCalc=parseFloat(document.getElementById("strengthStatValue").innerText);
                let newWisdomCalc=parseFloat(document.getElementById("wisdomStatValue").innerText);
                let newHPCalc=parseFloat(document.getElementById("healthStatValue").innerText);

                // alert("ILE MAM TERAZ HP? "+newHPCalc);


                $.post("/unequipItem", {
                    uItemId: uItemId,
                    newStrengthCalc: newStrengthCalc,
                    newWisdomCalc: newWisdomCalc,
                    newHPCalc: newHPCalc,
                }, function (data) {
                }).done(function () {
                }).fail(function (xhr, textStatus, errorThrown) {
                }).always(function () {
                });




            }




        }
        e.dataTransfer.clearData();
    }


    $(".item").hover(
        function (evt) {

            $(this).css({
                    "background": "darkgray",
                    "cursor": "move"
                }
            );

            $(this).children("div").css("z-index","300");
            $(this).children("div").show(30);

        }, function (evt) {
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

            document.getElementById("strengthStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userStrength").innerText) * dodgeCalc + totalDodgeFromItems, 2);
            document.getElementById("wisdomStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) * dmgCalc + totalDmgFromItems, 2);
            document.getElementById("healthStatValue").innerText = "" + roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc + totalHealthFromItems, 2);
            // alert("total PUNKTY(trenowane) zycia from items po zdjeciu=0 "+totalHPfromItems);
            // alert("total zycie from items po zdjeciu =0 "+totalHealthFromItems);


        } else {
            let dodgeCalc = parseFloat(document.getElementById("dodgeCalc").innerText);
            let dmgCalc = parseFloat(document.getElementById("dmgCalc").innerText);
            let hpCalc = parseFloat(document.getElementById("hpCalc").innerText);

            document.getElementById("strengthStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userStrength").innerText) * dmgCalc + totalDmgFromItems, 2);
            document.getElementById("wisdomStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userWisdom").innerText) * dodgeCalc + totalDodgeFromItems, 2);
            document.getElementById("healthStatValue").innerText = roundToPlaces(parseFloat(document.getElementById("userHPs").innerText) * hpCalc + totalHealthFromItems, 2);

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
            document.getElementById("hpCost").innerText = pointCostList[newHealthValue - totalHPfromItems-1].textContent;
            calculateStats();
            newHealthValue=newHealthValue-totalHPfromItems;
            $.post("/trainHp", {
                newUserGold: newUserGold,
                newHealthValue: newHealthValue,
            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).always(function () {//bylo complete
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
            document.getElementById("wisdomCost").innerText = pointCostList[newWisdomValue - totalWisdomfromItems- 1].textContent;
            calculateStats();
            newWisdomValue=newWisdomValue - totalWisdomfromItems;
            $.post("/trainWisdom", {
                newUserGold: newUserGold,
                newWisdomValue: newWisdomValue,

            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).always(function () {
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
            document.getElementById("strengthCost").innerText = pointCostList[newStrengthValue -totalStrengthFromItems- 1].textContent;
            calculateStats();
            newStrengthValue=newStrengthValue-totalStrengthFromItems;
            $.post("/trainStrength", {
                newUserGold: newUserGold,
                newStrengthValue: newStrengthValue,

            }, function (data) {

                var json = JSON.parse(data);

            }).done(function () {
            }).fail(function (xhr, textStatus, errorThrown) {
            }).always(function () {//bylo complete
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
    function calculateStatsWithEquippedItems() {

        let totalEqWisdom=0;
        let totalEqStrength=0;
        let totalEqHP=0;
        let totalEqDmg=0;
        let totalEqHealth=0;
        let totalEqDodge=0;
        if (document.getElementById("bootsHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;

            if (document.getElementById("equippedBootsStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedBootsStrength").innerText)
            }
            if (document.getElementById("equippedBootsWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedBootsWisdom").innerText)
            }
            if (document.getElementById("equippedBootsHP") != null) {
                itemHp = parseInt(document.getElementById("equippedBootsHP").innerText)
            }
            if (document.getElementById("equippedBootsDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedBootsDmg").innerText)
            }
            if (document.getElementById("equippedBootsHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedBootsHealth").innerText)
            }
            if (document.getElementById("equippedBootsDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedBootsDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;
            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

        }
        if (document.getElementById("shieldHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;
            if (document.getElementById("equippedShieldStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedShieldStrength").innerText)
            }
            if (document.getElementById("equippedShieldWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedShieldWisdom").innerText)
            }
            if (document.getElementById("equippedShieldHP") != null) {
                itemHp = parseInt(document.getElementById("equippedShieldHP").innerText)
            }
            if (document.getElementById("equippedShieldDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedShieldDmg").innerText)
            }
            if (document.getElementById("equippedShieldHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedShieldHealth").innerText)
            }
            if (document.getElementById("equippedShieldDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedShieldDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;

            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

        }
        if (document.getElementById("helmetHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;
            if (document.getElementById("equippedHelmetStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedHelmetStrength").innerText)
            }
            if (document.getElementById("equippedHelmetWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedHelmetWisdom").innerText)
            }
            if (document.getElementById("equippedHelmetHP") != null) {
                itemHp = parseInt(document.getElementById("equippedHelmetHP").innerText)
            }
            if (document.getElementById("equippedHelmetDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedHelmetDmg").innerText)
            }
            if (document.getElementById("equippedHelmetHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedHelmetHealth").innerText)
            }
            if (document.getElementById("equippedHelmetDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedHelmetDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;

            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

        }
        if (document.getElementById("weaponHolder").children.length > 1) {

            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;
            if (document.getElementById("equippedWeaponStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedWeaponStrength").innerText)
            }
            if (document.getElementById("equippedWeaponWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedWeaponWisdom").innerText)
            }
            if (document.getElementById("equippedWeaponHP") != null) {
                itemHp = parseInt(document.getElementById("equippedWeaponHP").innerText)
            }
            if (document.getElementById("equippedWeaponDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedWeaponDmg").innerText)
            }
            if (document.getElementById("equippedWeaponHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedWeaponHealth").innerText)
            }
            if (document.getElementById("equippedWeaponDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedWeaponDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;

            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);
        }
        if (document.getElementById("necklaceHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;
            if (document.getElementById("equippedNecklaceStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedNecklaceStrength").innerText)
            }
            if (document.getElementById("equippedNecklaceWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedNecklaceWisdom").innerText)
            }
            if (document.getElementById("equippedNecklaceHP") != null) {
                itemHp = parseInt(document.getElementById("equippedNecklaceHP").innerText)
            }
            if (document.getElementById("equippedNecklaceDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedNecklaceDmg").innerText)
            }
            if (document.getElementById("equippedNecklaceHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedNecklaceHealth").innerText)
            }
            if (document.getElementById("equippedNecklaceDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedNecklaceDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;
            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

        }
        if (document.getElementById("gauntletHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;


            if (document.getElementById("equippedGauntletStrength") != null) {
                itemStrength = parseInt(document.getElementById("equippedGauntletStrength").innerText)
            }
            if (document.getElementById("equippedGauntletWisdom") != null) {
                itemWisdom = parseInt(document.getElementById("equippedGauntletWisdom").innerText)
            }
            if (document.getElementById("equippedGauntletHP") != null) {
                itemHp = parseInt(document.getElementById("equippedGauntletHP").innerText)
            }
            if (document.getElementById("equippedGauntletDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedGauntletDmg").innerText)
            }
            if (document.getElementById("equippedGauntletHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedGauntletHealth").innerText)
            }
            if (document.getElementById("equippedGauntletDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedGauntletDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;
            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText) + itemStrength);
            document.getElementById("userWisdom").innerText = "" + (parseInt(document.getElementById("userWisdom").innerText) + itemWisdom);
            document.getElementById("userHPs").innerText = "" + (parseInt(document.getElementById("userHPs").innerText) + itemHp);

        }
        if (document.getElementById("ringHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;
            if(document.getElementById("equippedRingStrength")!=null)
            {
                itemStrength =parseInt(document.getElementById("equippedRingStrength").innerText)
            }
            if(document.getElementById("equippedRingWisdom")!=null)
            {
                itemWisdom=parseInt(document.getElementById("equippedRingWisdom").innerText)
            }
            if(document.getElementById("equippedRingHP")!=null)
            {
                itemHp=parseInt(document.getElementById("equippedRingHP").innerText)
            }
            if (document.getElementById("equippedRingDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedRingDmg").innerText)
            }
            if (document.getElementById("equippedRingHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedRingHealth").innerText)
            }
            if (document.getElementById("equippedRingDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedRingDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;
            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;
            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText)+itemStrength);
            document.getElementById("userWisdom").innerText =  "" + (parseInt(document.getElementById("userWisdom").innerText)+itemWisdom);
            document.getElementById("userHPs").innerText =  "" + (parseInt(document.getElementById("userHPs").innerText)+itemHp);

        }
        if (document.getElementById("plateHolder").children.length > 1) {
            let itemWisdom = 0;
            let itemStrength = 0;
            let itemHp = 0;
            let thisItemDmg=0;
            let thisItemHealth=0;
            let thisItemDodge=0;

            if(document.getElementById("equippedPlateStrength")!=null)
            {
                itemStrength =parseInt(document.getElementById("equippedPlateStrength").innerText)
            }
            if(document.getElementById("equippedPlateWisdom")!=null)
            {
                itemWisdom=parseInt(document.getElementById("equippedPlateWisdom").innerText)
            }
            if(document.getElementById("equippedPlateHP")!=null)
            {
                itemHp=parseInt(document.getElementById("equippedPlateHP").innerText)
            }
            if (document.getElementById("equippedPlateDmg") != null) {
                thisItemDmg = parseFloat(document.getElementById("equippedPlateDmg").innerText)
            }
            if (document.getElementById("equippedPlateHealth") != null) {
                thisItemHealth = parseFloat(document.getElementById("equippedPlateHealth").innerText)
            }
            if (document.getElementById("equippedPlateDodge") != null) {
                thisItemDodge = parseFloat(document.getElementById("equippedPlateDodge").innerText)
            }
            totalEqDmg+=thisItemDmg;
            totalEqHealth+=thisItemHealth;
            totalEqDodge+=thisItemDodge;

            totalEqWisdom+=itemWisdom;
            totalEqStrength+=itemStrength;
            totalEqHP+=itemHp;

            document.getElementById("userStrength").innerText = "" + (parseInt(document.getElementById("userStrength").innerText)+itemStrength);
            document.getElementById("userWisdom").innerText =  "" + (parseInt(document.getElementById("userWisdom").innerText)+itemWisdom);
            document.getElementById("userHPs").innerText =  "" + (parseInt(document.getElementById("userHPs").innerText)+itemHp);

        }

        totalDmgFromItems += totalEqDmg;
        totalDodgeFromItems += totalEqDodge;
        totalHealthFromItems += totalEqHealth;
        totalWisdomFromItems+=totalEqWisdom;
        totalStrengthFromItems+=totalEqStrength;
        totalHPfromItems+=totalEqHP;

    }


});


