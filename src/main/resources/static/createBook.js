$(document).ready(function () {
    $("#bookForm").on('submit', function (event) {
        console.log("pressed");
        event.preventDefault();
        var formData = {};
        $("#bookForm").find(":input").each(function () {
            formData[this.name] = $(this).val()
        })
        console.log(JSON.stringify(formData));
        $.ajax({
            type: "POST",
            url: "tier3/books",
            data: (JSON.stringify(formData)),
            dataType: "json",
            contentType: "application/json;",
            statusCode: {
                201: function () {
                    console.log(data);
                    alert("Book created successfully");                    
                }
            },
            error: function() {
                console.log(data);
                alert("Could not create book please try again!");
            }
                
            
        });
    });
});

$(document).ready(function createGenreSelect() {
    var allGenre;
    $.ajax({
        url: "tier3/genre",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any genre!");
        },
        success: function (data) {
            allGenre = data;
            generateGenreSelect(allGenre);
        }
    });
});

$(document).ready(function createLanguageSelect() {
    var allLanguages;
    $.ajax({
        url: "tier3/languages",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any languages!");
        },
        success: function (data) {
            allLanguages = data;
            generateLanguageSelect(allLanguages);
        }
    });
});

$(document).ready(function createPublisherSelect() {
    var allPublishers;
    $.ajax({
        url: "tier3/publishers",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any publishers!");
        },
        success: function (data) {
            allPublishers = data;
            generatePublisherSelect(allPublishers);
        }
    });
});

$(document).ready(function createAuthorSelect() {
    var allAuthors;
    $.ajax({
        url: "tier3/authors",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any authors!");
        },
        success: function (data) {
            allAuthors = data;
            generateAuthorSelect(allAuthors);
        }
    });
});

function generateGenreSelect(allGenre) {
    for (var i = 0; i < allGenre.length; i++)
        $('#genreId').append(
            "<option value= " + allGenre[i].id + ">" + allGenre[i].name + "</option>"
        )
}

function generateLanguageSelect(allLanguages) {
    for (var i = 0; i < allLanguages.length; i++)
        $('#languageId').append(
            "<option value= " + allLanguages[i].id + ">" + allLanguages[i].name + "</option>"
        )
}

function generatePublisherSelect(allPublishers) {
    for (var i = 0; i < allPublishers.length; i++)
        $('#publisherId').append(
            "<option value= " + allPublishers[i].id + ">" + allPublishers[i].name + "</option>"
        )
}

function generateAuthorSelect(allAuthors) {
    for (var i = 0; i < allAuthors.length; i++) {
        $('#authorsCollection').append(            
        "<option value= " + JSON.stringify(allAuthors[i]) + ">"
        + allAuthors[i].firstName + " " + allAuthors[i].lastName + "</option>");
        console.log( JSON.stringify(allAuthors[i]));
    }    
        
        
}