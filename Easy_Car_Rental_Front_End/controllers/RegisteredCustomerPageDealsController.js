function loadAllRegisteredCars() {
    $('#registeredCarDetailsTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        dataType: 'json',
        success: function (resp) {
            for (let car of resp.data) {


                if (car.carStatus === "AVAILABLE") {
                    // $('#maintainCarDetailsTable').append();
                }

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