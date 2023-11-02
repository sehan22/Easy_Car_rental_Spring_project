loadAllRegisteredCarsForDeals();

function loadAllRegisteredCarsForDeals() {
    $('#registeredCarDetailsTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        dataType: 'json',
        success: function (resp) {
            for (let car of resp.data) {
                console.log("car : ", car.carId);

                if (car.carStatus === "AVAILABLE") {
                    $('#carIdContainer').append(`<div class="carCard col-lg-4 mb-5" style="width: 30%; height: 580px">
                    <img class="h-50 w-100 rounded-bottom-5 rounded-top-4"
                         src="assets/images/index/home/thirdContainer/i8car.png"
                         style="object-fit: scale-down; background: rgba(255, 255, 255, 0.5)">

                    <div style="margin-top: -50px">
                        <div class="w-100">
                            <h2 class="visually-hidden">` + car.carId + `</h2>
                            <h2 class="text-center carCarTitle">BMW i8 Special Edition</h2>
                        </div>

                        <div>
                            <ul class="carCardUlList mt-3">
                                <li>
                                    <h4>Rs ` + car.priceForMonthlyRent + `.00</h4>
                                    <h5>Monthly Rate</h5>
                                </li>
                                <li>
                                    <h4>Rs ` + car.priceForDailyRent + `.00</h4>
                                    <h5>/Daily Rate</h5>
                                </li>
                                <li>
                                    <h4>Rs ` + car.priceForExtraKM + `.00</h4>
                                    <h5>/Price per Extra Km</h5>
                                </li>
                            </ul>
                        </div>

                        <div class="justify-content-center m-auto"
                             style="background: rgba(0, 0, 0, 0.10); height: 3px; width: 65%"></div>

                        <div>
                            <ul class="carCarToneList text-center" style="margin-left: -30px">
                                <li>
                                    <h4 class="carCarToneListTopic">Tone</h4>
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/whiteDot.png" alt="">
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/refDot.png" alt="">
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/blueDot.png" alt="">
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/greyDot.png" alt="">
                                </li>
                            </ul>
                        </div>

                        <div style="background: rgba(0, 0, 0, 0.10); height: 3px; width: 75%; margin: -5% auto auto auto;"></div>

                        <div>
                            <ul class="carCarMoreDetailsList mt-2">
                                <li>
                                    <img src="assets/images/index/home/thirdContainer/userIcon.png" alt="">
                                    <h5>Seats 2</h5>
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/fuelTypeIcon.png" alt="">
                                    <h5>Petrol</h5>
                                </li>

                                <li>
                                    <img src="assets/images/index/home/thirdContainer/transmissionTypeIcon.png"
                                         alt="">
                                    <h5>Autonmatic</h5>
                                </li>
                            </ul>
                        </div>

                        <div class="d-flex justify-content-center">
                            <button type="button" class="btn btnGradientPurple btnAddToReservation"
                                    style="color: #D1D7E0; margin-top: -5px">
                                Book Now
                                <img src="assets/images/index/banner/Arrow_Left_SM.png"></button>
                        </div>
                    </div>
                </div>`);

                }
                $('.btnAddToReservation').click(function () {
                    let carCardClick = $(this).parent().parent().children(":eq(0)").children(":eq(0)").text();
                    console.log(carCardClick);

                    let cars = $(resp.data)

                    for (let i = 0; i < cars.length; i++) {
                        console.log("wada")
                        if (cars[i].carId === carCardClick) {
                            let cardCarId = cars[i].carId;
                            // console.log(cardCarId)
                            let cardCarBrand = cars[i].carBrand;
                            let cardCarType = cars[i].carType;
                            let cardWaiverPaymentAmount = cars[i].waiverPaymentAmount;
                            let cardCarRegistraionNumber = cars[i].carRegistraionNumber;
                            let cardTransmissionType = cars[i].transmissionType;
                            let cardNumberOfPassengers = cars[i].numberOfPassengers;
                            let cardFuelType = cars[i].fuelType;
                            let cardCarTone = cars[i].carTone;
                            let cardPriceForDailyRent = cars[i].priceForDailyRent;
                            let cardPriceForMonthlyRent = cars[i].priceForMonthlyRent;
                            let cardFreeMileageForPrice = cars[i].freeMileageForPrice;
                            let cardPriceForExtraKM = cars[i].priceForExtraKM;
                            let cardCurrentMileage = cars[i].currentMileage;
                            let cardCarStatus = cars[i].carStatus;

                            alert("hi");

                            let row =
                                `<tr>
                                    <td class="visually-hidden">${cardCarId}</td>
                                    <td>${cardCarBrand}</td>
                                    <td><input class="form-check-input form-check form-switch border rounded" type="checkbox" id="flexSwitchCheckDefault"></td>
                                    <td>${cardWaiverPaymentAmount}</td>
                                    <td><input type="file" class="form-control" id="inputWaiverBillImg"></td>
                                    <td><button type="button" class="btn btn-danger carRentRequestDelete">Remove</button></td>
                                </tr>`;
                            $('#rentRequestsTable').append(row);
                        }
                    }
                });
            }

        },
        error: function (err) {
            console.log(err.message);
        }
    });
}
