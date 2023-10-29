let baseUrl = "http://localhost:8080/easycarrental/customer";

$("#btnRegisterNow").click(function () {
    var formData = new FormData($("#customerRegistraionForm")[0]);
    $.ajax({
        url: "http://localhost:8080/easycarrental/customer",
        method: "post",
        data: $("#customerRegistraionForm").serialize(),
        async: true,
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            alert(error.message);
        }
    });
});