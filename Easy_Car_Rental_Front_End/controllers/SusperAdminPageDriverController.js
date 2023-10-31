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
                    <td>` + drv.driverStatus + `</td>
                </tr>`
                $('#registeredDriverDetailsTable').append(regDriversRow);
            }
        }
    });
}

$('#btnDriverFormGeatAll').click(function () {
    loadRegisteredDrivers();
});