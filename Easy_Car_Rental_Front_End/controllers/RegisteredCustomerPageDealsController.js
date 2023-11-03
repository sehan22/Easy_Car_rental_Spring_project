loadAllRegisteredCarsForDeals();
getCustomerIdFromUserName();

function loadAllRegisteredCarsForDeals() {
    var data1 = localStorage.getItem("customerNameDB");

    $("#loginOrSignUpButtonText").text(data1);

    $('#registeredCarDetailsTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/car',
        dataType: 'json',
        success: function (resp) {
            for (let car of resp.data) {
                console.log("car : ", car.carId);

                if (car.carStatus === "AVAILABLE") {
                    $('#carIdContainer').append(`<div class="carCard col-lg-4 mb-5" style="width: 30%; height: 580px">
                    <div id="carouselExample" class="carousel slideh h-50 w-100 rounded-bottom-5 rounded-top-4" style="object-fit: scale-down; background: rgba(255, 255, 255, 0.5)">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img src="${car.carFrontViewImgFilePath}" style="object-fit: scale-down" class="d-block w-100" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="${car.carBackViewImgFilePath}" class="d-block w-100" style="object-fit: scale-down" alt="...">
                            </div>
                            <div class="carousel-item">
                                <img src="${car.carSideViewImgFilePath}" style="object-fit: scale-down" class="d-block w-100" alt="...">
                            </div>   
                                <div class="carousel-item">
                                <img src="${car.carInteriorViewImgFilePath}" style="object-fit: scale-down" class="d-block w-100" alt="...">
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>

                    <div style="margin-top: -50px">
                        <div class="w-100">
                            <h2 class="visually-hidden">` + car.carId + `</h2>
                            <h2 class="text-center carCarTitle">` + car.carBrand + `</h2>
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
                                    <h4 class="carCarToneListTopic">Waiver Payment</h4>
                                </li>
                                <li>
                                    <h4 style="font-weight: 700">Rs. ` + car.waiverPaymentAmount + `</h4>
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
            }

            $('.btnAddToReservation').click(function () {
                let carCardClick = $(this).parent().parent().children(":eq(0)").children(":eq(0)").text();
                console.log(carCardClick);
                console.log("============")

                let cars = $(resp.data)

                for (let i = 0; i < cars.length; i++) {
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

                        let row =
                            `<tr>
                                    <td class="visually-hidden">${cardCarId}</td>
                                    <td>${cardCarBrand}</td>
                                    <td><input class="form-check-input form-check form-switch border rounded" type="checkbox" id="flexSwitchCheckDefault"></td>
                                    <td>${cardWaiverPaymentAmount}</td>
                                    <td><button type="button" class="btn btn-outline-secondary carRentRequestDelete">Remove</button></td>
                                </tr>`;
                        alert("Add to Resrvation Successfully");
                        $('#rentRequestsTable').append(row);
                    }
                }
            });

        },
        error: function (err) {
            console.log(err.message);
        }
    });
}

function getCustomerIdFromUserName() {
    /*ajax for customer id search from name*/

}

$("#btnRentRequestFormRequest").click(function () {
    var customerUserName = localStorage.getItem("customerNameDB");

    $.ajax({
        url: `http://localhost:8080/easycarrental/customer?userName=${customerUserName}`,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let customer = resp.data;
            console.log("customer id for username", customer.cusId);

            console.log("Clicked");
            let rentDetails = [];

            let i = 1;


            $("#rentRequestsTable > tr").each(function () {


                let carId = $(this).find('td').eq(0).text();
                console.log(carId);

                let rentRequestId = $("#RentRequestId").val();

                var currentDate = new Date();
                var dateString = currentDate.toLocaleDateString();
                var timeString = currentDate.toLocaleTimeString();

                let payment = {
                    paymentId: "P00-00" + i,
                    paymentDate: null,
                    paymentTime: null,
                    distance: null,
                    waiverPaymentAmount: null,
                    extraMileagePerKM: null,
                    lossDamageWaiverPayment: null,
                    waiverPaymentBalance: null,
                    paymentStatus: null,
                    waiverPaymentBillFilePath: null
                }
                i = i + 1;

                var rentDetail = {
                    rentRequestId: rentRequestId,
                    carId: carId,
                    driverId: "DRI-001",
                    payment: payment
                }
                rentDetails.push(rentDetail);
            });

            let rentRequestId = $("#RentRequestId").val();
            let pickUpTime = $("#pickUpTime").val();
            let pickUpDate = $("#pickUpDate").val();
            let returnDate = $("#returnDate").val();
            let rentStatus = "PENDING";
            let cusId = customer.cusId;

            let rentRequest = {
                rentRequestId: rentRequestId,
                pickUpTime: pickUpTime,
                pickUpDate: pickUpDate,
                returnDate: returnDate,
                rentStatus: rentStatus,
                cusId: cusId,
                rentDetails: rentDetails
            }

            console.log(rentRequest)

            $.ajax({
                url: 'http://localhost:8080/easycarrental/rent',
                method: "POST",
                contentType: "application/json",
                dataType: "json",
                data: JSON.stringify(rentRequest),
                success: function (res) {
                    alert(res.message);
                },
                error: function (error) {
                    console.log(error);
                }
            });
        },
        error: function (ob, statusText, error) {
            console.error(error)
        }
    });
});
