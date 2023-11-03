let baseUrl = "http://localhost:8080/easycarrental/";

$("#btnRegisterNow").click(function () {
    var formData = new FormData($("#customerForm")[0]);
    $.ajax({
        url: 'http://localhost:8080/easycarrental/customer',
        method: "post",
        type: 'POST',
        async: true,
        contentType: false,
        processData: false,
        data: formData,
        success: function (res) {
            alert(res.message);
        },
        error: function (err) {
            let errMessage = JSON.parse(err.responseText);
            alert(errMessage.message)
        }
    });
});



