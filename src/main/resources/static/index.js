// $(document).ready(function () {
//     console.log("ready!");
//     var allBooks;
//     $.ajax({
//         url: "/books",
//         success: function (data) {
//             books = data;
//             generateCarousel();
//         }
//     });
// });

var books = [
    {
        title: "title1",
        imgUrl: "https://www.politeianet.gr/components/com_virtuemart/shop_image/product/CA714A4EE7BE40E56725296587A3BD77.jpg",
        price: "1"
    },

    {
        title: "title2",
        imgUrl: "https://www.politeianet.gr/components/com_virtuemart/shop_image/product/4b4185ff-2b8a-40ba-9f9a-09742cbf7548.jpg",
        price: "2"
    },

    {
        title: "title3",
        imgUrl: "https://www.politeianet.gr/components/com_virtuemart/shop_image/product/FFCA4F11FAF219D388CB31EA0521F374.jpg",
        price: "3"
    },

    {
        title: "title4",
        imgUrl: "https://www.politeianet.gr/components/com_virtuemart/shop_image/product/E1CA211CAA067A0B66E4967EDD6092A3.jpg",
        price: "4"
    },

    
];

var quotes = [
    {
        author: "Pablo Neruda",
        quote: "Deny me bread, air, light, spring, but never your laughter for I would die.",
        imgUrl: "https://noijamdotcom.files.wordpress.com/2018/08/pablo-neruda-1.jpg?w=492"
    },

    {
        author: "Someone Else",
        quote: "Something mpiri mpiri mpouru. Something mpiri mpiri mpouru",
        imgUrl: "https://images.gr-assets.com/authors/1574217836p8/1455.jpg"
    },

    {
        author: "Someone Important",
        quote: "Something mpiri mpiri mpouru, but never your laughter for I would die.",
        imgUrl: "https://miro.medium.com/max/2880/1*B6dX-EgrT0GFXhxodLb53A.png"
    }
]

$(document).ready(function () {
    generateCarouselofMostSold(books);
    generateCarouselofMostRecent(books);
    getQuoteOfTheDay(quotes[Math.floor(Math.random() * quotes.length)]);    
});

function generateCarouselofMostSold(books) {
    var bookName;
    var imgUrl;
    var author;
    var price;    
    var i = 0;
    for(i = 0; i < books.length; i++) {        
        $(".card-deck.firstPage.mostSold").append(
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                "<a href='/3_tier_books/book.html'>" +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imgUrl +"'" +
                        "alt='Card image cap' /> " + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title'>" +books[i].title+ "</p>" +
                        "<p class='card-text'>" + books[i].price+ "</p>" +    
                    "</div>" +
                "</div>" +
            "</div>"
        );        
    }
    for(i = 0; i < books.length; i++) {   
        console.log("insidesecondfor");    
        $(".card-deck.secondPage.mostSold").append(
            
            
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imgUrl +"'" +
                        "alt='Card image cap' /> " +
                    "<div class='card-body'>" +
                        "<p class='card-title'>" +books[i].title+ "</p>" +
                        "<p class='card-text'>" + books[i].price+ "</p>" +    
                    "</div>" +
                "</div>" +
            "</div>"
        );
    }
    
}

function generateCarouselofMostRecent(books) {
    var bookName;
    var imgUrl;
    var author;
    var price;    
    var i = 0;
    for(i = 0; i < books.length; i++) {        
        $(".card-deck.firstPage.mostRecent").append(
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imgUrl +"'" +
                        "alt='Card image cap' /> " +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title'>" +books[i].title+ "</p>" +
                        "<p class='card-text'>" + books[i].price+ "</p>" +    
                    "</div>" +
                "</div>" +
            "</div>"
        );        
    }
    for(i = 0; i < books.length; i++) {   
        console.log("insidesecondfor");    
        $(".card-deck.secondPage.mostRecent").append(
            
            
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imgUrl +"'" +
                        "alt='Card image cap' /> " +
                    "<div class='card-body'>" +
                        "<p class='card-title'>" +books[i].title+ "</p>" +
                        "<p class='card-text'>" + books[i].price+ "</p>" +    
                    "</div>" +
                "</div>" +
            "</div>"
        );
    }
    
}

function getQuoteOfTheDay(quoteOfTheDay) {
    var author;
    var imgUrl;
    var quote;
    $('#quote').text(quoteOfTheDay.quote);
    $('#quoteAuthor').text(quoteOfTheDay.author);
    $('#quoteImage').attr('src', quoteOfTheDay.imgUrl);
}


