loadRegisteredDrivers();

/*save driver*/
$("#btnDriverFormRegisterNow").click(function () {
    var driverFormData = new FormData($("#DriverForm")[0]);
    $.ajax({
        url: 'http://localhost:8080/easycarrental/driver',
        method: "POST",
        async: true,
        contentType: false,
        processData: false,
        data: driverFormData,
        success: function (res) {
            alert(res.message);
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});

/*load Registered Drivers*/
function loadRegisteredDrivers() {
    $('#registeredDriverDetailsTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/driver',
        dataType: 'json',
        success: function (resp) {
            for (let drv of resp.data) {
                let regDriversRow = `<tr>
                    <td>` + drv.driverId + `</td>
                    <td>` + drv.driverNicNumber + `</td>
                    <td>` + drv.driverName + `</td>
                    <td>` + drv.driverAddress + `</td>
                    <td>` + drv.driverEmail + `</td>
                    <td>` + drv.driverDrivingLicenseNumber + `</td>
                    <td>` + drv.driverTelNumber + `</td>
                    <td>` + drv.driverNicFrontFilePath + `</td>
                    <td>` + drv.driverDrivingLicenseFrontFilePath + `</td>
                    <td>` + drv.user.userName + `</td>
                    <td>` + drv.user.userPassword + `</td>
                    <td>` + drv.driverStatus + `</td>
                </tr>`

                if (drv.driverStatus === "AVAILABLE") {
                    $('#availableDriverDetailsTable').append(regDriversRow);
                }

                if (drv.driverStatus === "OCCUPIED") {
                    $('#occupiedDriverDetailsTable').append(regDriversRow);
                }

                $('#registeredDriverDetailsTable').append(regDriversRow);
            }
            loadDataDriverTableToInput('registeredDriverDetailsTable');
            loadDataDriverTableToInput('availableDriverDetailsTable');
            loadDataDriverTableToInput('occupiedDriverDetailsTable');
            setValuesForDriverFormInputs("", "", "", "", "", "", "", "", "", "", "", "");
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}

$('#btnDriverFormCancel').click(function () {
    alert("Driver Registrations Canceled!");
    setValuesForDriverFormInputs("", "", "", "", "", "", "", "", "", "", "", "");
});


$('#btnDriverFormGeatAll').click(function () {
    loadRegisteredDrivers();
});

/*load table row data to input*/
function loadDataDriverTableToInput(driverTableId) {
    $('#' + driverTableId + '>tr').click(function () {
        let driverId = $(this).children(":eq(0)").text();
        let driverNicNumber = $(this).children(":eq(1)").text();
        let driverName = $(this).children(":eq(2)").text();
        let driverAddress = $(this).children(":eq(3)").text();
        let driverEmail = $(this).children(":eq(4)").text();
        let driverDrivingLicenseNumber = $(this).children(":eq(5)").text();
        let driverTelNumber = $(this).children(":eq(6)").text();

        //Image not working (not correct method)
        let divDvrNicView = $(this).children(":eq(7)").text();
        let divDvrLicenseView = $(this).children(":eq(8)").text();

        let driverUserName = $(this).children(":eq(9)").text();
        let driverPassword = $(this).children(":eq(10)").text();
        let driverStatus = $(this).children(":eq(11)").text();

        $('#txtDriverId').val(driverId);
        $('#txtDriverNicNumber').val(driverNicNumber);
        $('#txtDriverName').val(driverName);
        $('#txtDriverAddress').val(driverAddress);
        $('#txtDriverEmail').val(driverEmail);
        $('#txtDriverDrivingLicenseNumber').val(driverDrivingLicenseNumber);
        $('#txtDriverTelNumber').val(driverTelNumber);

        $('#divDvrNicView').val(divDvrNicView);
        $('#divDvrLicenseView').val(divDvrLicenseView);

        $('#txtDriverUserName').val(driverUserName);
        $('#txtDriverUserPassword').val(driverPassword);
        $('#txtDriverStatus').val(driverStatus);
    });
}

function setValuesForDriverFormInputs(driverId, driverNicNumber, driverName, driverAddress, driverEmail, driverDrivingLicenseNumber, driverTelNumber, driverStatus, driverNicFrontFilePath, driverDrivingLicenseFrontFilePath, driverUserName, driverPassword) {
    $('#txtDriverId').val(driverId);
    $('#txtDriverNicNumber').val(driverNicNumber);
    $('#txtDriverName').val(driverName);
    $('#txtDriverAddress').val(driverAddress);
    $('#txtDriverEmail').val(driverEmail);
    $('#txtDriverDrivingLicenseNumber').val(driverDrivingLicenseNumber);
    $('#txtDriverTelNumber').val(driverTelNumber);
    $('#txtDriverUserName').val(driverUserName);
    $('#txtDriverUserPassword').val(driverPassword);
    $('#txtDriverStatus').val(driverStatus);
}


