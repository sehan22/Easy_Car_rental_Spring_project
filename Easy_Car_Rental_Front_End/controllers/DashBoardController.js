initiateUI();

function initiateUI() {
    clearAll();
    $("#homeContent").css("display", "block");
    setTheLastView();
}

function saveLastView(clickedID) {
    switch (clickedID) {
        case "homeContent":
            localStorage.setItem("view", "HOME");
            break;
        case "dealsContent":
            localStorage.setItem("view", "DEALS");
            break;
        case "myAccountContent":
            localStorage.setItem("view", "MYACCOUNT");
            break;
        case "reservations":
            localStorage.setItem("view", "RESERVATIONS");
            break;

        case "paymentsDetailsContent":
            localStorage.setItem("view", "PAYMENTS");
            break;
    }
}

function setTheLastView() {
    let view = localStorage.getItem("view");
    switch (view) {
        case "HOME":
            setView($("#homeContent"));
            break;
        case "DEALS":
            setView($("#dealsContent"));
            break;
        case "MYACCOUNT":
            setView($("#myAccountContent"));
            break;
        case "RESERVATIONS":
            setView($("#resrvationContent"));
            break;
        case "PAYMENTS":
            setView($("#paymentDetailsContent"));
            break;
        default:
            setView($("#homeContent"));
    }
}

function clearAll() {
    $("#homeContent,#dealsContent,#myAccountContent,#resrvationContent,#paymentDetailsContent").css('display', 'none');
}

function setView(viewOb) {
    clearAll();
    viewOb.css("display", "block");
    saveLastView(viewOb.get(0).id);
    console.log(viewOb.get(0).id);
}

$("#lnkHome").click(function () {
    setView($("#homeContent"));
});

$("#lnkDeals").click(function () {
    setView($("#dealsContent"));
});

$("#lnkMyAccount").click(function () {
    setView($("#myAccountContent"));
});

$("#lnkReservations").click(function () {
    setView($("#resrvationContent"));
});
$("#lnkPayments").click(function () {
    setView($("#paymentDetailsContent"));
});

/*
sitBannerContent
infoContainerBoxContent
aboutUsContainerContent
BookingDescriptionContainerContent
carCardContainersContent
businessDetailsContainerContent
descriptionsOfThanksContainerContent
contactUsContainerContent
*/

/*
homeContent
dealsContent
myAccountContent
resrvationContent
paymentDetailsContent
*/