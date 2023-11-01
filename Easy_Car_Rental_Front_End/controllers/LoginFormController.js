function loadAllUsers() {
    $.ajax({
        url: 'http://localhost:8080/easycarrental/login',
        dataType: 'json',
        success: function (resp) {

            let users = $(resp.data);

            let username = $('#txtUserName').val();
            let password = $('#txtUserPassword').val();

            let rightUsername = -1;

            console.log(users)

            for (let i = 0; i < users.length; i++) {
                if (users[i].userName === username) {
                    rightUsername = i;
                    break;
                }
            }

            if (rightUsername === -1) {
                alert("Invalid Username or Password !");
            } else {

                if (users[rightUsername].password === password) {

                    if (users[rightUsername].role === "CUSTOMER") {
                        window.open("../RegisterCustomerPage.html", "_self");
                    } else if (users[rightUsername].role === "ADMIN") {
                        window.open("../SuperAdminPage.html", "_self");
                    } else {
                        window.open("../DriverPage.html", "_self");
                    }
                } else {
                    alert("Invalid Username or Password !");
                }
            }

        },
        error: function (err) {
            console.log(err.message);
        }
    });
}

$("#btnSignIn").click(function () {
    loadAllUsers();
});


