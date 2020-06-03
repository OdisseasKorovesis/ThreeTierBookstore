var username;
$(document).ready(function () {

    $.ajax({
        async: false,
        url: "tier3/userdetails",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Something went wrong!");
        },
        success: function (data) {
            username = data.username;
            console.log(data.username);
        }
    });
});

var user;
$(document).ready(function () {

    $.ajax({
        async: false,
        url: "tier3/user/" + username,
        data: {
            format: 'json'
        },
        error: function () {
            alert("Something went wrong!");
        },
        success: function (data) {
            user = data;
            console.log(user)
        }
    });
});

$(document).ready(function createAuthorSelect() {
    var userAddresses;
    $.ajax({
        url: "tier3/deliveryAddresses/" + user.id,
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any addresses!");
        },
        success: function (data) {
            userAddresses = data;
            generateAddressSelect(userAddresses);
        }
    });
});

function generateAddressSelect(userAddresses) {
    for (var i = 0; i < userAddresses.length; i++) {

        var userAddresses = [(userAddresses[i])];
        $('#addressSelect').append(
            "<option value= '" + JSON.stringify(userAddresses[i]) + "'>"
            + userAddresses[i].firstName + ", " + userAddresses[i].lastName + ", "
            + userAddresses[i].street + ", " + userAddresses[i].streetNumber + ", "
            + userAddresses[i].postalCode + ", " + userAddresses[i].province + ", "
            + userAddresses[i].country + ", " + userAddresses[i].phoneNumber
            + "</option>");
            userAddresses[i].userId = {id : user.id};
            console.log(userAddresses[i]);

    }


}

$(document).ready(function () {
    $('#addressForm').on('submit', function (event) {
        event.preventDefault();
        var formData = {};
        $('#addressForm').find(":input").each(function () {
            if (this.name !== "button") {
                formData[this.name] = $(this).val();                
            }
        })
        formData.userId = {id: user.id};               
        sessionStorage.setItem("orderAddress", formData);
        $.ajax({
            type: "POST",
            url: "tier3/deliveryAddress",
            data: JSON.stringify(formData),
            dataType: "json",
            contentType: "application/json;",
            statusCode: {
                201: function () {
                    alert("Delivery address added successfully");
                }
            }
        });
    });
    $('#addressSelectButton').on('click', function(event) {
        event.preventDefault();       
        sessionStorage.setItem("orderAddress", $('#addressSelect').val())
    })
    
    
})