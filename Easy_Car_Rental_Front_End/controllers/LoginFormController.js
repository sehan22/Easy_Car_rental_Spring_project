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
                console.log(users[i].userName, users[i].userPassword);
                if (users[i].userName === username) {
                    console.log(users[i].userName);
                    rightUsername = i;
                    break;
                }
            }

            if (rightUsername === -1) {
                alert("Invalid Username or Password!");
            } else {
                if (users[rightUsername].userPassword === password) {
                    /*username set to */
                    var cusUserNameDB = users[rightUsername].userName;
                    localStorage.setItem("customerNameDB", cusUserNameDB);

                    if (users[rightUsername].userRole === "CUSTOMER") {
                        window.open("../RegisterCustomerPage.html", "_self");
                    } else if (users[rightUsername].userRole === "ADMIN") {
                        window.open("../SuperAdminPage.html", "_self");
                    } else {
                        window.open("../DriverPage.html", "_self");
                    }
                } else {
                    alert("Invalid Username or Password!");
                }
            }

            /*            let users = resp.data;

                        let usernameInput = $("#txtUserName").val();
                        let passwordInput = $("#txtUserPassword").val();

                        let userFound = false;

                        for (let i = 0; i < users.length; i++) {
                            var user = users[i];
                            console.log(user.userRole, user.userName , user.userPassword)

                            if (user.username === usernameInput && user.password === passwordInput) {
                                userFound = true;
                                break;
                            }
                        }

                        if (user.userRole === "CUSTOMER" && userFound) {
                            alert("hi")
                            // console.log(user.userName, user.userPassword)
                            window.open("../RegisterCustomerPage.html", "_self");
                        } else if (user.userRole === "ADMIN" && userFound) {
                            window.open("../SuperAdminPage.html", "_self");
                        } else if (user.userRole === "DRIVER" && userFound) {
                            window.open("../DriverPage.html", "_self");
                        }*/
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}

$("#btnSignIn").click(function () {
    loadAllUsers();
});


