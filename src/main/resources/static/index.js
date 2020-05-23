$(document).ready(function () {
    console.log("ready!");
    var allBooks;
    $.ajax({
        url: "tier3/books",
        data: {
            format: 'json'
        },
        error: function() {
            alert("Could not find any books!");
        },
        success: function (data) {
            allBooks = data;
            generateCarouselofMostSold(allBooks);
            generateCarouselofMostRecent(allBooks);
        }
    });
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
                        "src='" + books[i].imageUrl +"'" +
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
                        "src='" + books[i].imageUrl +"'" +
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
                        "src='" + books[i].imageUrl +"'" +
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
                        "src='" + books[i].imageUrl +"'" +
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


