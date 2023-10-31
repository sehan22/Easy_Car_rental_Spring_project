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