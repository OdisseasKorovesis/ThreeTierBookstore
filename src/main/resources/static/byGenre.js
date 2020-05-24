$(document).ready(function () {    
    var author;
    $.ajax({
        url: "tier3/quote",
        data: {
            format: 'json'
        },
        error: function() {
            alert("Could not find an author!");
        },
        success: function (data) {
            author = data;
            getQuoteOfTheDay(author);                            
        }
    });
});

$(document).ready(function () {
    var booksByGenre;
    var paramName = "genre";
    $.ajax({
        url: "tier3/genre/" + decodeURIComponent(getBookGenreFromUrl(paramName)),
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find books of this genre!");
        },
        success: function (data) {
            booksByGenre = data;            
            generateByGenreResults(booksByGenre);
        }
    });
});

function getBookGenreFromUrl(paramName) {
    var results = new RegExp('[\?&]' + paramName + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}

function generateByGenreResults(booksByGenre) {
    for(i = 0; i <= 3; i++) {$('.card-deck.firstRow').append(        
        "<div class='card'>" +
        "<a href='/book.html?id=" + booksByGenre[0].id + "'>" +
        "<img class='card-img-top' src='" + booksByGenre[0].imageUrl + "' alt='Card image cap'>" + "</a>" +
        "<div class='card-body' style='background-color: #CDD0C0'>" +
          "<h5 class='card-title'>" +  booksByGenre[0].title + "</h5>" +
          "<p class='card-text'>" + booksByGenre[0].authorsCollection[0].firstName + " " 
          + booksByGenre[0].authorsCollection[0].lastName + "<br>" + (booksByGenre[0].price / 100) + "$" + "</p>" +         
        "</div>" +        
      "</div>"
    )}
    for(i = 0; i <= 3; i++) {$('.card-deck.secondRow').append(        
        "<div class='card'>" +
        "<a href='/book.html?id=" + booksByGenre[0].id + "'>" +
        "<img class='card-img-top' src='" + booksByGenre[0].imageUrl + "' alt='Card image cap'>" + "</a>" +
        "<div class='card-body' style='background-color: #CDD0C0'>" +
          "<h5 class='card-title'>" +  booksByGenre[0].title + "</h5>" +
          "<p class='card-text'>" + booksByGenre[0].authorsCollection[0].firstName + " " 
          + booksByGenre[0].authorsCollection[0].lastName + "<br>" + (booksByGenre[0].price / 100) + "$" + "</p>" +              
        "</div>" +        
      "</div>"
    )}
    
    
}

function getQuoteOfTheDay(author) {    
    $('#quote').text(author.quote);
    $('#quoteAuthor').text(author.firstName + " " + author.lastName);
    $('#quoteImage').attr('src', author.imageUrl);
}