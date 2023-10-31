let baseUrl = "http://localhost:8080/easycarrental/";

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