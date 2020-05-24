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
    var booksByLanguage;
    var paramName = "language";
    $.ajax({
        url: "tier3/language/" + decodeURIComponent(getBookGenreFromUrl(paramName)),
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find books of this language!");
        },
        success: function (data) {
            booksByLanguage = data;            
            generateByGenreResults(booksByLanguage);
        }
    });
});

function getBookGenreFromUrl(paramName) {
    var results = new RegExp('[\?&]' + paramName + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}

function generateByGenreResults(booksByLanguage) {
    for(i = 0; i <= 3; i++) {$('.card-deck.firstRow').append(        
        "<div class='card'>" +
        "<a href='/book.html?id=" + booksByLanguage[0].id + "'>" +
        "<img class='card-img-top' src='" + booksByLanguage[0].imageUrl + "' alt='Card image cap'>" + "</a>" +
        "<div class='card-body' style='background-color: #CDD0C0'>" +
          "<h5 class='card-title'>" +  booksByLanguage[0].title + "</h5>" +
          "<p class='card-text'>" + booksByLanguage[0].authorsCollection[0].firstName + " " 
          + booksByLanguage[0].authorsCollection[0].lastName + "<br>" + (booksByLanguage[0].price / 100) + "$" + "</p>" +         
        "</div>" +        
      "</div>"
    )}
    for(i = 0; i <= 3; i++) {$('.card-deck.secondRow').append(        
        "<div class='card'>" +
        "<a href='/book.html?id=" + booksByLanguage[0].id + "'>" +
        "<img class='card-img-top' src='" + booksByLanguage[0].imageUrl + "' alt='Card image cap'>" + "</a>" +
        "<div class='card-body' style='background-color: #CDD0C0'>" +
          "<h5 class='card-title'>" +  booksByLanguage[0].title + "</h5>" +
          "<p class='card-text'>" + booksByLanguage[0].authorsCollection[0].firstName + " " 
          + booksByLanguage[0].authorsCollection[0].lastName + "<br>" + (booksByLanguage[0].price / 100) + "$" + "</p>" +              
        "</div>" +        
      "</div>"
    )}
    
    
}

function getQuoteOfTheDay(author) {    
    $('#quote').text(author.quote);
    $('#quoteAuthor').text(author.firstName + " " + author.lastName);
    $('#quoteImage').attr('src', author.imageUrl);
}