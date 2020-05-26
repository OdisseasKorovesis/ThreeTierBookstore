//ajax call to get search results
$(document).ready(function () {
    var booksByKeyword;
    var paramName = "keyword";
    $.ajax({
        url: "tier3/search/" + decodeURIComponent(getKeywordFromUrl(paramName)),
        data: {
            format: 'json'
        },
        error: function () {
            alert("Something went wrong!");
        },
        success: function (data) {
            booksByKeyword = data;
            generateSearchResults(booksByKeyword);
            generateFilters(booksByKeyword);
            //filterResults();
        }
        // , to handle empty result set, to be created later on
        // statusCode: {
        //     204: displayNoResultsMessage()
        // } 
    });
});

//get the search parameters from the url
function getKeywordFromUrl(paramName) {
    var results = new RegExp('[\?&]' + paramName + '=([^&#]*)').exec(window.location.href);
    return results[1] || 0;
}

//generate search reults
function generateSearchResults(booksByKeyword) {
    for (i = 0; i < booksByKeyword.length; i++) {
        if (i <= booksByKeyword.length - 1 && i <= 3) {
            $('.card-deck.firstRow').append(
                "<div class='card' style='max-width: 176.25px; max-height:421.2px;'>" +
                "<a href='/book.html?id=" + booksByKeyword[i].id + "'>" +
                "<img class='card-img-top' src='" + booksByKeyword[i].imageUrl + "' alt='Card image cap'>" + "</a>" +
                "<div class='card-body' style='background-color: #CDD0C0'>" +
                "<p class='card-title' style='font-weight: bold;'>" + booksByKeyword[i].title + "</h5>" +
                "<p class='card-text'>" + booksByKeyword[i].authorsCollection[0].firstName + " "
                + booksByKeyword[i].authorsCollection[0].lastName + "<br>" + (booksByKeyword[i].price / 100) + "$" + "</p>" +
                "</div>" +
                "</div>")
        }
    }
    if (booksByKeyword.length > 4) {
        for (i = 4; i <= booksByKeyword.length; i++) {
            if (i <= booksByKeyword.length - 1 && i <= 7) {
                $('.card-deck.secondRow').append(
                    "<div class='card' style='max-width: 176.25px; max-height:421.2px;'>" +
                    "<a href='/book.html?id=" + booksByKeyword[i].id + "'>" +
                    "<img class='card-img-top' src='" + booksByKeyword[i].imageUrl + "' alt='Card image cap'>" + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                    "<p class='card-title' style='font-weight: bold;'>" + booksByKeyword[i].title + "</h5>" +
                    "<p class='card-text'>" + booksByKeyword[i].authorsCollection[0].firstName + " "
                    + booksByKeyword[i].authorsCollection[0].lastName + "<br>" + (booksByKeyword[i].price / 100) + "$" + "</p>" +
                    "</div>" +
                    "</div>")
            }
        }
      }
      if (booksByKeyword.length > 8) {
        for (i = 8; i <= booksByKeyword.length; i++) {
            if (i <= booksByKeyword.length - 1 && i <= 11) {
                $('.card-deck.thirdRow').append(
                    "<div class='card' style='max-width: 176.25px; max-height:421.2px;'>" +
                    "<a href='/book.html?id=" + booksByKeyword[i].id + "'>" +
                    "<img class='card-img-top' src='" + booksByKeyword[i].imageUrl + "' alt='Card image cap'>" + "</a>" +
                    "<div class='card-body' style='background-color: #CDD0C0'>" +
                    "<p class='card-title' style='font-weight: bold;'>" + booksByKeyword[i].title + "</h5>" +
                    "<p class='card-text'>" + booksByKeyword[i].authorsCollection[0].firstName + " "
                    + booksByKeyword[i].authorsCollection[0].lastName + "<br>" + (booksByKeyword[i].price / 100) + "$" + "</p>" +
                    "</div>" +
                    "</div>")
            }
        }
    }

}

//methods to retrieve lists of authors/publishers etc to be used as filter options
//for now they use dummy data
function getListOfAuthors(booksByKeyword) {
    var listOfAuthors = new Array();
    for (var j = 0; j < booksByKeyword.length; j++) {
        for (var k = 0; k < booksByKeyword[j].authorsCollection.length; k++) {
            var authorFullName = booksByKeyword[j].authorsCollection[k].firstName + " " + booksByKeyword[j].authorsCollection[k].lastName;
            listOfAuthors.push(authorFullName);
        }
        var uniqueAuthors = [];
        $.each(listOfAuthors, function (i, el) {
            if ($.inArray(el, uniqueAuthors) === -1) uniqueAuthors.push(el);
        });
    }    
    return uniqueAuthors
}

function getListOfPublishers(booksByKeyword) {
    var listOfPublishers = new Array();
    for (var j = 0; j < booksByKeyword.length; j++) {
        var publisherName = booksByKeyword[j].publisherId.name;
        listOfPublishers.push(publisherName);
    }
    var uniquePublishers = [];
        $.each(listOfPublishers, function (i, el) {
            if ($.inArray(el, uniquePublishers) === -1) uniquePublishers.push(el);
        });
    return uniquePublishers;

}

function getListOfYears(booksByKeyword) {
    var listOfYears = new Array();
    for (var j = 0; j < booksByKeyword.length; j++) {
        var publicationYear = booksByKeyword[j].publicationYear;
        listOfYears.push(publicationYear);
    }
    var uniqueYears = [];
        $.each(listOfYears, function (i, el) {
            if ($.inArray(el, uniqueYears) === -1) uniqueYears.push(el);
        });
    return uniqueYears;    
}

function getListOfLanguages(booksByKeyword) {
    var listOfLanguages = new Array();
    for (var j = 0; j < booksByKeyword.length; j++) {
        var language = booksByKeyword[j].languageId.name;
        listOfLanguages.push(language);
    }
    var uniqueLanguages = [];
        $.each(listOfLanguages, function (i, el) {
            if ($.inArray(el, uniqueLanguages) === -1) uniqueLanguages.push(el);
        });
    return uniqueLanguages;
}

function getMinMaxPrice(booksByKeyword) {
    var listOfPrices = new Array();
    for (var j = 0; j < booksByKeyword.length; j++) {
        var price = booksByKeyword[j].price;
        listOfPrices.push(price);
    }
    return listOfPrices;
}

function generateFilters(booksByKeyword) {
    var listOfAuthors = getListOfAuthors(booksByKeyword);
    for (var k = 0; k < listOfAuthors.length; k++) {
        console.log("inside list of authors");
        $('#authorFilter').append(
            "<label class='form-check'>" +
            "<input class='form-check-input' type='checkbox' name='author' value='" + listOfAuthors[k] + "'>" +
            "<span class='form-check-label'>" +
            listOfAuthors[k] +
            "</span>"
        )
        console.log("finished building list of authors");
    }
    var listOfPublishers = getListOfPublishers(booksByKeyword)
    for (var k = 0; k < listOfPublishers.length; k++) {
        $('#publisherFilter').append(
            "<label class='form-check'>" +
            "<input class='form-check-input' type='checkbox' value='" + listOfPublishers[k] + "'>" +
            "<span class='form-check-label'>" +
            listOfPublishers[k] +
            "</span>"
        )
    }
    var listOfYears = getListOfYears(booksByKeyword)
    for (var k = 0; k < listOfYears.length; k++) {
        $('#yearFilter').append(
            "<label class='form-check'>" +
            "<input class='form-check-input' type='checkbox' name='year' value='" + listOfYears[k] + "'>" +
            "<span class='form-check-label'>" +
            listOfYears[k] +
            "</span>"
        )
    }
    var listOfLanguages = getListOfLanguages(booksByKeyword)
    for (var k = 0; k < listOfLanguages.length; k++) {
        $('#languageFilter').append(
            "<label class='form-check'>" +
            "<input class='form-check-input' type='checkbox' value='" + listOfLanguages[k] + "'>" +
            "<span class='form-check-label'>" +
            listOfLanguages[k] +
            "</span>"
        )
    }
    var minMaxPrice = getMinMaxPrice(booksByKeyword)
    var sortedMinMaxPrice = minMaxPrice.sort();
    var slider = document.getElementById("myRange");
    var output = document.getElementById("showBar");
    // Display the default slider value
    $('#myRange').attr("min", sortedMinMaxPrice[0]);
    $('#myRange').attr("max", sortedMinMaxPrice[sortedMinMaxPrice.length - 1]);
    $('#myRange').attr("value", (sortedMinMaxPrice[0] + sortedMinMaxPrice[sortedMinMaxPrice.length - 1]) / 2);
    output.innerHTML = "Maximum Price: " + slider.value;
    // Update the current slider value (each time you drag the slider handle)
    slider.oninput = function () {
        output.innerHTML = "Maximum Price: " + this.value;
    }
}

// //filter results under construction
// function filterResults() {

//     $("input[name=author]").change(function () {
//         alert("form changed author");
//         $(this).attr("id", this.checked ? "selected" : "notSelected");
//         $('.card-text').each(function () {

//             if ($(this).text().indexOf($("input[name='author']").val()) == -1 && $("input[name='author']").attr('id') == "selected") {
//                 console.log("mpike")
//                 $(this).parent().parent().hide();
//             }
//             if ($(this).text().indexOf($("input[name='author']").val()) == -1 && $("input[name='author']").attr('id') == "notSelected") {
//                 console.log("mpike")
//                 $(this).parent().parent().show();
//             }
//         })
//     })
//     $("input[name=year]").change(function () {
//         alert("form changed year");
//         $(this).attr("id", this.checked ? "selected" : "notSelected");
//         $('.card-text').each(function () {

//             if ($(this).text().indexOf($("input[name='year']").val()) == -1 && $("input[name='year']").attr('id') == "selected") {
//                 console.log("mpike")
//                 $(this).parent().parent().hide();
//             }
//             if ($(this).text().indexOf($("input[name='year']").val()) == -1 && $("input[name='year']").attr('id') == "notSelected") {
//                 console.log("mpike")
//                 $(this).parent().parent().show();
//             }
//         })
//     })
// }









