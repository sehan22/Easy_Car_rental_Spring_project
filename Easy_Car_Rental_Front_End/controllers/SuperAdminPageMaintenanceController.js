/*save Car Service*/
$('#btnServiceFormAddToRepair').click(function () {
/*    let serviceId = $('#txtServiceId').val();
    let serviceDate = $('#txtServiceDate').val();
    let carId = $('#txtServiceCarId').val();
    let mileageAtService = $('#txtCarMileageAtService').val();
    let nextServiceMileage = $('#txtCarNextServiceMileage').val();
    let serviceStatus = $('#txtCarServiceStatus').val();
    let serviceDetails = $('#txtCarServiceDetails').val();
    let serviceCost = $('#txtCarServiceCost').val();

    var maintenance = {
        serviceId: serviceId,
        serviceDate: serviceDate,
        carId: carId,
        mileageAtService: mileageAtService,
        nextServiceMileage: nextServiceMileage,
        serviceStatus: serviceStatus,
        serviceDetails: serviceDetails,
        serviceCost: serviceCost
    }*/
    $.ajax({
        url: 'http://localhost:8080/easycarrental/maintenance',
        method: "POST",
        data: $('#carMaintenanceForm').serialize(),
        // dataType: 'json',
        // contentType: "application/json",
        success: function (res) {
            alert(res.message);
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});


/*
maintainingDetailsTable
*/

/*load maintenances*/
$('#btnServiceFormGetAll').click(function () {
    loadRegisteredDrivers();
});

