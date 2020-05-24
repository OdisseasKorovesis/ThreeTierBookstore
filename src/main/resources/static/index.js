$(document).ready(function () {    
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
                "<a href='/book.html?id=" + books[i].id + "'>" +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imageUrl +"'" +
                        "alt='Card image cap' /> " + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title' style='font-size: 11px; font-weight: bold;'>" + books[i].title + "</p>" +
                        "<p class='card-title' style='font-size: 10px;'>" + books[i].authorsCollection[0].firstName + " " 
                        + books[i].authorsCollection[0].lastName + "<br>" + (books[i].price / 100) + "$" + "</p>" +  
                    "</div>" +
                "</div>" +
            "</div>"
        );        
    }
    for(i = 0; i < books.length; i++) {        
        $(".card-deck.secondPage.mostSold").append(
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                "<a href='/book.html?id=" + books[i].id + "'>" +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imageUrl +"'" +
                        "alt='Card image cap' /> " + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title' style='font-size: 11px; font-weight: bold;'>" + books[i].title + "</p>" +
                        "<p class='card-title' style='font-size: 10px;'>" + books[i].authorsCollection[0].firstName + " " 
                        + books[i].authorsCollection[0].lastName + "<br>" + (books[i].price / 100) + "$" + "</p>" +  
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
                "<a href='/book.html?id=" + books[i].id + "'>" +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imageUrl +"'" +
                        "alt='Card image cap' /> " + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title' style='font-size: 11px; font-weight: bold;'>" + books[i].title + "</p>" +
                        "<p class='card-title' style='font-size: 10px;'>" + books[i].authorsCollection[0].firstName + " " 
                        + books[i].authorsCollection[0].lastName + "<br>" + (books[i].price / 100) + "$" + "</p>" +  
                    "</div>" +
                "</div>" +
            "</div>"
        );       
    }
    for(i = 0; i < books.length; i++) {        
        $(".card-deck.secondPage.mostRecent").append(
            "<div class='col-md-3' style='float:left;'>" +
                "<div class='card mt-2 mb-2 mostSoldCard'> " +
                "<a href='/book.html?id=" + books[i].id + "'>" +
                    "<img class='card-img-top img-fluid' " +
                        "src='" + books[i].imageUrl +"'" +
                        "alt='Card image cap' /> " + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                        "<p class='card-title' style='font-size: 11px; font-weight: bold;'>" + books[i].title + "</p>" +
                        "<p class='card-title' style='font-size: 10px;'>" + books[i].authorsCollection[0].firstName + " " 
                        + books[i].authorsCollection[0].lastName + "<br>" + (books[i].price / 100) + "$" + "</p>" +  
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


