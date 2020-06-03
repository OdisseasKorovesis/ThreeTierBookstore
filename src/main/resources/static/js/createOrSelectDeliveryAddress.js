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
            "<option value= '" + JSON.stringify(userAddresses) + "'>"
            + userAddresses[i].firstName + " " + userAddresses[i].lastName 
            + userAddresses[i].street + " " + userAddresses[i].streetNumber
            + userAddresses[i].postalCode + " " +  userAddresses[i].province
            + userAddresses[i].country + " " + userAddresses[i].phoneNumber            
            + "</option>");        
    }


}