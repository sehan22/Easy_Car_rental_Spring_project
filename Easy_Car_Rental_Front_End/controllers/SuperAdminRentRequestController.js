$('#btnGetAllRentRequests').click(function () {
    loadAllRentalRequests();
});

// loadAllRentalRequests();

function loadAllRentalRequests() {
    $.ajax({
        url: 'http://localhost:8080/easycarrental/rentrequest',
        dataType: 'json',
        success: function (resp) {

        },
        error: function (err) {
            console.log(err.message);
        }
    });
}
