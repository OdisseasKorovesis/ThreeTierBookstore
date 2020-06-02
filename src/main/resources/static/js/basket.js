var username;
$(document).ready(function () {

    $.ajax({
        async: false,
        url: "tier3/userdetails",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find books of this genre!");
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
            alert("Could not find books of this genre!");
        },
        success: function (data) {
            user = data;
            console.log(user)
        }
    });
});


$(document).ready(function () {
    var booksInBasket;
    $.ajax({
        url: "tier3/basketItems/" + user.id,
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find books of this genre!");
        },
        success: function (data) {
            booksInBasket = data;
            console.log(data);
            for (var i = 0; i < booksInBasket.length; i++) {
                console.log(booksInBasket[i].book);
                generatebooksInBasket(booksInBasket[i].book, data[i].quantity);

            }
            calcTotalPrice();

        }
    });
});

var itemCount = 0;
var totalPrice = 0;
function generatebooksInBasket(bookInBasket, quantity) {
    $('#itemsArea').append(
        '<div class="card mb-3" style="max-height: 200px; min-width: 100%; background-color: #CDD0C0;">' +
        '<div class="row no-gutters">' +
        '<div class="col-md-2">' +
        "<a href='/book.html?id=" + bookInBasket.id + "'>" +
        '<img src="' + bookInBasket.imageUrl + '" class="card-img" alt="..." style="max-height: 200px; max-width: 150px">' + "</a>" +
        '</div>' +
        '<div class="col-md-8">' +
        '<div class="card-body border-left border-right h-100">' +
        '<h5 class="card-title">' + bookInBasket.title + '</h5>' +
        '<p class="card-text">' + bookInBasket.authorsCollection[0].firstName + ' '
        + bookInBasket.authorsCollection[0].lastName + '</p>' +
        '<p class="card-text">' + bookInBasket.publisherId.name + '</p>' +
        '<button class="btn border text-white" style="background-color: #373737">Remove from basket</button>' +
        '</div>' +
        '</div>' +
        '<div class="col-md-2">' +
        '<div class="card-body h-100">' +
        '<p class="card-text">Unit Price: $' + (bookInBasket.price / 100) + '</p>' +
        '<label for="quantity">Quantity</label>' +
        '<input class="form-control" type="number" id="quantity" value=' + quantity + ' name="quantity" style="box-sizing: border-box;"/>' +
        '</div>' +
        '</div>' +
        '</div>' +
        '</div>'
    );
    itemCount = itemCount + quantity;
    totalPrice = totalPrice + ((bookInBasket.price / 100)*quantity);
}

function calcTotalPrice() {
    $('#itemCount').text(
        itemCount + " items are currently in your basket."
    );
    $('#totalPrice').text(
        "Your current total is: " + totalPrice
    )
}

