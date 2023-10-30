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
        error: function (error) {
            alert(error.message);
        }
    });
});

// let baseUrl = "http://localhost:8080/easycarrental/";

/*
$("#btnRegisterNow").click(function () {
    let cusId = $('#txtCustomerId').val();
    let cusName = $('#txtCustomerName').val();
    let cusAddress = $('#txtCustomerAddress').val();
    let cusEmail = $('#txtCustomerEmail').val();
    let cusNicNumber = $('#txtCustomerNICNumber').val();
    let cusDrivingLicenseNumber = $('#txtCustomerDrivingLicenseNumber').val();
    let cusTelNumber = $('#txtCustomerTelNumber').val();
    let cusNicFrontFilePath = $('#customerFileNicFrontView').val();
    let cusNicBackFilePath = $('#customerFileNicBackView').val();
    let cusDrivingLicenseFrontFilePath = $('#customerFileLicenseFrontView').val();
    let cusDrivingLicenseBackFilePath = $('#customerFileLicenseBackView').val();
    let userName = $('#txtCustomerUserName').val();
    let userPassword = $('#txtCustomerUserAccountPassword').val();

    console.log(
        cusId, cusName, cusAddress, cusEmail, cusNicNumber, cusDrivingLicenseNumber, cusTelNumber, cusNicFrontFilePath, cusNicBackFilePath, cusDrivingLicenseFrontFilePath, cusDrivingLicenseBackFilePath, userName, userPassword
    );

    let customer = {
        cusId: cusId,
        cusName: cusName,
        cusAddress: cusAddress,
        cusEmail: cusEmail,
        cusNicNumber: cusNicNumber,
        cusDrivingLicenseNumber: cusDrivingLicenseNumber,
        cusTelNumber: cusTelNumber,
        user: {
            userName: userName,
            userPassword: userPassword,

        }
    }

    $.ajax({
        url: baseUrl + 'customer',
        method: 'post',
        dataType: "json",
        data: JSON.stringify(customer),
        contentType: 'application/json',
        success: function (resp) {
            alert(resp.message);

            let formData= new FormData($("#customerForm")[0]);

            $.ajax({
                url: baseUrl + "customer?cusId="+ cusId,
                method: "post",
                async: false,
                data: formData,
                contentType: false,
                processData: false,
                success: function (res) {
                    alert(res.message);
                },
                error: function (res) {
                    alert(res.message);
                }
            });
        },
        error: function (err) {
            alert(err.message);
        }
    });
});

$('#Img').click(function () {
    var fileInput = document.getElementById('fileCustomerFileNicFrontView');
    var file = fileInput.files[0];
    console.log(file);

    var formData = new FormData();
    formData.append('file', file);

    $.ajax({
        url: baseUrl + 'customer',
        type: 'POST',
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            document.getElementById('result').innerHTML = response;
        },
        error: function(error) {
            console.error(error);
        }
    });
});
*/



