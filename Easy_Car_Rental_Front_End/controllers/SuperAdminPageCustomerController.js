loadRegisteredCustomers();

var cusFile1;

/*get all registered customers functions*/
function loadRegisteredCustomers() {
    $('#registeredCustomersTable').empty();
    $('#pendingCustomersTable').empty();
    $('#registeredAdnPendingCustomersTable').empty();

    $.ajax({
        url: 'http://localhost:8080/easycarrental/customer',
        dataType: 'json',
        success: function (resp) {
            for (let cus of resp.data) {
                let regCusRow = `<tr>
                    <td>` + cus.cusId + `</td>
                    <td>` + cus.cusName + `</td>
                    <td>` + cus.cusAddress + `</td>
                    <td>` + cus.cusEmail + `</td>
                    <td>` + cus.cusNicNumber + `</td>
                    <td>` + cus.cusDrivingLicenseNumber + `</td>
                    <td>` + cus.cusTelNumber + `</td>
                    <td>` + cus.cusNicFrontFilePath + `</td>
                    <td>` + cus.cusDrivingLicenseFrontFilePath + `</td>
                    <td>` + cus.user.status + `</td>
                    </tr>`;

                loadDataTableRowToInput('pendingCustomersTable');


                if (cus.user.status === 'PENDING_APPROVAL') {
                    $('#pendingCustomersTable').append(regCusRow);
                }

                if (cus.user.status === 'REGISTERED') {
                    $('#registeredCustomersTable').append(regCusRow);
                }

                $('#registeredAdnPendingCustomersTable').append(regCusRow);

            }
            loadDataTableRowToInput('pendingCustomersTable');
            loadDataTableRowToInput('registeredCustomersTable');
            loadDataTableRowToInput('registeredAdnPendingCustomersTable');
            setValuesForTextFields("", "", "", "", "", "", "", "", "", "");
        },
        error: function (err) {
            alert(err.message)
        }
    });
}

/*delete customer*/
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

$("#btnCustomerGetAll").click(function () {
    loadRegisteredCustomers();
});

$("#btnCustomerFormClear").click(function () {
    alert("Customer Registrations Canceled!");
    setValuesForTextFields("", "", "", "", "", "", "", "", "", "");
});

/*load data to table row to input*/
function loadDataTableRowToInput(customerTableId, cusNicFrontFilePath, cusDrivingLicensePath) {
    $('#' + customerTableId + '>tr').click(function () {
        let cusId = $(this).children(":eq(0)").text();
        let cusName = $(this).children(":eq(1)").text();
        let cusAddress = $(this).children(":eq(2)").text();
        let cusEmail = $(this).children(":eq(3)").text();
        let cusNicNumber = $(this).children(":eq(4)").text();
        let cusDrivingLicenseNumber = $(this).children(":eq(5)").text();
        let cusTelNumber = $(this).children(":eq(6)").text();
        let cusNicFrontFilePath = $(this).children(":eq(7)").text();
        let cusDrivingLicensePath = $(this).children(":eq(8)").text();
        let cusStatus = $(this).children(":eq(9)").text();

        $('#txtCusId').val(cusId);
        $('#txtCusName').val(cusName);
        $('#txtCusAddress').val(cusAddress);
        $('#txtCusEmail').val(cusEmail);
        $('#txtCusNicNumber').val(cusNicNumber);
        $('#txtCusDrivingLicenseNumber').val(cusDrivingLicenseNumber);
        $('#txtCusTelNumber').val(cusTelNumber);

        console.log(cusNicFrontFilePath,cusDrivingLicensePath)

        //Image not working (not correct method)

        console.log(cusNicFrontFilePath)
        $('#divCusNicView').css('background-image', "url( "+ cusNicFrontFilePath +")");
        $('#divCusLicenseView').css('background-image', "url( "+ cusDrivingLicensePath +")");


        $('#txtCusAccountStatus').val(cusStatus);
    });
}

function setValuesForTextFields(cusId, cusName, cusAddress, cusEmail, cusNicNumber, cusDrivingLicenseNumber, cusTelNumber, cusNicFrontFilePath, cusDrivingLicenseFrontFilePath, cusStatus) {
    $('#txtCusId').val(cusId);
    $('#txtCusName').val(cusName);
    $('#txtCusAddress').val(cusAddress);
    $('#txtCusEmail').val(cusEmail);
    $('#txtCusNicNumber').val(cusNicNumber);
    $('#txtCusDrivingLicenseNumber').val(cusDrivingLicenseNumber);
    $('#txtCusTelNumber').val(cusTelNumber);
    $('#txtCusAccountStatus').val(cusStatus);
    $('#divCusNicView').css('background-image', "");
    $('#divCusLicenseView').css('background-image', "");
}