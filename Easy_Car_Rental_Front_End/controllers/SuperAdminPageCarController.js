/*save car*/
$('#btnCarFormRegisteredNow').click(function () {
    let carFormData = new FormData($('#CarForm')[0]);

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        method: "POST",
        async: true,
        contentType: false,
        processData: false,
        data: carFormData,
        success: function (res) {
            alert(res.message);
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});

$('#btnCarFormGetAll').click(function () {
    loadAllRegisteredCars();
});

/*load Registered Cars*/
function loadAllRegisteredCars() {
    $('#registeredCarDetailsTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        dataType: 'json',
        success: function (resp) {
            for (let car of resp.data) {
                let carRegRow = `<tr>
                        <td>` + car.carId + `</td>
                        <td>` + car.carBrand + `</td>
                        <td>` + car.carType + `</td>
                        <td>` + car.waiverPaymentAmount + `</td>
                        <td>` + car.carRegistraionNumber + `</td>
                        <td>` + car.transmissionType + `</td>
                        <td>` + car.numberOfPassengers + `</td>
                        <td>` + car.fuelType + `</td>
                        <td>` + car.carTone + `</td>
                        <td>` + car.priceForDailyRent + `</td>
                        <td>` + car.priceForMonthlyRent + `</td>
                        <td>` + car.freeMileageForPrice + `</td>
                        <td>` + car.priceForExtraKM + `</td>
                        <td>` + car.currentMileage + `</td>
                        <td>` + car.carStatus + `</td>
                        <td>` + car.carFrontViewImgFilePath + `</td>
                        <td>` + car.carBackViewImgFilePath + `</td>
                        <td>` + car.carSideViewImgFilePath + `</td>
                        <td>` + car.carInteriorViewImgFilePath + `</td>
                    </tr>`;
                $('#registeredCarDetailsTable').append(carRegRow)
            }
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}


$('#btnCarFormGetAll').click(function () {

});