loadAllRegisteredCars();

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
            loadAllRegisteredCars();
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});

/*update car*/
$('#btnCarFormUpdate').click(function () {
    let updateCarFormData = new FormData($('#CarForm')[0]);

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        method: "POST",
        async: true,
        contentType: false,
        processData: false,
        data: updateCarFormData,
        success: function (res) {
            alert(res.message);
            loadAllRegisteredCars();
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});

/*delete car*/
$("#btnCarFormDelete").click(function () {
    let carId = $("#txtCarId").val();
    $.ajax({
        url: 'http://localhost:8080/easycarrental/car?carId=' + carId + '',
        method: "delete",
        dataType:"json",
        success: function (resp) {
            alert(resp.message);
            loadAllRegisteredCars();
        },
        error:function (error){
            alert(JSON.parse(error.responseText).message);
        }
    });
});

/*delete customerr*/
$("#btnCarFormDelete").click(function () {
    let cusId = $("#txtCusId").val();
    $.ajax({
        url: 'http://localhost:8080/easycarrental/customer?cusId=' + cusId + '',
        method: "delete",
        dataType:"json",
        success: function (resp) {
            alert(resp.message);
            loadAllRegisteredCars();
        },
        error:function (error){
            alert(JSON.parse(error.responseText).message);
        }
    });
});

$('#btnCarFormGetAll').click(function () {
    loadAllRegisteredCars();
});

$('#btnCarFormClear').click(function () {
    alert("Driver Registrations Canceled!");
    setValuesForCarFormInputs("", "", "", "","", "","", "","", "",)
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

                if (car.carStatus === "MAINTAIN") {
                    $('#maintainCarDetailsTable').append(carRegRow);
                } else if (car.carStatus === "RESERVED") {
                    $('#reservedCarDetailsTable').append(carRegRow);
                } else if (car.carStatus === "AVAILABLE") {
                    $('#availableCarDetailsTable').append(carRegRow);
                }
                $('#registeredCarDetailsTable').append(carRegRow);

                loadDataCarTableToInput('registeredCarDetailsTable');
                loadDataCarTableToInput('maintainCarDetailsTable');
                loadDataCarTableToInput('reservedCarDetailsTable');
                loadDataCarTableToInput('availableCarDetailsTable');
                setValuesForCarFormInputs("", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
            }
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}

function loadDataCarTableToInput(tableId) {
    $('#'+ tableId +'>tr').click(function () {
        let carId = $(this).children(":eq(0)").text();
        let carBrand = $(this).children(":eq(1)").text();
        let carType = $(this).children(":eq(2)").text();
        let waiverPaymentAmount = $(this).children(":eq(3)").text();
        let carRegistraionNumber = $(this).children(":eq(4)").text();
        let transmissionType = $(this).children(":eq(5)").text();
        let numberOfPassengers = $(this).children(":eq(6)").text();
        let fuelType = $(this).children(":eq(7)").text();
        let carTone = $(this).children(":eq(8)").text();
        let priceForDailyRent = $(this).children(":eq(9)").text();
        let priceForMonthlyRent = $(this).children(":eq(10)").text();
        let freeMileageForPrice = $(this).children(":eq(11)").text();
        let priceForExtraKM = $(this).children(":eq(12)").text();
        let currentMileage = $(this).children(":eq(13)").text();
        let carStatus = $(this).children(":eq(14)").text();
        let carFrontViewImgFilePath = $(this).children(":eq(15)").text();
        let carBackViewImgFilePath = $(this).children(":eq(16)").text();
        let carSideViewImgFilePath = $(this).children(":eq(17)").text();
        let carInteriorViewImgFilePath = $(this).children(":eq(18)").text();

        $('#txtCarId').val(carId);
        $('#txtCarBrand').val(carBrand);
        $('#txtCarType').val(carType);
        $('#txtWaiverPaymentAmount').val(waiverPaymentAmount);
        $('#txtCarRegistraionNumber').val(carRegistraionNumber);
        $('#txtTransmissionType').val(transmissionType);
        $('#txtNumberOfPassengers').val(numberOfPassengers);
        $('#txtFuelType').val(fuelType);
        $('#txtCarTone').val(carTone);
        $('#txtPriceForDailyRent').val(priceForDailyRent);
        $('#txtPriceForMonthlyRent').val(priceForMonthlyRent);
        $('#txtFreeMileageForPrice').val(freeMileageForPrice);
        $('#txtPriceForExtraKM').val(priceForExtraKM);
        $('#txtCurrentMileage').val(currentMileage);
        $('#txtCarStatus').val(carStatus);

        $('#carFrontView').val(carFrontViewImgFilePath);
        $('#carBackView').val(carBackViewImgFilePath);
        $('#carSideView').val(carSideViewImgFilePath);
        $('#carInteriorView').val(carInteriorViewImgFilePath);
    });
}

function setValuesForCarFormInputs(carId, carBrand, carType, waiverPaymentAmount, carRegistraionNumber, transmissionType, numberOfPassengers, fuelType, carTone, priceForDailyRent, priceForMonthlyRent, freeMileageForPrice, priceForExtraKM, currentMileage, carStatus) {
    $('#txtCarId').val(carId);
    $('#txtCarBrand').val(carBrand);
    $('#txtCarType').val(carType);
    $('#txtWaiverPaymentAmount').val(waiverPaymentAmount);
    $('#txtCarRegistraionNumber').val(carRegistraionNumber);
    $('#txtTransmissionType').val(transmissionType);
    $('#txtNumberOfPassengers').val(numberOfPassengers);
    $('#txtFuelType').val(fuelType);
    $('#txtCarTone').val(carTone);
    $('#txtPriceForDailyRent').val(priceForDailyRent);
    $('#txtPriceForMonthlyRent').val(priceForMonthlyRent);
    $('#txtFreeMileageForPrice').val(freeMileageForPrice);
    $('#txtPriceForExtraKM').val(priceForExtraKM);
    $('#txtCurrentMileage').val(currentMileage);
    $('#txtCarStatus').val(carStatus);
}
