/*
lnlDashBoard
lnkCustomers
lnkCars
lnkDrivers
lnkRentalRequests
lnlRentals
lnkPayments
lnkMaintenance
lnlIncomeReports
btnAdminAccount
*/


/*
dashBoardContent
customersContent
carsContent
driversContent
rentalRequestsContent
rentalsContent
paymentsContent
maintenanceContent
incomeReportsContent
adminAccountContent
*/

initiateUI();

function initiateUI() {
    clearAll();
    $("#dashBoardContent").css("display", "block");
    setTheLastView();
}

function saveLastView(clickedID) {
    switch (clickedID) {
        case "dashBoardContent":
            localStorage.setItem("view", "DASHBOARD");
            break;
        case "customersContent":
            localStorage.setItem("view", "CUSTOMERS");
            break;
        case "carsContent":
            localStorage.setItem("view", "CARS");
            break;
        case "driversContent":
            localStorage.setItem("view", "DRIVERS");
            break;

        case "rentalRequestsContent":
            localStorage.setItem("view", "RENTALREQUESTS");
            break;

        case "rentalsContent":
            localStorage.setItem("view", "RENTALS");
            break;
        case "paymentsContent":
            localStorage.setItem("view", "PAYMENTS");
            break;
        case "maintenanceContent":
            localStorage.setItem("view", "MAINTENANCE");
            break;
        case "incomeReportsContent":
            localStorage.setItem("view", "INCOMEREPORTS");
            break;

        case "adminAccountContent":
            localStorage.setItem("view", "ADMINACCOUNT");
            break;
    }
}

function setTheLastView() {
    let view = localStorage.getItem("view");
    switch (view) {
        case "DASHBOARD":
            setView($("#dashBoardContent"));
            break;
        case "CUSTOMERS":
            setView($("#customersContent"));
            break;
        case "CARS":
            setView($("#carsContent"));
            break;
        case "DRIVERS":
            setView($("#driversContent"));
            break;
        case "RENTALREQUESTS":
            setView($("#rentalRequestsContent"));
            break;
        case "RENTALS":
            setView($("#rentalsContent"));
            break;
        case "PAYMENTS":
            setView($("#paymentsContent"));
            break;
        case "MAINTENANCE":
            setView($("#maintenanceContent"));
            break;
        case "INCOMEREPORTS":
            setView($("#incomeReportsContent"));
            break;
        case "ADMINACCOUNT":
            setView($("#adminAccountContent"));
            break;
        default:
            setView($("#dashBoardContent"));
    }
}

function clearAll() {
    $("#dashBoardContent,#customersContent,#carsContent,#driversContent,#rentalRequestsContent,#rentalsContent,#paymentsContent,#maintenanceContent,#incomeReportsContent,#adminAccountContent").css('display', 'none');
}

function setView(viewOb) {
    clearAll();
    viewOb.css("display", "block");
    saveLastView(viewOb.get(0).id);
    console.log(viewOb.get(0).id);
}

$("#lnlDashBoard").click(function () {
    setView($("#dashBoardContent"));
});

$("#lnkCustomers").click(function () {
    setView($("#customersContent"));
});

$("#lnkCars").click(function () {
    setView($("#carsContent"));
});

$("#lnkDrivers").click(function () {
    setView($("#driversContent"));
});
$("#lnkRentalRequests").click(function () {
    setView($("#rentalRequestsContent"));
});

$("#lnlRentals").click(function () {
    setView($("#rentalsContent"));
});

$("#lnkPayments").click(function () {
    setView($("#paymentsContent"));
});

$("#lnkMaintenance").click(function () {
    setView($("#maintenanceContent"));
});

$("#lnlIncomeReports").click(function () {
    setView($("#incomeReportsContent"));
});
$("#btnAdminAccount").click(function () {
    setView($("#adminAccountContent"));
});
